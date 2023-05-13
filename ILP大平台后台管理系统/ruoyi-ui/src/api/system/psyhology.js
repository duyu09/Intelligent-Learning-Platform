import request from '@/utils/request'

// 查询心理管理列表
export function listPsyhology(query) {
  return request({
    url: '/system/psyhology/list',
    method: 'get',
    params: query
  })
}

// 查询心理管理详细
export function getPsyhology(id) {
  return request({
    url: '/system/psyhology/' + id,
    method: 'get'
  })
}

// 新增心理管理
export function addPsyhology(data) {
  return request({
    url: '/system/psyhology',
    method: 'post',
    data: data
  })
}

// 修改心理管理
export function updatePsyhology(data) {
  return request({
    url: '/system/psyhology',
    method: 'put',
    data: data
  })
}

// 删除心理管理
export function delPsyhology(id) {
  return request({
    url: '/system/psyhology/' + id,
    method: 'delete'
  })
}
