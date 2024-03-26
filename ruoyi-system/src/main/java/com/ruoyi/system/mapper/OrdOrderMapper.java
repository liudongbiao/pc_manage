package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.OrdOrder;

/**
 * 消费记录Mapper接口
 * 
 * @author ruoyi
 * @date 2024-03-26
 */
public interface OrdOrderMapper 
{
    /**
     * 查询消费记录
     * 
     * @param orderId 消费记录主键
     * @return 消费记录
     */
    public OrdOrder selectOrdOrderByOrderId(Long orderId);

    /**
     * 查询消费记录列表
     * 
     * @param ordOrder 消费记录
     * @return 消费记录集合
     */
    public List<OrdOrder> selectOrdOrderList(OrdOrder ordOrder);

    /**
     * 新增消费记录
     * 
     * @param ordOrder 消费记录
     * @return 结果
     */
    public int insertOrdOrder(OrdOrder ordOrder);

    /**
     * 修改消费记录
     * 
     * @param ordOrder 消费记录
     * @return 结果
     */
    public int updateOrdOrder(OrdOrder ordOrder);

    /**
     * 删除消费记录
     * 
     * @param orderId 消费记录主键
     * @return 结果
     */
    public int deleteOrdOrderByOrderId(Long orderId);

    /**
     * 批量删除消费记录
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrdOrderByOrderIds(Long[] orderIds);
}
