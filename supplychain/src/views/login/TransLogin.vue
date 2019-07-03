<template>
  <div class="tlback" :style="tlback">
    <div id="tltop">
      <TopNav></TopNav>
    </div>
    <div id="tlbody">
      <div id="tlbody1">
        <p>运输管理子系统</p>
      </div>
      <div id="tlbody2">
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
          <el-button @click="transl" class="transl">登录</el-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TopNav from '@/views/nav/TopNavLogin'
export default {
  name: 'TransLogin',
  components:{
    TopNav
  },
  data(){
    return{
      tlback:{
        backgroundImage: "url(" + require("@/assets/trans.jpg") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%",
      },
    }
  },
  methods:{
    transl(){
      this.$store.state.leftNavState = 'Trans';
      this.$router.push({path:'/trans'})
    }
  }
}
</script>

<style>
.tlback{
  height:690px;
  width:1600px;
  
}

#tltop{
  height:80px;
  width:1500px;
}

#tlbody{
  height:600px;
  width:1500px;
  text-align: center;
}

#tlbody1{
  margin:auto;
  height:70px;
  width:700px;
  font-family:"华文行楷"; 
  font-size:30px;
  text-align: center;
}

#tlbody2{
  margin:auto;
  height:440px;
  width:400px;
}

#login{
  height:440px;
  width:400px;
  background-color: rgb(252, 247, 252);
  border-radius:30px;
  box-shadow: 1px #383737;
  text-align: center;
}

#logintitle{
  height:100px;
  width:400px;
  text-align: center;
  font-family:"华文行楷"; 
  font-size:30px;
  padding-top:2px;
}

#username{
  margin:auto;
  height:80px;
  width:250px;
  text-align: left;
  font-family:"华文行楷"; 
  font-size:20px;
}

#password{
  margin:auto;
  height:80px;
  width:250px;
  text-align: left;
  font-family:"华文行楷"; 
  font-size:20px;
}

.transl{
  background-color: rgb(17, 212, 226);
  width:100px;
  height:45px;
  margin-top: 50px;
  font-family:"华文行楷"; 
  font-size:25px;
  text-align: center;
}
</style>
