<template>
  <div class="pageback1" :style="pageback">
    <div id="pagetop">
      <TopNav></TopNav>
    </div>
    <div id="pagebody">
      <div id="pagebody1">
        <p>{{pageName}}管理子系统</p>
      </div>
      <div id="pagebody2">
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
            <el-button @click="logon" class="bankl">登录</el-button>
            <el-button @click="register" class="register">注册</el-button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TopNav from "@/views/nav/TopNavLogin";
export default {
  name: "PageLogin",
  components: {
    TopNav
  },
  data() {
    return {
      pageName: "",  
      uname: "",
      password: "",
      pageback: {
        backgroundImage: "",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%"
      }
    };
  },
  methods: {
    logon() {
      this.$api({
        url:"http://localhost:8088/user/login",
        method:"post",
        data:{
          username: this.username,
          password: this.password
        }
      }).then((response) =>{
        console.log("登录成功")
        this.userInfo.uname=this.username
        this.userInfo.id=response.data.info.id
        this.userInfo.cname=response.data.info.company_name
        if(repsonse.data.code=="1001") alert("账户不存在"); else
        if(repsonse.data.code=="1002") alert("密码错误"); 
        // console.log(response);
      } )
      // this.userInfo.uname="1"
      //   console.log(this.userInfo)
      switch (this.loginPage.pageType) {
          case "bank":
              this.userInfo.ctype="b"
              this.$store.state.leftNavState = "Bank";
              this.$router.push({ path: "/bank" });
              break;
          case "enterprise":
              // this.$store.state.leftNavState = 'CoreEnterpise';
              // this.$router.push({path:'/centerpise'})
              this.userInfo.ctype="e"
              this.$store.state.leftNavState = 'Enterpise'; //非核心企业
              this.$router.push({path:'/enterpise'})
              break;
          case "transport":
              this.userInfo.ctype="t"
              this.$store.state.leftNavState = 'Trans';
              this.$router.push({path:'/trans'})
              break;
          case "insurance":
              this.userInfo.ctype="i"
              this.$store.state.leftNavState = 'Insurance';
              this.$router.push({path:'/insurance'})
              break;
      }
      
    },
    register() {
      this.$router.push({ path: "/register" });
    },
    init(){
        switch (this.loginPage.pageType) {
          case "bank":
              this.pageName="银行"
              this.pageback.backgroundImage="url(" + require("@/assets/bank.jpg") + ")"
              break;
          case "enterprise":
              this.pageName="企业"
              this.pageback.backgroundImage="url(" + require("@/assets/enterprise.jpg") + ")"
              break;
          case "transport":
              this.pageName="运输"
              this.pageback.backgroundImage= "url(" + require("@/assets/trans.jpg") + ")"
              break;
          case "insurance":
              this.pageName="保险"
              this.pageback.backgroundImage="url(" + require("@/assets/insurance.jpg") + ")"
              break;  
      }
    }
  },
  created(){
      this.init()
  }
};
</script>

<style>
.pageback1 {
  height: 750px;
  width: 100%;
}

#pagetop {
  height: 13%;
  width: 100%;
}

#pagebody {
  height: 87%;
  width: 100%;
  text-align: center;
}

#pagebody1 {
  margin: auto;
  height: 12%;
  width: 46%;
  font-family: "华文行楷";
  font-size: 30px;
  text-align: center;
}

#pagebody2 {
  margin: auto;
  height: 73%;
  width: 27%;
}

#login {
  height: 100%;
  width: 100%;
  background-color: rgb(252, 247, 252);
  border-radius: 30px;
  box-shadow: 1px #383737;
  text-align: center;
}

#logintitle {
  height: 23%;
  width: 100%;
  text-align: center;
  font-family: "华文行楷";
  font-size: 30px;
  padding-top: 6px;
}

#username {
  margin: auto;
  height: 18%;
  width: 62%;
  text-align: left;
  font-family: "华文行楷";
  font-size: 20px;
}

#password {
  margin: auto;
  height: 18%;
  width: 62%;
  text-align: left;
  font-family: "华文行楷";
  font-size: 20px;
}

.doubut {
  height: 20%;
  width: 60%;
  margin: auto;
}
.bankl {
  background-color: rgb(17, 212, 226);
  width: 100px;
  height: 45px;
  margin-top: 50px;
  font-family: "华文行楷";
  font-size: 25px;
  text-align: center;
  float: left;
}

.register {
  background-color: rgb(17, 212, 226);
  width: 100px;
  height: 45px;
  margin-top: 50px;
  font-family: "华文行楷";
  font-size: 25px;
  text-align: center;
  float: right;
}
</style>
