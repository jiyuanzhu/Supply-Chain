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
    <el-table :data="tableData" border height="495" :style="{'width':'100%'}"  @cell-click="detail">
      <el-table-column prop="id" label="订单编号" width="100" align="center"></el-table-column>
      <el-table-column prop="name" label="物流公司" width="160" align="center"></el-table-column>
      <el-table-column prop="partA" label="寄货方" width="160" align="center"></el-table-column>
      <el-table-column prop="partB" label="收货方" width="160" align="center"></el-table-column>
      <el-table-column prop="strtime" label="创建时间" width="160" align="center"></el-table-column>
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
          orderState: "待收货"
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
          orderState: "待收货"
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
          orderState: "待收货"
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
      idKey: "",
      nameKey: "",
      partAKey: "",
      partBKey: "",
      strtimeKey: "",
      orderState: "",
      orderStateKey: ""
    };
  },
  methods: {
    search(idKey, nameKey, partAKey, partBKey, strtimeKey,orderStateKey) {
      this.tableData = [];
      this.list.forEach(item => {
        if (
          item.id.indexOf(idKey) != -1 &&
          item.name.indexOf(nameKey) != -1 &&
          item.partA.indexOf(partAKey) != -1 &&
          item.partB.indexOf(partBKey) != -1 &&
          item.strtime.indexOf(strtimeKey) != -1 &&
          item.orderState.indexOf(orderStateKey) != -1
        )
          this.tableData.push(item);
      });
    },
    detail(item) {},
    init() {
      for (let index = 0; index < this.list.length; index++) {
        const element = this.list[index];
        var dt = element.ctime;
        var y = dt.getFullYear();
        var m = dt.getMonth();
        var d = dt.getDate();
        var hh = dt.getHours();
        var mm = dt.getMinutes();
        var ss = dt.getSeconds();
        this.list[index].strtime =
          y + "-" + m + "-" + d + " " + hh + ":" + mm + ":" + ss;
      }
      this.tableData = this.list;
    }
  },
  mounted() {
    {
      this.init();
    }
  }
};
</script>

<style>
.tablewin {
  background-color: lightblue;
}
</style>
