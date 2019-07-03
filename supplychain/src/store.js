import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const state = {
  collapsed: false,
  topNavState:'user',
  leftNavState:'Enterpise',//表示左边栏状态，用来对应不同对象的左边栏
}

for(var item in state) {
  localStorage.getItem(item)? state[item] = JSON.parse(localStorage.getItem(item)): false;
}

export default new Vuex.Store({
  state
})
