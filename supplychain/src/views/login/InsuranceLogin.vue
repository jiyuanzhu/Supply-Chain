<template>
  <div class="ilback" :style="ilback">
    <div id="iltop">
      <TopNav></TopNav>
    </div>
    <div id="ilbody">
      <div id="ilbody1">
        <p>保险管理子系统</p>
      </div>
      <div id="ilbody2">
        <div id="login">
          <div id="logintitle">
            <p>登录</p>
          </div>
          <div id="username">
            <p class="usertext">用户名</p>
            <el-input type="text" class="userinput"></el-input>
          </div>
          <div id="password">
            <p class="passtext">密码</p>
            <el-input type="text" class="passinput"></el-input>
          </div>
          <el-button @click="insurl" class="insurl">登录</el-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TopNav from '@/views/nav/TopNavLogin'
export default {
  name: 'InsuranceLogin',
  components:{
    TopNav
  },
  data(){
    return{
      ilback:{
        backgroundImage: "url(" + require("@/assets/insurance.jpg") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%",
      },
    }
  },
  methods:{
    insurl(){
      this.$store.state.leftNavState = 'Insurance';
      this.$router.push({path:'/insurance'})
    }
  }
}
</script>

<style>
.ilback{
  height:750px;
  width:100%;
  
}

#iltop{
  height:13%;
  width:100%;
}

#ilbody{
  height:87%;
  width:100%;
  text-align: center;
}

#ilbody1{
  margin:auto;
  height:12%;
  width:46%;
  font-family:"华文行楷"; 
  font-size:30px;
  text-align: center;
}

#ilbody2{
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

.insurl{
  background-color: rgb(17, 212, 226);
  width:100px;
  height:45px;
  margin-top: 50px;
  font-family:"华文行楷"; 
  font-size:25px;
  text-align: center;
}
</style>
