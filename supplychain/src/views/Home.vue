<template>
  <div class="back" :style="back">
    <div id="top">
      <TopNav></TopNav>
    </div>
    <div id="body">
      <div id="body1"></div>
      <div id="body2">
        <div id="bank">
          <el-button @click="banklogin" class="banklogin" :style="bankback"></el-button>
        </div>
        <div id="enterprise">
          <el-button @click="enterpriselogin" class="enterpriselogin" :style="enterpriseback"></el-button>
        </div>
      </div>
      <div id="body3"></div>
      <div id="body4">
        <div id="trans">
          <el-button @click="translogin" class="translogin" :style="transback"></el-button>
        </div>
        <div id="insurance">
          <el-button @click="insurancelogin" class="insurancelogin" :style="insuranceback"></el-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TopNav from '@/views/nav/TopNavLogin'
export default {
  name: 'Home',
  components:{
    TopNav
  },
  data(){
    return{
      back:{
        backgroundImage: "url(" + require("@/assets/logo.png") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%",
      },
      bankback:{
        backgroundImage: "url(" + require("@/assets/logo.png") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%",
      },
      enterpriseback:{
        backgroundImage: "url(" + require("@/assets/logo.png") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%",
      },
      transback:{
        backgroundImage: "url(" + require("@/assets/logo.png") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%",
      },
      insuranceback:{
        backgroundImage: "url(" + require("@/assets/logo.png") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%",
      },
    }
  },
  methods:{
    banklogin(){
      this.$router.replace('/banklogin')
    },
    enterpriselogin(){
      this.$router.replace('/enterpriselogin')
    },
    translogin(){
      this.$router.replace('/translogin')
    },
    insurancelogin(){
      this.$router.replace('/insurancelogin')
    }
  }
}
</script> 

<style>

.back{
  height:690px;
  width:1500px;
  
}

#top{
  height:80px;
  width:1500px;
}

#body{
  height:530px;
  width:1500px;
  text-align:center;
}

#body1{
  height:40px;
  width:700px;
  margin:auto;
}

#body2{
  height:210px;
  width:750px;
  margin:auto;
}

#body3{
  height:40px;
  width:700px;
  margin:auto;
}

#body4{
  height:210px;
  width:750px;
  margin:auto;
}

#bank{
  height:210px;
  width:350px;
  float:left;
  background-color: rgb(226, 68, 29);
}

#enterprise{
  height:210px;
  width:350px;
  float:right;
  background-color: rgb(197, 236, 19);
}

#trans{
  height:210px;
  width:350px;
  float:left;
  background-color: rgb(8, 255, 37);
}

#insurance{
  height:210px;
  width:350px;
  float:right;
  background-color: rgb(197, 31, 169);
}

.banklogin{
  height:210px;
  width:350px;
  float:left;
  background-color: rgb(226, 68, 29);
}
.enterpriselogin{
  height:210px;
  width:350px;
  float:right;
  background-color: rgb(197, 236, 19);
}

.translogin{
  height:210px;
  width:350px;
  float:left;
  background-color: rgb(8, 255, 37);
}

.insurancelogin{
  height:210px;
  width:350px;
  float:right;
  background-color: rgb(197, 31, 169);
}
</style>
