import request from '@/utils/request'

// 查询能力测试列表
export function listSkillTest(query) {
  return request({
    url: '/system/skillTest/list',
    method: 'get',
    params: query
  })
}

// 查询能力测试详细
export function getSkillTest(id) {
  return request({
    url: '/system/skillTest/' + id,
    method: 'get'
  })
}

// 新增能力测试
export function addSkillTest(data) {
  return request({
    url: '/system/skillTest',
    method: 'post',
    data: data
  })
}

// 修改能力测试
export function updateSkillTest(data) {
  return request({
    url: '/system/skillTest',
    method: 'put',
    data: data
  })
}

// 删除能力测试
export function delSkillTest(id) {
  return request({
    url: '/system/skillTest/' + id,
    method: 'delete'
  })
}
