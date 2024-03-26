package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.OrdRule;

/**
 * 消费规则Service接口
 * 
 * @author ruoyi
 * @date 2024-03-26
 */
public interface IOrdRuleService 
{
    /**
     * 查询消费规则
     * 
     * @param ruleId 消费规则主键
     * @return 消费规则
     */
    public OrdRule selectOrdRuleByRuleId(Long ruleId);

    /**
     * 查询消费规则列表
     * 
     * @param ordRule 消费规则
     * @return 消费规则集合
     */
    public List<OrdRule> selectOrdRuleList(OrdRule ordRule);

    /**
     * 新增消费规则
     * 
     * @param ordRule 消费规则
     * @return 结果
     */
    public int insertOrdRule(OrdRule ordRule);

    /**
     * 修改消费规则
     * 
     * @param ordRule 消费规则
     * @return 结果
     */
    public int updateOrdRule(OrdRule ordRule);

    /**
     * 批量删除消费规则
     * 
     * @param ruleIds 需要删除的消费规则主键集合
     * @return 结果
     */
    public int deleteOrdRuleByRuleIds(Long[] ruleIds);

    /**
     * 删除消费规则信息
     * 
     * @param ruleId 消费规则主键
     * @return 结果
     */
    public int deleteOrdRuleByRuleId(Long ruleId);
}
