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
    <el-table :data="tableData" border height="520" style="width: 100%" @cell-click="getIdClick">
      <el-table-column prop="id" label="Id"  width="70" align="center"></el-table-column>
      <el-table-column prop="name" label="合同名称" align="center"></el-table-column>
      <el-table-column prop="partA" label="甲方" align="center"></el-table-column>
      <el-table-column prop="partB" label="乙方" align="center"></el-table-column>
      <el-table-column prop="strtime" label="签署时间" align="center"></el-table-column>
      <el-table-column label="确认操作" align="center" >
        <a href="" @click.prevent="">确认签署</a>
      </el-table-column>
      <el-table-column label="取消操作" align="center" >
        <a href="" @click.prevent="">取消签署</a>
      </el-table-column>
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
          name: "四方精创合同",
          partA: "老师",
          partB: "学生",
          ctime: new Date(),
          strtime: "",
          contractTXT: null
        },
        {
          id: "2",
          name: "四方精创作业合同",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: ""
        },
        {
          id: "3",
          name: "三方精创作业合同",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: ""
        },
        {
          id: "4",
          name: "五精创作业合同",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: ""
        },
        {
          id: "5",
          name: "五方精创合同",
          partA: "老师",
          partB: "学生",
          ctime: new Date(),
          strtime: ""
        },
        {
          id: "6",
          name: "六方精创作业合同",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: ""
        },
        {
          id: "7",
          name: "六方精创合同",
          partA: "老师",
          partB: "学生",
          ctime: new Date(),
          strtime: ""
        },
        {
          id: "8",
          name: "四方精创作业合同",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: ""
        },
        {
          id: "9",
          name: "四方精创作业合同",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: ""
        },
        {
          id: "10",
          name: "四方精创作业合同",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: ""
        },
        {
          id: "11",
          name: "四方精创作业合同",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: ""
        },
        {
          id: "12",
          name: "四方精创作业合同",
          partA: "学生",
          partB: "老师",
          ctime: new Date(),
          strtime: ""
        }
      ],
      tableData: [],
      id: "",
      name: "",
      partA: "",
      partB: "",
      ctime: "",
      idClick: "",
      contractTXT: null,
      idKey: "",
      nameKey: "",
      partAKey: "",
      partBKey: "",
      strtimeKey: ""
    };
  },
  methods: {
    getIdClick(item,attribute){
        if(attribute.label=="确认操作" || attribute.label=="取消操作" ){
            this.idClick=item.id
            var index=this.list.findIndex(item =>{
              if(item.id==this.idClick) return true
          })
          this.list.splice(index,1)
          this.search(this.idKey,this.nameKey,this.partAKey,this.partBKey,this.strtimeKey)
        } else{ //显示合约文本

        }
    },
    search(idKey, nameKey, partAKey, partBKey, strtimeKey) {
      this.tableData = [];
      this.list.forEach(item => {
        if (
          item.id.indexOf(idKey) != -1 &&
          item.name.indexOf(nameKey) != -1 &&
          item.partA.indexOf(partAKey) != -1 &&
          item.partB.indexOf(partBKey) != -1 &&
          item.strtime.indexOf(strtimeKey) != -1
        )
          this.tableData.push(item);
      });
    },
    // 查看合同文件
    detail(item) {

    },
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
