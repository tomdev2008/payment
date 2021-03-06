/**
 * (C) Copyright 2016 Ymatou (http://www.ymatou.com/).
 *
 * All rights reserved.
 */
package com.ymatou.payment.domain.channel.service.acquireorder;

import com.ymatou.payment.domain.channel.service.AcquireOrderService;
import com.ymatou.payment.facade.BizException;
import com.ymatou.payment.facade.ErrorCode;
import com.ymatou.payment.facade.constants.PayTypeEnum;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 收单报文工厂
 * 
 * @author wangxudong 2016年5月11日 下午6:10:33
 *
 */
@Component
public class AcquireOrderPackageFactory {

    @Resource
    private AliPayPcAcquireOrderServiceImpl aliPayPcAcquireOrderServiceImpl;

    @Resource
    private AliPayAppAcquireOrderServiceImpl aliPayAppAcquireOrderServiceImpl;

    @Resource
    private AliPayWapAcquireOrderServiceImpl aliPayWapAcquireOrderServiceImpl;

    @Resource
    private WeiXinAppAcquireOrderServiceImpl weiXinAppAcquireOrderServiceImpl;

    @Resource
    private WeiXinJSAPIAcquireOrderServiceImpl weiXinJSAPIAcquireOrderServiceImpl;

    @Resource
    private WeiXinPCAcquireOrderServiceImpl weiXinPCAcquireOrderServiceImpl;

    @Resource
    private CmbAcquireOrderServiceImpl cmbAcquireOrderServiceImpl;

    @Resource
    private ApplePayAcquireOrderServiceImpl applePayAcquireOrderService;

    /**
     * 获取到收单解析器
     * 
     * @param payType
     * @return
     */
    public AcquireOrderService getInstance(PayTypeEnum payType) {
        switch (payType) {
            case AliPayPc:
                return aliPayPcAcquireOrderServiceImpl;
            case AliPayApp:
                return aliPayAppAcquireOrderServiceImpl;
            case AliPayWap:
                return aliPayWapAcquireOrderServiceImpl;
            case WeiXinJSAPI:
                return weiXinJSAPIAcquireOrderServiceImpl;
            case WeiXinApp:
                return weiXinAppAcquireOrderServiceImpl;
            case WeiXinPc:
                return weiXinPCAcquireOrderServiceImpl;
            case CmbApp:
                return cmbAcquireOrderServiceImpl;
            case ApplePay:
                return applePayAcquireOrderService;
            default:
                throw new BizException(ErrorCode.INVALID_PAY_TYPE, payType.getCode());

        }
    }
}
