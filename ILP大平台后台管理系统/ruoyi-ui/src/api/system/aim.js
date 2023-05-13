import request from '@/utils/request'

// 查询用户目标列表
export function listAim(query) {
  return request({
    url: '/system/aim/list',
    method: 'get',
    params: query
  })
}

// 查询用户目标详细
export function getAim(id) {
  return request({
    url: '/system/aim/' + id,
    method: 'get'
  })
}

// 新增用户目标
export function addAim(data) {
  return request({
    url: '/system/aim',
    method: 'post',
    data: data
  })
}

// 修改用户目标
export function updateAim(data) {
  return request({
    url: '/system/aim',
    method: 'put',
    data: data
  })
}

// 删除用户目标
export function delAim(id) {
  return request({
    url: '/system/aim/' + id,
    method: 'delete'
  })
}
