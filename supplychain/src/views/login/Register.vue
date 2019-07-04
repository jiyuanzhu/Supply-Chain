<template>
    <div class="regback" :style="regback">
        <div id="regtop">
            <TopNav></TopNav>
        </div>
        <div id="register">
            <div id="regtitle">
                <p>注册</p>
            </div>
            <div id="inputusername">
                <p>请输入用户名</p>
                <el-input type="text"></el-input>
            </div>
            <div id="inputpassword">
                <p>请输入密码</p>
                <el-input type="text"></el-input>
            </div>
            <div id="inputpassword1">
                <p>请再次输入密码</p>
                <el-input type="text"></el-input>
            </div>
            <el-button @click="registerbt" class="registerbt">注册</el-button>
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
  },
  methods:{
      registerbt(){
      this.$router.replace('/')
    }
  }
}
</script>

<style>
.regback{
  height:750px;
  width:100%;
  text-align: center;
}


#register{
  height:70%;
  width:50%;
  background-color: rgb(252, 247, 252);
  border-radius:30px;
  box-shadow: 1px #383737;
  text-align: center;
  margin:auto;
}

#regtitle{
  height:20%;
  width:100%;
  text-align: center;
  font-family:"华文行楷"; 
  font-size:30px;
  padding-top:2px;
}

#inputusername{
  margin:auto;
  height:16%;
  width:62%;
  text-align: left;
  font-family:"华文行楷"; 
  font-size:20px;
}

#inputpassword{
  margin:auto;
  height:16%;
  width:62%;
  text-align: left;
  font-family:"华文行楷"; 
  font-size:20px;
}

#inputpassword1{
  margin:auto;
  height:16%;
  width:62%;
  text-align: left;
  font-family:"华文行楷"; 
  font-size:20px;
}

.registerbt{
  background-color: rgb(17, 212, 226);
  width:100px;
  height:45px;
  margin-top: 25px;
  font-family:"华文行楷"; 
  font-size:25px;
  text-align: center;
}
</style>