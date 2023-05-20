import request from '@/utils/request'
//足球展示
export function getList(pageNo, size, tab) {
    return request(({
        url: '/team/list',
        method: 'get',
        params: { pageNo: pageNo, size: size, tab: tab }
    }))
}
// 发布
export function team(team) {
    return request({
        url: '/team/create',
        method: 'post',
        data: team
    })
}
// 浏览
export function getTeam(id) {
    return request({
        url: `/team`,
        method: 'get',
        params: {
            id: id
        }
    })
}
export function getListFootball(pageNo, size, tab) {
    return request(({
        url: '/team/list/football',
        method: 'get',
        params: { pageNo: pageNo, size: size, tab: tab }
    }))
}

export function getListBasketball(pageNo, size, tab) {
    return request(({
        url: '/team/list/basketball',
        method: 'get',
        params: { pageNo: pageNo, size: size, tab: tab }
    }))
}

export function getListVolleyball(pageNo, size, tab) {
    return request(({
        url: '/team/list/volleyball',
        method: 'get',
        params: { pageNo: pageNo, size: size, tab: tab }
    }))
}

export function getListBadminton(pageNo, size, tab) {
    return request(({
        url: '/team/list/badminton',
        method: 'get',
        params: { pageNo: pageNo, size: size, tab: tab }
    }))
}

export function getListPingPong(pageNo, size, tab) {
    return request(({
        url: '/team/list/pingpong',
        method: 'get',
        params: { pageNo: pageNo, size: size, tab: tab }
    }))
}

export function getListTennis(pageNo, size, tab) {
    return request(({
        url: '/team/list/tennis',
        method: 'get',
        params: { pageNo: pageNo, size: size, tab: tab }
    }))
}

export function getListOther(pageNo, size, tab) {
    return request(({
        url: '/team/list/other',
        method: 'get',
        params: { pageNo: pageNo, size: size, tab: tab }
    }))
}

export function join(id) {
    return request({
        url: `/team/join/${id}`,
        method: 'post',
        params: {
            id: id
        }
    })
}

export function update(team) {
    return request({
        url: '/team/update',
        method: 'post',
        data: team
    })
}

export function deleteTeam(id) {
    return request({
        url: `/team/delete/${id}`,
        method: 'delete'
    })
}
