import axios from 'axios'
import {Message, MessageBox} from 'element-ui'

const service = axios.create({

  timeout: 15000               // 请求超时时间2
})

// request拦截器
service.interceptors.request.use(config => {
  return config
}, error => {
  // Do something with request error
  console.error(error) // for debug
  Promise.reject(error)
})

service.interceptors.response.use(
  response => {
    const res = response.data;
    console.log(res);
    if(res.code == '200'){
    return res.info;
    }
  })

  export default service
