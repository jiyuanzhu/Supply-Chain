<template>
  <div class="elback" :style="elback">
    <div id="eltop">
      <TopNav></TopNav>
    </div>
    <div id="elbody">
      <div id="elbody1">
        <p>企业管理子系统</p>
      </div>
      <div id="elbody2">
        <div id="login">
          <div id="logintitle">
            <p>登录</p>
          </div>
          <div id="username">
            <label>
              <p>用户名</p>
              <el-input clearable v-model="uname"></el-input>
            </label>
          </div>
          <div id="password">
            <label>
              <p>密码</p>
              <el-input clearable show-password v-model="password"></el-input>
            </label>
          </div>
          <div class="doubut">
            <el-button @click="enterl" class="enterl">登录</el-button>
            <el-button @click="register" class="register">注册</el-button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TopNav from '@/views/nav/TopNavLogin'
export default {
  name: 'EnterpriseLogin',
  components:{
    TopNav
  },
  data(){
    return{
      uname: "",
      password: "",
      elback:{
        backgroundImage: "url(" + require("@/assets/enterprise.jpg") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%",
      },
    }
  },
  methods:{
    enterl(){
      // this.$store.state.leftNavState = 'CoreEnterpise';
      // this.$router.push({path:'/centerpise'})
      this.$store.state.leftNavState = 'Enterpise'; //非核心企业
      this.$router.push({path:'/enterpise'})
    },
    register(){
      this.$router.push({path:'/register'})
    }
  }
}
</script>

<style>
.elback{
  height:750px;
  width:100%;
  
}

#eltop{
  height:13%;
  width:100%;
}

#elbody{
  height:87%;
  width:100%;
  text-align: center;
}

#elbody1{
  margin:auto;
  height:12%;
  width:46%;
  font-family:"华文行楷"; 
  font-size:30px;
  text-align: center;
}

#elbody2{
  margin:auto;
  height:73%;
  width:27%;
}

#login{
  height:100%;
  width:100%;
  background-color: rgb(252, 247, 252);
  border-radius:30px;
  box-shadow: 1px #383737;
  text-align: center;
}

#logintitle{
  height:23%;
  width:100%;
  text-align: center;
  font-family:"华文行楷"; 
  font-size:30px;
  padding-top:2px;
}

#username{
  margin:auto;
  height:18%;
  width:62%;
  text-align: left;
  font-family:"华文行楷"; 
  font-size:20px;
}

#password{
  margin:auto;
  height:18%;
  width:62%;
  text-align: left;
  font-family:"华文行楷"; 
  font-size:20px;
}

.doubut{
  height:20%;
  width:60%;
  margin:auto;  
}
.enterl{
  background-color: rgb(17, 212, 226);
  width:100px;
  height:45px;
  margin-top: 50px;
  font-family:"华文行楷"; 
  font-size:25px;
  text-align: center;
  float:left;
}

.register{
  background-color: rgb(17, 212, 226);
  width:100px;
  height:45px;
  margin-top: 50px;
  font-family:"华文行楷"; 
  font-size:25px;
  text-align: center;
  float:right;
}
</style>
