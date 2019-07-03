<template>
  <el-menu :default-active="$route.path" router :collapse="collapsed" ref="leftNavigation">
    <template v-for="(issue,index) in $router.options.routes">
      <template v-if="issue.name === $store.state.leftNavState">
        <template v-for="(item,index) in issue.children">
          <el-submenu v-if="!item.leaf" :index="index+''" v-show="item.menuShow">
            <template slot="title"><i :class="item.iconCls"></i><span slot="title">{{item.name}}</span></template>
            <el-menu-item v-for="term in item.children" :key="term.path" :index="term.path"
                          :class="$route.path===term.path?'is-active':''"v-show="term.menuShow">
              <span slot="title">{{term.name}}</span>
            </el-menu-item>
          </el-submenu>
          <el-menu-item v-else-if="item.leaf" :index="item.path"
                        :class="$route.path===item.path?'is-active':''">
            <i :class="item.iconCls"></i><span slot="title">{{item.name}}</span>
          </el-menu-item>
        </template>
      </template>
    </template>
  </el-menu>
</template>

<script>
  export default {
    data(){
      return{
        collapsed: this.$store.state.collapsed,
      }
    },
    methods: {

    }
  }

</script>

<style>
  * {
    margin: 0;
    padding: 0;
  }
</style>
