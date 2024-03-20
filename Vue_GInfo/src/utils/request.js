import axios from 'axios';
const baseURL = '/api';
const instance = axios.create({
    baseURL: baseURL,
    timeout: timeout,
    headers: headers
})
instance.interceptors.response.use(
    result => {
        return result.data;
    },
    err => {
        alert('服务异常')
        return Promise.reject(err)

    }
)
export default instance;