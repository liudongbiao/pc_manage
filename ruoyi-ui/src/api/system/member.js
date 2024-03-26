import request from '@/utils/request'

// 查询会员管理列表
export function listMember(query) {
  return request({
    url: '/system/member/list',
    method: 'get',
    params: query
  })
}

// 查询会员管理列表
export function listMemberSelect(query) {
  return request({
    url: '/system/member/listMemberSelect',
    method: 'get',
    params: query
  })
}

// 查询会员管理详细
export function getMember(memberId) {
  return request({
    url: '/system/member/' + memberId,
    method: 'get'
  })
}

// 新增会员管理
export function addMember(data) {
  return request({
    url: '/system/member',
    method: 'post',
    data: data
  })
}

// 修改会员管理
export function updateMember(data) {
  return request({
    url: '/system/member',
    method: 'put',
    data: data
  })
}

// 删除会员管理
export function delMember(memberId) {
  return request({
    url: '/system/member/' + memberId,
    method: 'delete'
  })
}
