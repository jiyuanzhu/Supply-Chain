<template>
  <div id="表格部分" class="tablewin">
    <div>
      <div
        :style="{'background':'#f2f2f2','height':'40px','padding-top':'10px','padding-bottom':'5px'}">
        <h3 :style="{'color':'black'}">保单列表</h3>
      </div>
      <div :style="{'background':'white','padding-top':'20px','padding-bottom':'20px'}">
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">保单编号：</div>
          <el-input
            v-model="idKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,partAKey,partBKey,strtimeKey,tokenCostKey)"
          ></el-input>
        </label>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">创建时间：</div>
          <el-input
            v-model="strtimeKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,partAKey,partBKey,strtimeKey,tokenCostKey)"
          ></el-input>
        </label>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">保单费用：</div>
          <el-input
            v-model="tokenCostKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,partAKey,partBKey,strtimeKey,tokenCostKey)"
          ></el-input>
        </label>
        <p style="margin-top:20px"></p>
        <label>
          <div :style="{'display':'inline'}">投保人：</div>
          <el-input
            v-model="partAKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,partAKey,partBKey,strtimeKey,tokenCostKey)"
          ></el-input>
        </label>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">承保人：</div>
          <el-input
            v-model="partBKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,partAKey,partBKey,strtimeKey,tokenCostKey)"
          ></el-input>
        </label>
      </div>
    </div>
    <el-table :data="tableData" border height="520" :style="{'width':'100%'}"  @cell-click="detail">
      <el-table-column prop="id" label="保单编号" width="100" align="center"></el-table-column>
      <el-table-column prop="partA" label="投保人" width="160" align="center"></el-table-column>
      <el-table-column prop="partB" label="承保人" width="160" align="center"></el-table-column>
      <el-table-column prop="strtime" label="创建时间" width="160" align="center"></el-table-column>
      <el-table-column prop="tokenCost" label="保单费用" align="center"></el-table-column>
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
          partA: "老师",
          partB: "老师",
          ctime: new Date(),
          strtime: "",
          tokenCost: "20"  //物流费用
        },
        {
          id: "2",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: "",
          tokenCost: "10"
        },
        {
          id: "3",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: "",
          tokenCost: "10"
        },
        {
          id: "4",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: "",
          tokenCost: "30"
        },
        {
          id: "5",
          partA: "老师",
          partB: "学生",
          ctime: new Date(),
          strtime: "",
          tokenCost: "30"
        },
        {
          id: "6",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: "",
          tokenCost: "30"
        },
        {
          id: "7",
          partA: "老师",
          partB: "学生",
          ctime: new Date(),
          strtime: "",
          tokenCost: "20"
        },
        {
          id: "8",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: "",
          tokenCost: "25"
        },
        {
          id: "9",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: "",
          tokenCost: "25"
        },
        {
          id: "10",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: "",
          tokenCost: "25"
        },
        {
          id: "11",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: "",
          tokenCost: "15"
        },
        {
          id: "12",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: "",
          tokenCost: "15"
        }
      ],
      tableData: [],
      id: "",
      partA: "",
      partB: "",
      ctime: "",
      tokenCost:"", //保单费用

      idKey: "",
      partAKey: "",
      partBKey: "",
      strtimeKey: "", //日期字符串
      tokenCostKey: ""
    };
  },
  methods: {
    search(idKey, partAKey, partBKey, strtimeKey, tokenCostKey) {
      this.tableData = [];
      this.list.forEach(item => {
        if (
          item.id.indexOf(idKey) != -1 &&
          item.partA.indexOf(partAKey) != -1 &&
          item.partB.indexOf(partBKey) != -1 &&
          item.strtime.indexOf(strtimeKey) != -1 &&
          item.tokenCost.indexOf(tokenCostKey) != -1
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
