<template>
  <div class="back" :style="back">
    <div id="top">
      <TopNav></TopNav>
    </div>
    <div id="body">
      <div id="body1"></div>
      <div id="body2">
        <div id="bank" v-on:click="banklogin" :style="bankback">
        </div>
        <div id="enterprise" v-on:click="enterpriselogin" :style="enterpriseback">
        </div>
      </div>
      <div id="body3"></div>
      <div id="body4">
        <div id="trans" v-on:click="translogin" :style="transback">
        </div>
        <div id="insurance" v-on:click="insurancelogin" :style="insuranceback">
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
        backgroundImage: "url(" + require("@/assets/back1.jpg") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%",
      },
      bankback:{
        backgroundImage: "url(" + require("@/assets/banklogo.jpg") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%",
      },
      enterpriseback:{
        backgroundImage: "url(" + require("@/assets/enterpriselogo.jpg") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%",
      },
      transback:{
        backgroundImage: "url(" + require("@/assets/translogo.jpg") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%",
      },
      insuranceback:{
        backgroundImage: "url(" + require("@/assets/insurancelogo.jpg") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%",
      },
    }
  },
  methods:{
    banklogin(){
      // this.$router.replace('/banklogin')
      this.loginPage.pageType="bank"
      this.$router.replace('/Login')
    },
    enterpriselogin(){
      // this.$router.replace('/enterpriselogin')
      this.loginPage.pageType="enterprise"
      this.$router.replace('/Login')
    },
    translogin(){
      // this.$router.replace('/translogin')
      this.loginPage.pageType="transport"
      this.$router.replace('/Login')
    },
    insurancelogin(){
      // this.$router.replace('/insurancelogin')
      this.loginPage.pageType="insurance"
      this.$router.replace('/Login')
    }
  }
}
</script> 

<style>

.back{
  height:750px;
  width:100%;
  
}

#top{
  height:13%;
  width:100%;
}

#body{
  height:87%;
  width:100%;
  text-align:center;
}

#body1{
  height:7%;
  width:50%;
  margin:auto;
}

#body2{
  height:35%;
  width:50%;
  margin:auto;
}

#body3{
  height:10%;
  width:50%;
  margin:auto;
}

#body4{
  height:35%;
  width:50%;
  margin:auto;
}

#bank{
  height:100%;
  width:46%;
  float:left;
  background-color: rgb(226, 68, 29);
  border:1px solid white;
  border-radius:10px;
}

#enterprise{
  height:100%;
  width:46%;
  float:right;
  background-color: rgb(197, 236, 19);
  border:1px solid white;
  border-radius:10px;
}

#trans{
  height:100%;
  width:46%;
  float:left;
  background-color: rgb(8, 255, 37);
  border:1px solid white;
  border-radius:10px;
}

#insurance{
  height:100%;
  width:46%;
  float:right;
  background-color: rgb(197, 31, 169);
  border:1px solid white;
  border-radius:10px;
}

</style>
