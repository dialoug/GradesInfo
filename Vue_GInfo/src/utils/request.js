import axios from 'axios';
import {ElMessage} from 'element-plus'
import router from '@/router'


const baseURL = '/api';
const instance = axios.create({
    baseURL: baseURL,
    //timeout: timeout,
    //headers: headers
})

import {useTokenStore} from "@/stores/token.js";

//请求拦截器
instance.interceptors.request.use(
    config => {
        const tokenStore = useTokenStore()
        if (tokenStore.token) {
            config.headers['Authorization'] = tokenStore.token;
        }
        return config;
    },
    err => {
        ElMessage.success('服务异常')
        return Promise.reject(err)
    }
)

//响应拦截器
instance.interceptors.response.use(
    result => {
        if (result.data.code == 0) {
            return result.data;

        } else {
            ElMessage.success(result.data.message ? result.data.message : '服务异常')
            return Promise.reject(result.data)
        }

    },
    err => {
        if (err.response.status === 407) {
            ElMessage.success('未登录')
            router.push('/login')

        } else {
            ElMessage.success('服务异常')
            return Promise.reject(err)
        }
    }

)
export default instance;