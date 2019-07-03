<template>
  <div>
    <el-row class="container">

      <el-col :span="24" class="topbar-wrap">
        <div class="topbar-logo topbar-btn">
          <a href="/"><img src="@/assets/logo.png" style="padding-left:8px;"></a>
        </div>
        <div class="topbar-logos">
          <a href="/" style="color: #fff;"><span v-show="!$store.state.collapsed">区块链管理系统</span></a>
        </div>
        <div class="topbar-title">
          <el-row v-show="$store.state.topNavState==='login'">
            <el-col :span="24">
            </el-col>
          </el-row>
          <el-row v-show="$store.state.topNavState==='user'">
            <el-col :span="24">
              <el-menu  class="el-menu-demo" mode="horizontal"  :router="true">
                <el-menu-item index="1">个人信息</el-menu-item>
                <el-menu-item index="2">修改密码</el-menu-item>
                <el-menu-item @click="logout">退出登录</el-menu-item>
              </el-menu>
            </el-col>
          </el-row>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  export  default {
    name:"TopNav",
    data(){
      return{
        nickname:'',
      }
    },
    created(){
      console.log("top")
    },
    mounted(){
      let name = window.localStorage.getItem('access-user');
      name = JSON.parse(name)
      this.nickname = name || '';
    },
    methods:{
      logout(){
        this.$confirm('确认退出吗?', '提示',
          {onfirmButtonClass: 'el-button--warning'}).then(() =>
        {
          localStorage.removeItem('access-user');

        })

      }
    }
  }
</script>

<style>
  .container {
    position: absolute;
    padding: 0;
    width: 100%;
  }

  .container .topbar-wrap {
    height: 50px;
    line-height: 50px;
    background: #373d41;
    padding: 0px;
  }

  .container .topbar-wrap .topbar-btn {
    color: #fff;
  }

  .container .topbar-wrap .topbar-logo {
    float: left;
    width: 60px;
    line-height: 26px;
  }

  .container .topbar-wrap .topbar-logos {
    float: left;
    width: 128px;
    line-height: 48px;
    font-size: 14px;
  }

  .container .topbar-wrap .topbar-logo img, .container .topbar-wrap .topbar-logos img {
    height: 30px;
    margin-top: 12px;
    margin-left: 2px;
  }

  .container .topbar-wrap .topbar-title {
    float: right;
    text-align: right;
    padding-left: 10px;
    /*border-left: 1px solid #000;*/
  }

  .topbar-title .el-menu--horizontal {
    background-color: transparent;
  }

  .el-menu--horizontal > .el-menu-item:not(.is-disabled):hover, .el-menu--horizontal > .el-menu-item:not(.is-disabled):focus, .el-menu--horizontal > .el-menu-item.is-active {
    color: #ffffff;
    background-color: transparent;
    border-bottom: 2px solid #409EFF !important;
  }

  .topbar-title .el-menu--horizontal > .el-menu-item {
    height: 50px;
    line-height: 50px;
    color: #fff;
  }
</style>
