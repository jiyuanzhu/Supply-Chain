<template>
  <div class="regback" :style="{regback,'padding-top':'50px'}">
    <div id="register2">
      <div id="regtitle2">
        <p>账户信息</p>
      </div>
      <el-row :gutter="21">
        <el-col :span="4">&nbsp;</el-col>
        <el-col :span="4">
          <p style="margin-top:8px"></p>
          <label for="uname">
            <div id="inputusername" :style="{'display':'inline'}">用户名</div>
          </label>
        </el-col>
        <el-col :span="13">
          <el-input id="uname" v-model="uname" clearable :style="{'width':'80%','float':'left'}"></el-input>
        </el-col>
      </el-row>
      <p style="margin-top:30px"></p>
      <el-row :gutter="21">
        <el-col :span="4">&nbsp;</el-col>
        <el-col :span="4">
          <p style="margin-top:8px"></p>
          <label for="cname">
            <div id="inputusername" :style="{'display':'inline'}">公司名</div>
          </label>
        </el-col>
        <el-col :span="13">
          <el-input id="cname" v-model="cname" clearable :style="{'width':'80%','float':'left'}"></el-input>
        </el-col>
      </el-row>
      <p style="margin-top:30px"></p>
      <el-row :gutter="21">
        <el-col :span="4">&nbsp;</el-col>
        <el-col :span="4">
          <p style="margin-top:8px"></p>
          <label for="phone">
            <div id="inputusername" :style="{'display':'inline'}">电话</div>
          </label>
        </el-col>
        <el-col :span="13">
          <el-input id="phone" v-model="phone" clearable :style="{'width':'80%','float':'left'}"></el-input>
        </el-col>
      </el-row>
      <p style="margin-top:30px"></p>
      <el-row :gutter="21">
        <el-col :span="4">&nbsp;</el-col>
        <el-col :span="4">
          <p style="margin-top:8px"></p>
          <label for="address">
            <div id="inputusername" :style="{'display':'inline'}">地址</div>
          </label>
        </el-col>
        <el-col :span="13">
          <el-input id="address" v-model="address" clearable :style="{'width':'80%','float':'left'}"></el-input>
        </el-col>
      </el-row>
      <p style="margin-top:30px"></p>
      <el-row :gutter="21">
        <el-col :span="4">&nbsp;</el-col>
        <el-col :span="4">
          <p style="margin-top:8px"></p>
          <label for="scale">
            <div id="inputusername" :style="{'display':'inline'}">规模</div>
          </label>
        </el-col>
        <el-col :span="13">
          <el-input id="scale" v-model="scale" clearable :style="{'width':'80%','float':'left'}"></el-input>
        </el-col>
      </el-row>
      <p style="margin-top:30px"></p>
      <el-row :gutter="21">
        <el-col :span="4">&nbsp;</el-col>
        <el-col :span="4">
          <p style="margin-top:8px"></p>
          <label for="belisted">
            <div id="inputusername" :style="{'display':'inline'}">是否上市</div>
          </label>
        </el-col>
        <el-col :span="13">
          <div id="belisted" class="regtitle3" :style="{'width':'70%','float':'left'}">
          <el-radio v-model="belisted" label="1">是</el-radio>
          <el-radio v-model="belisted" label="0">否</el-radio>
          </div>
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
      uname: "",
      cname: "",
      phone: "",
      address: "",
      scale: "",
      belisted: "",
      regback: {
        // backgroundImage: "url(" + require("@/assets/back1.jpg") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%"
      }
    };
  },
  methods: {
    changeCertain() {
      this.$api({
          url:"http://localhost:8088/user/info",
          method:"post",
          data:{
            id: this.userInfo.id,
            name: this.userInfo.cname = this.name,
            address: this.address,
            telephone: this.phone,
            size: this.scale,
            list: this.belisted
          }
        }).then((response) =>{
          console.log("修改个人信息")
          // console.log(response);
        })
    },
    init(){
      this.$api({
        url:"http://localhost:8088/user/info",
        method:"get",
        params:{
          id: this.userInfo.id
        }
      }).then(data =>{
        console.log("显示个人信息")
        this.cname=data.info.name
        this.address=data.info.address
        this.phone=data.info.telephone
        this.scale=data.info.size
        this.belisted=data.info.list
        // console.log(response);
      })
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

#register2 {
  height: 85%;
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