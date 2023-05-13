import request from '@/utils/request'

// 查询自习状况列表
export function listStudyRoom(query) {
  return request({
    url: '/system/studyRoom/list',
    method: 'get',
    params: query
  })
}

// 查询自习状况详细
export function getStudyRoom(id) {
  return request({
    url: '/system/studyRoom/' + id,
    method: 'get'
  })
}

// 新增自习状况
export function addStudyRoom(data) {
  return request({
    url: '/system/studyRoom',
    method: 'post',
    data: data
  })
}

// 修改自习状况
export function updateStudyRoom(data) {
  return request({
    url: '/system/studyRoom',
    method: 'put',
    data: data
  })
}

// 删除自习状况
export function delStudyRoom(id) {
  return request({
    url: '/system/studyRoom/' + id,
    method: 'delete'
  })
}
