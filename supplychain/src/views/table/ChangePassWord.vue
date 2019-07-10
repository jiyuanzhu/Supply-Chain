<template>
  <div class="regback" :style="{regback,'padding-top':'50px'}">
    <div class="register3">
      <div id="regtitle2">
        <p>修改密码</p>
      </div>
      <el-row :gutter="21">
        <el-col :span="4">&nbsp;</el-col>
        <el-col :span="5">
          <p style="margin-top:8px"></p>
          <label for="oldKey">
            <div id="inputusername" :style="{'display':'inline'}">旧密码</div>
          </label>
        </el-col>
        <el-col :span="12">
          <el-input id="oldKey" show-password v-model="oldKey" clearable :style="{'width':'80%','float':'left'}"></el-input>
        </el-col>
      </el-row>
      <p style="margin-top:30px"></p>
      <el-row :gutter="21">
        <el-col :span="4">&nbsp;</el-col>
        <el-col :span="5">
          <p style="margin-top:8px"></p>
          <label for="newKey">
            <div id="inputusername" :style="{'display':'inline'}">新密码</div>
          </label>
        </el-col>
        <el-col :span="12">
          <el-input id="newKey" show-password v-model="newKey" clearable :style="{'width':'80%','float':'left'}"></el-input>
        </el-col>
      </el-row>
      <p style="margin-top:30px"></p>
      <el-row :gutter="21">
        <el-col :span="4">&nbsp;</el-col>
        <el-col :span="5">
          <p style="margin-top:8px"></p>
          <label for="repeatKey">
            <div id="inputusername" :style="{'display':'inline'}">重复新密码</div>
          </label>
        </el-col>
        <el-col :span="12">
          <el-input id="repeatKey" show-password v-model="repeatKey" clearable :style="{'width':'80%','float':'left'}"></el-input>
        </el-col>
      </el-row>
      <p style="margin-top:30px"></p>
      <el-button @click="changeCertain" class="registerbt2">确认修改</el-button>
    </div>
  </div>
</template>

<script>
import TopNav from "@/views/nav/TopNavLogin";
export default {
  name: "Register",
  components: {
    TopNav
  },
  data() {
    return {
      oldKey: "",
      newKey: "",
      repeatKey: "",
      regback: {
        // backgroundImage: "url(" + require("@/assets/back1.jpg") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%"
      }
    };
  },
  methods: {
    changeCertain() {
      if(this.newKey!=this.repeatKey) alert("新旧两次密码不一致"); else
      {
        this.$api({
          url:"http://localhost:8088/user/changePass",
          method:"post",
          data:{
            username: this.userInfo.uname,
            oldPass: this.oldKey,
            newPass: this.newKey
          }
        }).then((response) =>{
          console.log("修改密码")
          // if(repsonse.data.code=="1001") alert("账户不存在"); else
          // if(repsonse.data.code=="1002") alert("密码错误"); 
          // console.log(response);
        })
      }
      // this.$router.replace('/')
    },
    init(){
      this.uname=this.userInfo.uname
    }
  },
  created(){
    this.init()
  }
};
</script>

<style>
.regback {
  height: 750px;
  width: 100%;
  text-align: center;
}

.register3 {
  height: 50%;
  width: 50%;
  background-color: rgb(252, 247, 252);
  border-radius: 30px;
  box-shadow: 1px #383737;
  text-align: center;
  margin: auto;
}

#regtitle2 {
  height: 15%;
  width: 100%;
  text-align: center;
  font-family: "华文行楷";
  font-size: 30px;
  padding-top: 10px;
}

.regtitle3 {
  height: 15%;
  width: 100%;
  text-align: center;
  font-family: "华文行楷";
  font-size: 30px;
  padding-top: 2px;
}

#inputusername {
  margin: auto;
  height: 16%;
  width: 62%;
  text-align: left;
  font-family: "华文行楷";
  font-size: 20px;
}

#inputpassword {
  margin: auto;
  height: 16%;
  width: 62%;
  text-align: left;
  font-family: "华文行楷";
  font-size: 20px;
}

#inputpassword1 {
  margin: auto;
  height: 16%;
  width: 62%;
  text-align: left;
  font-family: "华文行楷";
  font-size: 20px;
}

.registerbt2 {
  background-color: rgb(17, 212, 226);
  width: 150px;
  height: 45px;
  margin-top: 25px;
  font-family: "华文行楷";
  font-size: 25px;
  text-align: center;
}
</style>