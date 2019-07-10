<template>
  <div id="表格部分" class="tablewin">
    <div>
      <div
        :style="{'background':'#f2f2f2','height':'40px','padding-top':'10px','padding-bottom':'5px'}"
      >
        <h3 :style="{'color':'black'}">订单列表</h3>
      </div>
      <div :style="{'background':'white','padding-top':'20px','padding-bottom':'20px'}">
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">订单编号：</div>
          <el-input
            v-model="idKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,nameKey,partAKey,partBKey,strtimeKey,orderStateKey)"
          ></el-input>
        </label>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">物流公司：</div>
          <el-input
            v-model="nameKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,nameKey,partAKey,partBKey,strtimeKey,orderStateKey)"
          ></el-input>
        </label>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">订单状态：</div>
          <el-input
            v-model="orderStateKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,nameKey,partAKey,partBKey,strtimeKey,orderStateKey)"
          ></el-input>
        </label>
        <p style="margin-top:20px"></p>
        <label>
          <div :style="{'display':'inline'}">寄货方：</div>
          <el-input
            v-model="partAKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,nameKey,partAKey,partBKey,strtimeKey,orderStateKey)"
          ></el-input>
        </label>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">收货方：</div>
          <el-input
            v-model="partBKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,nameKey,partAKey,partBKey,strtimeKey,orderStateKey)"
          ></el-input>
        </label>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">创建时间：</div>
          <el-input
            v-model="strtimeKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,nameKey,partAKey,partBKey,strtimeKey,orderStateKey)"
          ></el-input>
        </label>
      </div>
    </div>
    <el-table :data="tableData" border height="520" :style="{'width':'100%'}"  @cell-click="detail">
      <el-table-column prop="id" label="订单编号" width="100" align="center"></el-table-column>
      <el-table-column prop="company" label="物流公司" width="160" align="center"></el-table-column>
      <el-table-column prop="sender" label="寄货方" width="160" align="center"></el-table-column>
      <el-table-column prop="receiver" label="收货方" width="160" align="center"></el-table-column>
      <el-table-column prop="time" label="创建时间" width="160" align="center"></el-table-column>
      <el-table-column prop="orderState" label="订单状态" align="center"></el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      list: [
        {
          id: "1",
          name: "四方精创公司",
          partA: "老师",
          partB: "学生",
          ctime: new Date(),
          strtime: "",
          orderState: "待收货",//订单状态
          goods: "apple*2,banana*3", //运输物品
          orderTracking: "", //订单追踪
          tokenCost:"", //物流费用
        },
        {
          id: "2",
          name: "四方精创作业公司",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: "",
          orderState: "待发货"
        },
        {
          id: "3",
          name: "三方精创作业公司",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: "",
          orderState: "已完成"
        },
        {
          id: "4",
          name: "五精创作业公司",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: "",
          orderState: "待收货"
        },
        {
          id: "5",
          name: "五方精创公司",
          partA: "老师",
          partB: "学生",
          ctime: new Date(),
          strtime: "",
          orderState: "已送达"
        },
        {
          id: "6",
          name: "六方精创作业公司",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: "",
          orderState: "待收货"
        },
        {
          id: "7",
          name: "六方精创公司",
          partA: "老师",
          partB: "学生",
          ctime: new Date(),
          strtime: "",
          orderState: "待发货"
        },
        {
          id: "8",
          name: "四方精创作业公司",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: "",
          orderState: "待收货"
        },
        {
          id: "9",
          name: "四方精创作业公司",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: "",
          orderState: "已完成"
        },
        {
          id: "10",
          name: "四方精创作业公司",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: "",
          orderState: "待收货"
        },
        {
          id: "11",
          name: "四方精创作业公司",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: "",
          orderState: "已送达"
        },
        {
          id: "12",
          name: "四方精创作业公司",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: "",
          orderState: "待收货"
        }
      ],
      tableData: [],
      id: "",
      name: "",
      partA: "",
      partB: "",
      ctime: "",
      orderState: "", //订单状态
      goods: "", //运输物品
      orderTracking: "", //订单追踪
      tokenCost:"", //物流费用

      idKey: "",
      nameKey: "",
      partAKey: "",
      partBKey: "",
      strtimeKey: "", //日期字符串
      orderStateKey: "",  //订单状态关键字搜索
      geturl:""
    };
  },
  created() {
    this.init()
    this.getList()
  },
  methods: {
    init(){
      switch (this.userInfo.ctype){
        case this.comType.enterprise:
          this.geturl="http://localhost:8088/trans/list"
          break;
        case this.comType.transport:
          this.geturl="http://localhost:8088/trans/list"
          break;
      }
    },
    getList(){
      this.$api({
        url: "http://localhost:8088/trans/list",
        method:"get",
        params: {
          company_name : this.userInfo.cname,
        }
      }).then(data =>{
        console.log("物流信息表")
        // console.log(this.company_name);
        // console.log(data);
        this.tableData = data;
        this.list=this.tableData
      })
    },
    search(idKey, nameKey, partAKey, partBKey, strtimeKey,orderStateKey) {
      this.tableData = [];
      this.list.forEach(item => {
        if (
          item.id.toString().indexOf(idKey.toString()) != -1 &&
          item.company.indexOf(nameKey) != -1 &&
          item.sender.indexOf(partAKey) != -1 &&
          item.receiver.indexOf(partBKey) != -1 &&
          item.time.indexOf(strtimeKey) != -1 &&
          item.orderState.indexOf(orderStateKey) != -1
        )
          this.tableData.push(item);
      });
    },
    detail(item) {},
  }
};
</script>

<style>
.tablewin {
  background-color: lightblue;
}
</style>
