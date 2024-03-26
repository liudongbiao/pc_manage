package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 会员管理对象 ord_member
 * 
 * @author ruoyi
 * @date 2024-03-26
 */
public class OrdMember extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long memberId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phone;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 等级积分 */
    @Excel(name = "等级积分")
    private String gradePoint;

    /** 消费积分 */
    @Excel(name = "消费积分")
    private String consumPoint;

    public void setMemberId(Long memberId) 
    {
        this.memberId = memberId;
    }

    public Long getMemberId() 
    {
        return memberId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setGradePoint(String gradePoint) 
    {
        this.gradePoint = gradePoint;
    }

    public String getGradePoint() 
    {
        return gradePoint;
    }
    public void setConsumPoint(String consumPoint) 
    {
        this.consumPoint = consumPoint;
    }

    public String getConsumPoint() 
    {
        return consumPoint;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("memberId", getMemberId())
            .append("userName", getUserName())
            .append("phone", getPhone())
            .append("createTime", getCreateTime())
            .append("sex", getSex())
            .append("gradePoint", getGradePoint())
            .append("remark", getRemark())
            .append("consumPoint", getConsumPoint())
            .toString();
    }
}
