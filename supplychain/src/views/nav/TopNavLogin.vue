<template>
  <div id="title" >
    <button @click="exit" class="exit" :style="exitback"></button>
    <p>超级供应链管理系统</p>
  </div>
</template>



<script>
export default {
  name: 'TopNav',
  data(){
    return{
      exitback:{
        backgroundImage: "url(" + require("@/assets/exit.jpg") + ")",
        backgroundRepeat: "no-repeat",
        backgroundSize: "100%",
      },
    }
  },
  methods:{
    exit(){
      this.$router.replace('/')
    }
  }
}
</script>

<style>

#title{
   font-family:"华文行楷";
   font-size:50px;
   color: black;
   padding-top:5px;
}

.exit{
  float:right;
  margin-right: 10px;
  margin-top:5px;
  height:40px;
  width:40px;
}

</style>



