package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 消费规则对象 ord_rule
 * 
 * @author ruoyi
 * @date 2024-03-26
 */
public class OrdRule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long ruleId;

    /** 获得积分 */
    @Excel(name = "获得积分")
    private String consumPoint;

    /** 消费金额 */
    @Excel(name = "消费金额")
    private String consumMoney;

    public void setRuleId(Long ruleId) 
    {
        this.ruleId = ruleId;
    }

    public Long getRuleId() 
    {
        return ruleId;
    }
    public void setConsumPoint(String consumPoint) 
    {
        this.consumPoint = consumPoint;
    }

    public String getConsumPoint() 
    {
        return consumPoint;
    }
    public void setConsumMoney(String consumMoney) 
    {
        this.consumMoney = consumMoney;
    }

    public String getConsumMoney() 
    {
        return consumMoney;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ruleId", getRuleId())
            .append("consumPoint", getConsumPoint())
            .append("consumMoney", getConsumMoney())
            .toString();
    }
}
