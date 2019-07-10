<template>
  <div id="表格部分" class="tablewin">
    <div>
      <div
        :style="{'background':'#f2f2f2','height':'40px','padding-top':'10px','padding-bottom':'5px'}"
      >
        <h3 :style="{'color':'black'}">合同列表</h3>
      </div>
      <div :style="{'background':'white','padding-top':'20px','padding-bottom':'20px'}">
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">Id：</div>
          <el-input
            v-model="idKey"
            clearable
            :style="{'width':'30%'}"
            @change="search(idKey,nameKey,partAKey,partBKey,strtimeKey)"
          ></el-input>
        </label>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">合同名称：</div>
          <el-input
            v-model="nameKey"
            clearable
            :style="{'width':'30%'}"
            @change="search(idKey,nameKey,partAKey,partBKey,strtimeKey)"
          ></el-input>
        </label>
        <p style="margin-top:20px"></p>
        <label>
          <div :style="{'display':'inline'}">甲方：</div>
          <el-input
            v-model="partAKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,nameKey,partAKey,partBKey,strtimeKey)"
          ></el-input>
        </label>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">乙方：</div>
          <el-input
            v-model="partBKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,nameKey,partAKey,partBKey,strtimeKey)"
          ></el-input>
        </label>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">添加时间：</div>
          <el-input
            v-model="strtimeKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,nameKey,partAKey,partBKey,strtimeKey)"
          ></el-input>
        </label>
      </div>
    </div>
    <el-table :data="tableData" border height="520" style="width: 100%" @cell-click="detail">
      <el-table-column prop="id" label="Id" width="50" align="center"></el-table-column>
      <el-table-column prop="name" label="合同名称" width="160" align="center"></el-table-column>
      <el-table-column prop="partyA" label="甲方" width="160" align="center"></el-table-column>
      <el-table-column prop="partyB" label="乙方" width="160" align="center"></el-table-column>
      <el-table-column prop="ctime" label="签署时间" align="center"></el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      list: [
        // {
        //   id: "1",
        //   name: "四方精创合同",
        //   partA: "老师",
        //   partB: "学生",
        //   ctime: new Date(),
        //   strtime: "",
        //   contractTXT: null
        // },
        // {
        //   id: "2",
        //   name: "四方精创作业合同",
        //   partA: "学生",
        //   partB: "老师",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "3",
        //   name: "三方精创作业合同",
        //   partA: "学生",
        //   partB: "老师",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "4",
        //   name: "五精创作业合同",
        //   partA: "学生",
        //   partB: "老师",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "5",
        //   name: "五方精创合同",
        //   partA: "老师",
        //   partB: "学生",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "6",
        //   name: "六方精创作业合同",
        //   partA: "学生",
        //   partB: "老师",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "7",
        //   name: "六方精创合同",
        //   partA: "老师",
        //   partB: "学生",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "8",
        //   name: "四方精创作业合同",
        //   partA: "学生",
        //   partB: "老师",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "9",
        //   name: "四方精创作业合同",
        //   partA: "学生",
        //   partB: "老师",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "10",
        //   name: "四方精创作业合同",
        //   partA: "学生",
        //   partB: "老师",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "11",
        //   name: "四方精创作业合同",
        //   partA: "学生",
        //   partB: "老师",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "12",
        //   name: "四方精创作业合同",
        //   partA: "学生",
        //   partB: "老师",
        //   ctime: new Date(),
        //   strtime: ""
        // }
      ],
      tableData: [],
      id: "",
      name: "",
      partyA: "",
      partyB: "",
      ctime: "",
      contractTXT: null,
      idKey: "",
      nameKey: "",
      partAKey: "",
      partBKey: "",
      strtimeKey: "",
      company_name:""
    };
  },
  created(){
    this.getList();
  },
  methods: {
    getList(){
      this.company_name = this.userInfo.cname
      this.$api({
        url:"http://localhost:8088/contract/list",
        method:"get",
        params: {
          company_name : this.company_name,
        }
      }).then(data =>{
        console.log("合同列表")
        // console.log(this.company_name);
        // console.log(data);
        this.tableData = data;
        this.list=this.tableData
      })
    },
    search(idKey, nameKey, partAKey, partBKey, strtimeKey) {
      this.tableData = [];
      this.list.forEach(item => {
        if (
          item.id.toString().indexOf(idKey.toString()) != -1 &&
          item.name.indexOf(nameKey) != -1 &&
          item.partyA.indexOf(partAKey) != -1 &&
          item.partyB.indexOf(partBKey) != -1 &&
          item.ctime.indexOf(strtimeKey) != -1
          // item.id.toString().indexOf(idKey.toString()) != -1 &&
          // item.name.toString().indexOf(nameKey.toString()) != -1 &&
          // item.partyA.toString().indexOf(partAKey.toString()) != -1 &&
          // item.partyB.toString().indexOf(partBKey.toString()) != -1 &&
          // item.ctime.toString().indexOf(strtimeKey.toString()) != -1
        )
          this.tableData.push(item);
      });
    },
    // 查看合同文件
    detail(item) {

    },
  },
};
</script>

<style>
.tablewin {
  background-color: lightblue;
}
</style>
