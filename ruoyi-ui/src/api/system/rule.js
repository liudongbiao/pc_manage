import request from '@/utils/request'

// 查询消费规则列表
export function listRule(query) {
  return request({
    url: '/system/rule/list',
    method: 'get',
    params: query
  })
}

// 查询消费规则详细
export function getRule(ruleId) {
  return request({
    url: '/system/rule/' + ruleId,
    method: 'get'
  })
}

// 新增消费规则
export function addRule(data) {
  return request({
    url: '/system/rule',
    method: 'post',
    data: data
  })
}

// 修改消费规则
export function updateRule(data) {
  return request({
    url: '/system/rule',
    method: 'put',
    data: data
  })
}

// 删除消费规则
export function delRule(ruleId) {
  return request({
    url: '/system/rule/' + ruleId,
    method: 'delete'
  })
}
