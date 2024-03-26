package com.ruoyi.system.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.OrdMember;
import com.ruoyi.system.domain.OrdRule;
import com.ruoyi.system.service.IOrdMemberService;
import com.ruoyi.system.service.IOrdRuleService;
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
import com.ruoyi.system.domain.OrdOrder;
import com.ruoyi.system.service.IOrdOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 消费记录Controller
 *
 * @author ruoyi
 * @date 2024-03-26
 */
@RestController
@RequestMapping("/system/order")
public class OrdOrderController extends BaseController
{
    @Autowired
    private IOrdOrderService ordOrderService;
    @Autowired
    private IOrdRuleService ordRuleService;
    @Autowired
    private IOrdMemberService ordMemberService;

    /**
     * 查询消费记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(OrdOrder ordOrder)
    {
        startPage();
        List<OrdOrder> list = ordOrderService.selectOrdOrderList(ordOrder);
        return getDataTable(list);
    }

    /**
     * 导出消费记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:export')")
    @Log(title = "消费记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OrdOrder ordOrder)
    {
        List<OrdOrder> list = ordOrderService.selectOrdOrderList(ordOrder);
        ExcelUtil<OrdOrder> util = new ExcelUtil<OrdOrder>(OrdOrder.class);
        util.exportExcel(response, list, "消费记录数据");
    }

    /**
     * 获取消费记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:order:query')")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId)
    {
        return success(ordOrderService.selectOrdOrderByOrderId(orderId));
    }

    /**
     * 新增消费记录
     */
    @PreAuthorize("@ss.hasPermi('system:order:add')")
    @Log(title = "消费记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrdOrder ordOrder)
    {
        //获取消费规则
        List<OrdRule> list = ordRuleService.selectOrdRuleList(null);
        for (int i = 0; i < list.size(); i++) {
            //本次消费金额》=消费金额规则
            int dataNum = new BigDecimal(ordOrder.getPayMoney()).compareTo(new BigDecimal(list.get(i).getConsumMoney()));
            if(dataNum > -1){
                System.out.println("a大于等于b");
                //订单获取积分
                ordOrder.setPoint(list.get(i).getConsumPoint());
                //获取会员
                OrdMember ordMember = ordMemberService.selectOrdMemberByMemberId(ordOrder.getMemberId());
                BigDecimal a = new BigDecimal(ordMember.getConsumPoint());
                BigDecimal b = new BigDecimal(ordOrder.getPoint());
                BigDecimal sum = a.add(b);
                //会员积分相加
                ordMember.setConsumPoint(sum.toString());
                ordMemberService.updateOrdMember(ordMember);
                break;
            }
        }

        ordOrder.setPaymentTime(new Date());
        return toAjax(ordOrderService.insertOrdOrder(ordOrder));
    }

    /**
     * 修改消费记录
     */
    @PreAuthorize("@ss.hasPermi('system:order:edit')")
    @Log(title = "消费记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrdOrder ordOrder)
    {
        ordOrder.setPaymentTime(new Date());
        return toAjax(ordOrderService.updateOrdOrder(ordOrder));
    }

    /**
     * 删除消费记录
     */
    @PreAuthorize("@ss.hasPermi('system:order:remove')")
    @Log(title = "消费记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds)
    {
        return toAjax(ordOrderService.deleteOrdOrderByOrderIds(orderIds));
    }
}
