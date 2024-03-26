package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OrdMemberMapper;
import com.ruoyi.system.domain.OrdMember;
import com.ruoyi.system.service.IOrdMemberService;

/**
 * 会员管理Service业务层处理
 *
 * @author ruoyi
 * @date 2024-03-26
 */
@Service
public class OrdMemberServiceImpl implements IOrdMemberService
{
    @Autowired
    private OrdMemberMapper ordMemberMapper;

    /**
     * 查询会员管理
     *
     * @param memberId 会员管理主键
     * @return 会员管理
     */
    @Override
    public OrdMember selectOrdMemberByMemberId(Long memberId)
    {
        return ordMemberMapper.selectOrdMemberByMemberId(memberId);
    }
    @Override
    public OrdMember selectOrdMemberByMemberPhone(String phone)
    {
        return ordMemberMapper.selectOrdMemberByMemberPhone(phone);
    }

    /**
     * 查询会员管理列表
     *
     * @param ordMember 会员管理
     * @return 会员管理
     */
    @Override
    public List<OrdMember> selectOrdMemberList(OrdMember ordMember)
    {
        return ordMemberMapper.selectOrdMemberList(ordMember);
    }

    /**
     * 新增会员管理
     *
     * @param ordMember 会员管理
     * @return 结果
     */
    @Override
    public int insertOrdMember(OrdMember ordMember)
    {
        ordMember.setCreateTime(DateUtils.getNowDate());
        return ordMemberMapper.insertOrdMember(ordMember);
    }

    /**
     * 修改会员管理
     *
     * @param ordMember 会员管理
     * @return 结果
     */
    @Override
    public int updateOrdMember(OrdMember ordMember)
    {
        return ordMemberMapper.updateOrdMember(ordMember);
    }

    /**
     * 批量删除会员管理
     *
     * @param memberIds 需要删除的会员管理主键
     * @return 结果
     */
    @Override
    public int deleteOrdMemberByMemberIds(Long[] memberIds)
    {
        return ordMemberMapper.deleteOrdMemberByMemberIds(memberIds);
    }

    /**
     * 删除会员管理信息
     *
     * @param memberId 会员管理主键
     * @return 结果
     */
    @Override
    public int deleteOrdMemberByMemberId(Long memberId)
    {
        return ordMemberMapper.deleteOrdMemberByMemberId(memberId);
    }
}
