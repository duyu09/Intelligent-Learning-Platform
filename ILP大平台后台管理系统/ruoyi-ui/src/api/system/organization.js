import request from '@/utils/request'

// 查询社团总表列表
export function listOrganization(query) {
  return request({
    url: '/system/organization/list',
    method: 'get',
    params: query
  })
}

// 查询社团总表详细
export function getOrganization(id) {
  return request({
    url: '/system/organization/' + id,
    method: 'get'
  })
}

// 新增社团总表
export function addOrganization(data) {
  return request({
    url: '/system/organization',
    method: 'post',
    data: data
  })
}

// 修改社团总表
export function updateOrganization(data) {
  return request({
    url: '/system/organization',
    method: 'put',
    data: data
  })
}

// 删除社团总表
export function delOrganization(id) {
  return request({
    url: '/system/organization/' + id,
    method: 'delete'
  })
}
