import request from '@/utils/request'

// 获取推广
export function getList() {
  return request(({
    url: '/club/list',
    method: 'get'
  }))
}
export function getClub(date) {
  return request({
    url: '/club/getClub',
    method: 'get',
    params: {
      date: date
    }
  })
}
export function joinClub(id) {
  return request({
    url: `/club/join/${id}`,
    method: 'post',
    params: {
      id: id
    }
  })
}
export function deleteClub(id) {
  return request({
    url: `/club/member/delete/${id}`,
    method: 'delete'
  })
}
