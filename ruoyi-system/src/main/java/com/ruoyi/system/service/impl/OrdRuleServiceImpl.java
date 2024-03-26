package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OrdRuleMapper;
import com.ruoyi.system.domain.OrdRule;
import com.ruoyi.system.service.IOrdRuleService;

/**
 * 消费规则Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-26
 */
@Service
public class OrdRuleServiceImpl implements IOrdRuleService 
{
    @Autowired
    private OrdRuleMapper ordRuleMapper;

    /**
     * 查询消费规则
     * 
     * @param ruleId 消费规则主键
     * @return 消费规则
     */
    @Override
    public OrdRule selectOrdRuleByRuleId(Long ruleId)
    {
        return ordRuleMapper.selectOrdRuleByRuleId(ruleId);
    }

    /**
     * 查询消费规则列表
     * 
     * @param ordRule 消费规则
     * @return 消费规则
     */
    @Override
    public List<OrdRule> selectOrdRuleList(OrdRule ordRule)
    {
        return ordRuleMapper.selectOrdRuleList(ordRule);
    }

    /**
     * 新增消费规则
     * 
     * @param ordRule 消费规则
     * @return 结果
     */
    @Override
    public int insertOrdRule(OrdRule ordRule)
    {
        return ordRuleMapper.insertOrdRule(ordRule);
    }

    /**
     * 修改消费规则
     * 
     * @param ordRule 消费规则
     * @return 结果
     */
    @Override
    public int updateOrdRule(OrdRule ordRule)
    {
        return ordRuleMapper.updateOrdRule(ordRule);
    }

    /**
     * 批量删除消费规则
     * 
     * @param ruleIds 需要删除的消费规则主键
     * @return 结果
     */
    @Override
    public int deleteOrdRuleByRuleIds(Long[] ruleIds)
    {
        return ordRuleMapper.deleteOrdRuleByRuleIds(ruleIds);
    }

    /**
     * 删除消费规则信息
     * 
     * @param ruleId 消费规则主键
     * @return 结果
     */
    @Override
    public int deleteOrdRuleByRuleId(Long ruleId)
    {
        return ordRuleMapper.deleteOrdRuleByRuleId(ruleId);
    }
}
