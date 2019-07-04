<template>
    <div class="regback" :style="regback">
        <div id="regtop">
            <TopNav></TopNav>
        </div>
        <div id="regbody">
            <div id="register">
                <div id="logintitle">
                    <p>登录</p>
                </div>
                <div id="username">
                    <p>用户名</p>
                    <el-input type="text"></el-input>
                </div>
                <div id="password">
                    <p>密码</p>
                    <el-input type="text"></el-input>
                </div>
                <div class="doubut">
                    <el-button @click="bankl" class="bankl">登录</el-button>
                    <el-button @click="registerbt" class="registerbt">注册</el-button>
                </div>
            </div>
      </div>
    </div>
</template>

<script>
import TopNav from '@/views/nav/TopNavLogin'
export default {
  name: 'Register',
  components:{
    TopNav
  },
  data(){
    return{
        regback:{
        backgroundImage: "url(" + require("@/assets/back1.jpg") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%",
      },
    }
  }
}
</script>

<style>
.regback{
  height:750px;
  width:100%;
}

#register{
  height:100%;
  width:100%;
  background-color: rgb(252, 247, 252);
  border-radius:30px;
  box-shadow: 1px #383737;
  text-align: center;
}
</style>