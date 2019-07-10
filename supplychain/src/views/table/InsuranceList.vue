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
      <el-table-column prop="insured" label="投保人" width="160" align="center"></el-table-column>
      <el-table-column prop="insurer" label="承保人" width="160" align="center"></el-table-column>
      <el-table-column prop="time" label="创建时间" width="160" align="center"></el-table-column>
      <el-table-column prop="cost" label="保单费用" align="center"></el-table-column>
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
      tokenCostKey: "",
      geturl:""
    };
  },
  created(){

    this.getList()
  },
  methods: {
    getList(){
      this.$api({
        url:"http://localhost:8088/policy/list",
        method:"get",
        params: {
          name : this.userInfo.cname
        }
      }).then(data =>{
        console.log(data)
        console.log("保单列表")
        // console.log(this.company_name);
        // console.log(data);
        this.tableData = data;
        this.list=this.tableData
      })
    },
    search(idKey, partAKey, partBKey, strtimeKey, tokenCostKey) {
      this.tableData = [];
      this.list.forEach(item => {
        if (
          item.id.toString().indexOf(idKey.toString()) != -1 &&
          item.insured.indexOf(partAKey) != -1 &&
          item.insurer.indexOf(partBKey) != -1 &&
          item.time.indexOf(strtimeKey) != -1 &&
          item.cost.toString().indexOf(tokenCostKey.toString()) != -1
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
