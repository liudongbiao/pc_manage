package com.ruoyi.system.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.exception.ServiceException;
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
import com.ruoyi.system.domain.OrdMember;
import com.ruoyi.system.service.IOrdMemberService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会员管理Controller
 *
 * @author ruoyi
 * @date 2024-03-26
 */
@RestController
@RequestMapping("/system/member")
public class OrdMemberController extends BaseController
{
    @Autowired
    private IOrdMemberService ordMemberService;

    /**
     * 查询会员管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:member:list')")
    @GetMapping("/list")
    public TableDataInfo list(OrdMember ordMember)
    {
        startPage();
        List<OrdMember> list = ordMemberService.selectOrdMemberList(ordMember);
        return getDataTable(list);
    }
    /**
     * 查询会员管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:member:list')")
    @GetMapping("/listMemberSelect")
    public TableDataInfo listMemberSelect(OrdMember ordMember)
    {
        List<OrdMember> list = ordMemberService.selectOrdMemberList(ordMember);
        return getDataTable(list);
    }


    /**
     * 导出会员管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:member:export')")
    @Log(title = "会员管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OrdMember ordMember)
    {
        List<OrdMember> list = ordMemberService.selectOrdMemberList(ordMember);
        ExcelUtil<OrdMember> util = new ExcelUtil<OrdMember>(OrdMember.class);
        util.exportExcel(response, list, "会员管理数据");
    }

    /**
     * 获取会员管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:member:query')")
    @GetMapping(value = "/{memberId}")
    public AjaxResult getInfo(@PathVariable("memberId") Long memberId)
    {
        return success(ordMemberService.selectOrdMemberByMemberId(memberId));
    }

    /**
     * 新增会员管理
     */
    @PreAuthorize("@ss.hasPermi('system:member:add')")
    @Log(title = "会员管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrdMember ordMember)
    {
        OrdMember ordMember1 = ordMemberService.selectOrdMemberByMemberPhone(ordMember.getPhone());
        if(ordMember1!=null){
            throw new ServiceException("该手机号码会员已经存在！");
        }
        ordMember.setCreateTime(new Date());
        return toAjax(ordMemberService.insertOrdMember(ordMember));
    }

    /**
     * 修改会员管理
     */
    @PreAuthorize("@ss.hasPermi('system:member:edit')")
    @Log(title = "会员管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrdMember ordMember)
    {
        return toAjax(ordMemberService.updateOrdMember(ordMember));
    }

    /**
     * 删除会员管理
     */
    @PreAuthorize("@ss.hasPermi('system:member:remove')")
    @Log(title = "会员管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{memberIds}")
    public AjaxResult remove(@PathVariable Long[] memberIds)
    {
        return toAjax(ordMemberService.deleteOrdMemberByMemberIds(memberIds));
    }
}
