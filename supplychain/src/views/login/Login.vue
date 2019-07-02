<template>
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
    </div>
    
</template>

<script>
export default {
  name: 'Login',
  data(){
    return{}
  }
}
</script>

<style>
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

#usertext{
  
}

#userinput{
}

#password{
  margin:auto;
  height:80px;
  width:250px;
  text-align: left;
  font-family:"华文行楷"; 
  font-size:20px;
}

#passtext{

}

#passinput{

}
</style>