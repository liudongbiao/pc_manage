package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.OrdGoods;

/**
 * 商品Mapper接口
 * 
 * @author ruoyi
 * @date 2024-03-26
 */
public interface OrdGoodsMapper 
{
    /**
     * 查询商品
     * 
     * @param goodsId 商品主键
     * @return 商品
     */
    public OrdGoods selectOrdGoodsByGoodsId(Long goodsId);

    /**
     * 查询商品列表
     * 
     * @param ordGoods 商品
     * @return 商品集合
     */
    public List<OrdGoods> selectOrdGoodsList(OrdGoods ordGoods);

    /**
     * 新增商品
     * 
     * @param ordGoods 商品
     * @return 结果
     */
    public int insertOrdGoods(OrdGoods ordGoods);

    /**
     * 修改商品
     * 
     * @param ordGoods 商品
     * @return 结果
     */
    public int updateOrdGoods(OrdGoods ordGoods);

    /**
     * 删除商品
     * 
     * @param goodsId 商品主键
     * @return 结果
     */
    public int deleteOrdGoodsByGoodsId(Long goodsId);

    /**
     * 批量删除商品
     * 
     * @param goodsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrdGoodsByGoodsIds(Long[] goodsIds);
}
