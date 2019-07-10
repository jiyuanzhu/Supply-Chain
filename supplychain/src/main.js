// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store.js'
import global_variable from './global_variable.js'



import {default as api} from './util/api.js'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI)

Vue.config.productionTip = false

Vue.prototype.userInfo = global_variable.userInfo
Vue.prototype.loginPage = global_variable.loginPage
Vue.prototype.comType = global_variable.comType
Vue.prototype.$api = api
/* eslint-disable no-new */
new Vue({
    el: '#app',
    router,
    store,
    components: { App },
    template: '<App/>'
})
