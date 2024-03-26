package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OrdGoodsMapper;
import com.ruoyi.system.domain.OrdGoods;
import com.ruoyi.system.service.IOrdGoodsService;

/**
 * 商品Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-26
 */
@Service
public class OrdGoodsServiceImpl implements IOrdGoodsService 
{
    @Autowired
    private OrdGoodsMapper ordGoodsMapper;

    /**
     * 查询商品
     * 
     * @param goodsId 商品主键
     * @return 商品
     */
    @Override
    public OrdGoods selectOrdGoodsByGoodsId(Long goodsId)
    {
        return ordGoodsMapper.selectOrdGoodsByGoodsId(goodsId);
    }

    /**
     * 查询商品列表
     * 
     * @param ordGoods 商品
     * @return 商品
     */
    @Override
    public List<OrdGoods> selectOrdGoodsList(OrdGoods ordGoods)
    {
        return ordGoodsMapper.selectOrdGoodsList(ordGoods);
    }

    /**
     * 新增商品
     * 
     * @param ordGoods 商品
     * @return 结果
     */
    @Override
    public int insertOrdGoods(OrdGoods ordGoods)
    {
        ordGoods.setCreateTime(DateUtils.getNowDate());
        return ordGoodsMapper.insertOrdGoods(ordGoods);
    }

    /**
     * 修改商品
     * 
     * @param ordGoods 商品
     * @return 结果
     */
    @Override
    public int updateOrdGoods(OrdGoods ordGoods)
    {
        return ordGoodsMapper.updateOrdGoods(ordGoods);
    }

    /**
     * 批量删除商品
     * 
     * @param goodsIds 需要删除的商品主键
     * @return 结果
     */
    @Override
    public int deleteOrdGoodsByGoodsIds(Long[] goodsIds)
    {
        return ordGoodsMapper.deleteOrdGoodsByGoodsIds(goodsIds);
    }

    /**
     * 删除商品信息
     * 
     * @param goodsId 商品主键
     * @return 结果
     */
    @Override
    public int deleteOrdGoodsByGoodsId(Long goodsId)
    {
        return ordGoodsMapper.deleteOrdGoodsByGoodsId(goodsId);
    }
}
