import request from '@/utils/request'

// 运动推荐
export function recommend(requestData) {
  return request({
    url: `/recommend`,
    method: 'post',
    data: requestData
  })
}

