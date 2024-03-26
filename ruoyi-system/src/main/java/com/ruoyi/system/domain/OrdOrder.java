package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 消费记录对象 ord_order
 *
 * @author ruoyi
 * @date 2024-03-26
 */
public class OrdOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long orderId;

    /** 交易编号 */
    @Excel(name = "交易编号")
    private String tradeSn;

    /** 会员ID */
    @Excel(name = "会员ID")
    private Long memberId;

    /** 支付时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date paymentTime;

    /** 支付金额 */
    @Excel(name = "支付金额")
    private String payMoney;

    /** 获得积分 */
    @Excel(name = "获得积分")
    private String point;

    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public Long getOrderId()
    {
        return orderId;
    }
    public void setTradeSn(String tradeSn)
    {
        this.tradeSn = tradeSn;
    }

    public String getTradeSn()
    {
        return tradeSn;
    }
    public void setMemberId(Long memberId)
    {
        this.memberId = memberId;
    }

    public Long getMemberId()
    {
        return memberId;
    }
    public void setPaymentTime(Date paymentTime)
    {
        this.paymentTime = paymentTime;
    }

    public Date getPaymentTime()
    {
        return paymentTime;
    }
    public void setPayMoney(String payMoney)
    {
        this.payMoney = payMoney;
    }

    public String getPayMoney()
    {
        return payMoney;
    }
    public void setPoint(String point)
    {
        this.point = point;
    }

    public String getPoint()
    {
        return point;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("tradeSn", getTradeSn())
            .append("memberId", getMemberId())
            .append("paymentTime", getPaymentTime())
            .append("payMoney", getPayMoney())
            .append("point", getPoint())
            .toString();
    }
}
