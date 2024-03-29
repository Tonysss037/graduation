import request from '@/utils/request'

// 用户主页
export function getInfoByName(username, page, size) {
  return request({
    url: '/ums/user/' + username,
    method: 'get',
    params: {
      pageNo: page,
      size: size
    }
  })
}
export function getInfoByNameT(username, page, size) {
  return request({
    url: '/ums/user/T/' + username,
    method: 'get',
    params: {
      pageNo: page,
      size: size
    }
  })
}
export function getInfoByNameC(username, page, size) {
  return request({
    url: '/ums/user/C/' + username,
    method: 'get',
    params: {
      pageNo: page,
      size: size
    }
  })
}
export function getInfoByName2(username, page, size) {
  return request({
    url: '/ums/user/' + username,
    method: 'get',
    params: {
      pageNo: page,
      size: size
    }
  })
}
// 用户主页
export function getInfo() {
  return request({
    url: '/ums/user/info',
    method: 'get'
  })
}
// 更新
export function update(user) {
  return request({
    url: '/ums/user/update',
    method: 'post',
    data: user
  })
}


