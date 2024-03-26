package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.OrdMember;

/**
 * 会员管理Service接口
 *
 * @author ruoyi
 * @date 2024-03-26
 */
public interface IOrdMemberService
{
    /**
     * 查询会员管理
     *
     * @param memberId 会员管理主键
     * @return 会员管理
     */
    public OrdMember selectOrdMemberByMemberId(Long memberId);
    public OrdMember selectOrdMemberByMemberPhone(String phone);

    /**
     * 查询会员管理列表
     *
     * @param ordMember 会员管理
     * @return 会员管理集合
     */
    public List<OrdMember> selectOrdMemberList(OrdMember ordMember);

    /**
     * 新增会员管理
     *
     * @param ordMember 会员管理
     * @return 结果
     */
    public int insertOrdMember(OrdMember ordMember);

    /**
     * 修改会员管理
     *
     * @param ordMember 会员管理
     * @return 结果
     */
    public int updateOrdMember(OrdMember ordMember);

    /**
     * 批量删除会员管理
     *
     * @param memberIds 需要删除的会员管理主键集合
     * @return 结果
     */
    public int deleteOrdMemberByMemberIds(Long[] memberIds);

    /**
     * 删除会员管理信息
     *
     * @param memberId 会员管理主键
     * @return 结果
     */
    public int deleteOrdMemberByMemberId(Long memberId);
}
