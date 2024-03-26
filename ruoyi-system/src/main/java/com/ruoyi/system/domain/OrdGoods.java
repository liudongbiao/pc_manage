package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品对象 ord_goods
 *
 * @author ruoyi
 * @date 2024-03-26
 */
public class OrdGoods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long goodsId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String goodsName;

    /** 商品编号 */
    @Excel(name = "商品编号")
    private String sn;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private BigDecimal price;

    /** 成本价格 */
    @Excel(name = "成本价格")
    private BigDecimal cost;

    /** 上架状态 */
    @Excel(name = "上架状态")
    private String marketEnable;

    /** 积分 */
    @Excel(name = "积分")
    private String point;

    /** 修改时间 */
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModify;

    /** 缩略图 */
    @Excel(name = "缩略图")
    private String thumbnail;

    public void setGoodsId(Long goodsId)
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId()
    {
        return goodsId;
    }
    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getGoodsName()
    {
        return goodsName;
    }
    public void setSn(String sn)
    {
        this.sn = sn;
    }

    public String getSn()
    {
        return sn;
    }
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getPrice()
    {
        return price;
    }
    public void setCost(BigDecimal cost)
    {
        this.cost = cost;
    }

    public BigDecimal getCost()
    {
        return cost;
    }
    public void setMarketEnable(String marketEnable)
    {
        this.marketEnable = marketEnable;
    }

    public String getMarketEnable()
    {
        return marketEnable;
    }
    public void setPoint(String point)
    {
        this.point = point;
    }

    public String getPoint()
    {
        return point;
    }
    public void setLastModify(Date lastModify)
    {
        this.lastModify = lastModify;
    }

    public Date getLastModify()
    {
        return lastModify;
    }
    public void setThumbnail(String thumbnail)
    {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail()
    {
        return thumbnail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("goodsId", getGoodsId())
            .append("goodsName", getGoodsName())
            .append("sn", getSn())
            .append("price", getPrice())
            .append("cost", getCost())
            .append("marketEnable", getMarketEnable())
            .append("point", getPoint())
            .append("createTime", getCreateTime())
            .append("lastModify", getLastModify())
            .append("thumbnail", getThumbnail())
            .toString();
    }
}
