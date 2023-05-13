import request from '@/utils/request'

// 查询forum列表
export function listForum(query) {
  return request({
    url: '/system/forum/list',
    method: 'get',
    params: query
  })
}

// 查询forum详细
export function getForum(id) {
  return request({
    url: '/system/forum/' + id,
    method: 'get'
  })
}

// 新增forum
export function addForum(data) {
  return request({
    url: '/system/forum',
    method: 'post',
    data: data
  })
}

// 修改forum
export function updateForum(data) {
  return request({
    url: '/system/forum',
    method: 'put',
    data: data
  })
}

// 删除forum
export function delForum(id) {
  return request({
    url: '/system/forum/' + id,
    method: 'delete'
  })
}
