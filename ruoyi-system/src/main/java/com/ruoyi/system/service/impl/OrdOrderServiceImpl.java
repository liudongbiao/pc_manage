package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OrdOrderMapper;
import com.ruoyi.system.domain.OrdOrder;
import com.ruoyi.system.service.IOrdOrderService;

/**
 * 消费记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-26
 */
@Service
public class OrdOrderServiceImpl implements IOrdOrderService 
{
    @Autowired
    private OrdOrderMapper ordOrderMapper;

    /**
     * 查询消费记录
     * 
     * @param orderId 消费记录主键
     * @return 消费记录
     */
    @Override
    public OrdOrder selectOrdOrderByOrderId(Long orderId)
    {
        return ordOrderMapper.selectOrdOrderByOrderId(orderId);
    }

    /**
     * 查询消费记录列表
     * 
     * @param ordOrder 消费记录
     * @return 消费记录
     */
    @Override
    public List<OrdOrder> selectOrdOrderList(OrdOrder ordOrder)
    {
        return ordOrderMapper.selectOrdOrderList(ordOrder);
    }

    /**
     * 新增消费记录
     * 
     * @param ordOrder 消费记录
     * @return 结果
     */
    @Override
    public int insertOrdOrder(OrdOrder ordOrder)
    {
        return ordOrderMapper.insertOrdOrder(ordOrder);
    }

    /**
     * 修改消费记录
     * 
     * @param ordOrder 消费记录
     * @return 结果
     */
    @Override
    public int updateOrdOrder(OrdOrder ordOrder)
    {
        return ordOrderMapper.updateOrdOrder(ordOrder);
    }

    /**
     * 批量删除消费记录
     * 
     * @param orderIds 需要删除的消费记录主键
     * @return 结果
     */
    @Override
    public int deleteOrdOrderByOrderIds(Long[] orderIds)
    {
        return ordOrderMapper.deleteOrdOrderByOrderIds(orderIds);
    }

    /**
     * 删除消费记录信息
     * 
     * @param orderId 消费记录主键
     * @return 结果
     */
    @Override
    public int deleteOrdOrderByOrderId(Long orderId)
    {
        return ordOrderMapper.deleteOrdOrderByOrderId(orderId);
    }
}
