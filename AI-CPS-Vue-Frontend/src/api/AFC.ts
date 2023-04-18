import request from './request'

export function AFCList() {
    return request({
        url: "/api/getAFCData/DDPG/NN_3_15_1",
        method: 'get',
    })
}