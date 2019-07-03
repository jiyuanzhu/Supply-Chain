<template>
  <el-row class="container">
    <el-col :span="24"><router-view name="top"></router-view></el-col>
    <el-col :span="24" class="main">
      <router-view name="aside"></router-view>

      <section class="content-container">
        <div class="grid-content bg-purple-light">
          <transition name="fade" mode="out-in">
            <router-view></router-view>
          </transition>
        </div>
      </section>
    </el-col>
  </el-row>
</template>

<style>
  * {
    margin: 0;
    padding: 0;
  }
  .container {
    position: absolute;
    top: 0px;
    bottom: 0px;
    width: 100%;
  }
  .container .main {
    display: -ms-flexbox;
    display: flex;
    position: absolute;
    top: 50px;
    overflow: hidden;
  }
  .container .content-container {
    background: #f2f2f2;
    -ms-flex: 1;
    flex: 1;
    overflow-y: auto;
    padding: 5px;
  }
  .grid-content {
    border-radius: 2px;
    background-color: #fff;
  }

</style>
