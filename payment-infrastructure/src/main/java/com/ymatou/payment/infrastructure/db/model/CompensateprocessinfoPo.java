package com.ymatou.payment.infrastructure.db.model;

import java.util.Date;

public class CompensateprocessinfoPo {
    /**
     * BIGINT(19) 必填<br>
     * 
     */
    private Long compensateid;

    /**
     * VARCHAR(64) 必填<br>
     * 
     */
    private String correlateid;

    /**
     * VARCHAR(16) 必填<br>
     * 
     */
    private String appid;

    /**
     * VARCHAR(16)<br>
     * 
     */
    private String paytype;

    /**
     * VARCHAR(32) 必填<br>
     * 
     */
    private String methodname;

    /**
     * VARCHAR(256) 必填<br>
     * 
     */
    private String requesturl;

    /**
     * INTEGER(10) 默认值[((0))] 必填<br>
     * 
     */
    private Integer retrycount;

    /**
     * TIMESTAMP(23,3) 默认值[(getdate())] 必填<br>
     * 
     */
    private Date createdtime;

    /**
     * VARCHAR(64)<br>
     * 
     */
    private String processmachinename;

    /**
     * TIMESTAMP(23,3)<br>
     * 
     */
    private Date lastprocessedtime;

    /**
     * INTEGER(10) 默认值[((0))] 必填<br>
     * 
     */
    private Integer processstatus;

    /**
     * INTEGER(10)<br>
     * 
     */
    private Integer compensatetype;

    /**
     * BIGINT(19) 必填<br>
     */
    public Long getCompensateid() {
        return compensateid;
    }

    /**
     * BIGINT(19) 必填<br>
     */
    public void setCompensateid(Long compensateid) {
        this.compensateid = compensateid;
    }

    /**
     * VARCHAR(64) 必填<br>
     */
    public String getCorrelateid() {
        return correlateid;
    }

    /**
     * VARCHAR(64) 必填<br>
     */
    public void setCorrelateid(String correlateid) {
        this.correlateid = correlateid == null ? null : correlateid.trim();
    }

    /**
     * VARCHAR(16) 必填<br>
     */
    public String getAppid() {
        return appid;
    }

    /**
     * VARCHAR(16) 必填<br>
     */
    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    /**
     * VARCHAR(16)<br>
     */
    public String getPaytype() {
        return paytype;
    }

    /**
     * VARCHAR(16)<br>
     */
    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     */
    public String getMethodname() {
        return methodname;
    }

    /**
     * VARCHAR(32) 必填<br>
     */
    public void setMethodname(String methodname) {
        this.methodname = methodname == null ? null : methodname.trim();
    }

    /**
     * VARCHAR(256) 必填<br>
     */
    public String getRequesturl() {
        return requesturl;
    }

    /**
     * VARCHAR(256) 必填<br>
     */
    public void setRequesturl(String requesturl) {
        this.requesturl = requesturl == null ? null : requesturl.trim();
    }

    /**
     * INTEGER(10) 默认值[((0))] 必填<br>
     */
    public Integer getRetrycount() {
        return retrycount;
    }

    /**
     * INTEGER(10) 默认值[((0))] 必填<br>
     */
    public void setRetrycount(Integer retrycount) {
        this.retrycount = retrycount;
    }

    /**
     * TIMESTAMP(23,3) 默认值[(getdate())] 必填<br>
     */
    public Date getCreatedtime() {
        return createdtime;
    }

    /**
     * TIMESTAMP(23,3) 默认值[(getdate())] 必填<br>
     */
    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    /**
     * VARCHAR(64)<br>
     */
    public String getProcessmachinename() {
        return processmachinename;
    }

    /**
     * VARCHAR(64)<br>
     */
    public void setProcessmachinename(String processmachinename) {
        this.processmachinename = processmachinename == null ? null : processmachinename.trim();
    }

    /**
     * TIMESTAMP(23,3)<br>
     */
    public Date getLastprocessedtime() {
        return lastprocessedtime;
    }

    /**
     * TIMESTAMP(23,3)<br>
     */
    public void setLastprocessedtime(Date lastprocessedtime) {
        this.lastprocessedtime = lastprocessedtime;
    }

    /**
     * INTEGER(10) 默认值[((0))] 必填<br>
     */
    public Integer getProcessstatus() {
        return processstatus;
    }

    /**
     * INTEGER(10) 默认值[((0))] 必填<br>
     */
    public void setProcessstatus(Integer processstatus) {
        this.processstatus = processstatus;
    }

    /**
     * INTEGER(10)<br>
     */
    public Integer getCompensatetype() {
        return compensatetype;
    }

    /**
     * INTEGER(10)<br>
     */
    public void setCompensatetype(Integer compensatetype) {
        this.compensatetype = compensatetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PP_CompensateProcessInfo
     *
     * @mbggenerated Tue May 10 16:37:17 CST 2016
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", compensateid=").append(compensateid);
        sb.append(", correlateid=").append(correlateid);
        sb.append(", appid=").append(appid);
        sb.append(", paytype=").append(paytype);
        sb.append(", methodname=").append(methodname);
        sb.append(", requesturl=").append(requesturl);
        sb.append(", retrycount=").append(retrycount);
        sb.append(", createdtime=").append(createdtime);
        sb.append(", processmachinename=").append(processmachinename);
        sb.append(", lastprocessedtime=").append(lastprocessedtime);
        sb.append(", processstatus=").append(processstatus);
        sb.append(", compensatetype=").append(compensatetype);
        sb.append("]");
        return sb.toString();
    }
}