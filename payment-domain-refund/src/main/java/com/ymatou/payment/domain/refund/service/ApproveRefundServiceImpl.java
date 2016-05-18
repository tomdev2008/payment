/*
 * (C) Copyright 2016 Ymatou (http://www.ymatou.com/). All rights reserved.
 */
package com.ymatou.payment.domain.refund.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ymatou.payment.domain.refund.constants.ApproveStatusEnum;
import com.ymatou.payment.domain.refund.repository.RefundPository;
import com.ymatou.payment.facade.BizException;
import com.ymatou.payment.facade.ErrorCode;
import com.ymatou.payment.infrastructure.db.model.PpCompensateprocessinfoWithBLOBs;
import com.ymatou.payment.infrastructure.db.model.RefundrequestPo;
import com.ymatou.payment.integration.service.ymatou.NotifyRefundService;

/**
 * 
 * @author qianmin 2016年5月13日 下午12:00:33
 * 
 */
@Component
public class ApproveRefundServiceImpl implements ApproveRefundService {

    private static final Logger logger = LoggerFactory.getLogger(ApproveRefundServiceImpl.class);

    @Autowired
    private RefundPository refundPository;

    @Autowired
    private NotifyRefundService notifyRefundService;

    @Override
    public List<String> approveRefund(List<String> paymentIds, String approveUser) {
        List<RefundrequestPo> refundrequestPos = new ArrayList<>();
        List<PpCompensateprocessinfoWithBLOBs> compensateprocessinfos = new ArrayList<>();
        List<String> requriedNotifyRefundPaymentIds = new ArrayList<>();
        for (String paymentId : paymentIds) {
            RefundrequestPo refundrequestPo = refundPository.getRefundRequestByPaymentId(paymentId);
            if (refundrequestPo == null) {
                throw new BizException(ErrorCode.REFUND_REQUEST_NOT_EXIST, "refund request not exist.");
            }
            if (refundrequestPo.getApprovestatus() != ApproveStatusEnum.NOT_APPROVED.getCode()) {
                logger.info("RefundRequest ApproveStaus expected 0, but {}. PaymentId: {}",
                        refundrequestPo.getApprovestatus(), paymentId);
                continue;
            }

            requriedNotifyRefundPaymentIds.add(paymentId); // 需要通知退款的

            // 组装更新RefundRequest
            refundrequestPo.setApprovestatus(ApproveStatusEnum.APPROVED.getCode());
            refundrequestPo.setApprovedtime(new Date());
            refundrequestPo.setApproveduser(approveUser);
            refundrequestPos.add(refundrequestPo);

            // 组装新增PpCompensateprocessinfo
            PpCompensateprocessinfoWithBLOBs compensateprocessinfo = new PpCompensateprocessinfoWithBLOBs();
            compensateprocessinfo.setAppid("1");
            compensateprocessinfo.setCorrelateid(paymentId);
            compensateprocessinfo.setMethodname("Refund");
            compensateprocessinfo.setRequesturl("");
            compensateprocessinfo.setRequestdata(paymentId);
            compensateprocessinfo.setCompensatetype(1); // 退款
            compensateprocessinfos.add(compensateprocessinfo);
        }

        logger.info("update refundRequest status and save compensateprocessinfo.");
        refundPository.updateRefundRequestAndSaveCompensateprocessinfo(refundrequestPos,
                compensateprocessinfos);

        return requriedNotifyRefundPaymentIds;
    }

    @Override
    public void notifyRefund(List<String> paymentIds, HashMap<String, String> header) {

        try {
            for (String paymentId : paymentIds) {
                notifyRefundService.doService(paymentId, UUID.randomUUID().toString(), header); // TODO
            }
        } catch (Exception e) {
            // 异步通知发货
        }

    }


}