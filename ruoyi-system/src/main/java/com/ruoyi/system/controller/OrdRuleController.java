package com.ruoyi.system.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.OrdRule;
import com.ruoyi.system.service.IOrdRuleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 消费规则Controller
 *
 * @author ruoyi
 * @date 2024-03-26
 */
@RestController
@RequestMapping("/system/rule")
public class OrdRuleController extends BaseController
{
    @Autowired
    private IOrdRuleService ordRuleService;

    /**
     * 查询消费规则列表
     */
    @PreAuthorize("@ss.hasPermi('system:rule:list')")
    @GetMapping("/list")
    public TableDataInfo list(OrdRule ordRule)
    {
        startPage();
        List<OrdRule> list = ordRuleService.selectOrdRuleList(ordRule);
        return getDataTable(list);
    }

    /**
     * 导出消费规则列表
     */
    @PreAuthorize("@ss.hasPermi('system:rule:export')")
    @Log(title = "消费规则", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OrdRule ordRule)
    {
        List<OrdRule> list = ordRuleService.selectOrdRuleList(ordRule);
        ExcelUtil<OrdRule> util = new ExcelUtil<OrdRule>(OrdRule.class);
        util.exportExcel(response, list, "消费规则数据");
    }

    /**
     * 获取消费规则详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:rule:query')")
    @GetMapping(value = "/{ruleId}")
    public AjaxResult getInfo(@PathVariable("ruleId") Long ruleId)
    {
        return success(ordRuleService.selectOrdRuleByRuleId(ruleId));
    }

    /**
     * 新增消费规则
     */
    @PreAuthorize("@ss.hasPermi('system:rule:add')")
    @Log(title = "消费规则", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrdRule ordRule)
    {
        ordRule.setCreateTime(new Date());
        return toAjax(ordRuleService.insertOrdRule(ordRule));
    }

    /**
     * 修改消费规则
     */
    @PreAuthorize("@ss.hasPermi('system:rule:edit')")
    @Log(title = "消费规则", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrdRule ordRule)
    {
        return toAjax(ordRuleService.updateOrdRule(ordRule));
    }

    /**
     * 删除消费规则
     */
    @PreAuthorize("@ss.hasPermi('system:rule:remove')")
    @Log(title = "消费规则", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ruleIds}")
    public AjaxResult remove(@PathVariable Long[] ruleIds)
    {
        return toAjax(ordRuleService.deleteOrdRuleByRuleIds(ruleIds));
    }
}
