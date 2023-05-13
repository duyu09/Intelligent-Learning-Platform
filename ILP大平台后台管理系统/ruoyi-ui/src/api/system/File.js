import request from '@/utils/request'

// 查询文件类型列表
export function listFile(query) {
  return request({
    url: '/system/File/list',
    method: 'get',
    params: query
  })
}

// 查询文件类型详细
export function getFile(id) {
  return request({
    url: '/system/File/' + id,
    method: 'get'
  })
}

// 新增文件类型
export function addFile(data) {
  return request({
    url: '/system/File',
    method: 'post',
    data: data
  })
}

// 修改文件类型
export function updateFile(data) {
  return request({
    url: '/system/File',
    method: 'put',
    data: data
  })
}

// 删除文件类型
export function delFile(id) {
  return request({
    url: '/system/File/' + id,
    method: 'delete'
  })
}
