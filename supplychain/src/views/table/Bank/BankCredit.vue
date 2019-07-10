<template>
  <div id="表格部分" class="tablewin">
    <div>
      <div
        :style="{'background':'#f2f2f2','height':'40px','padding-top':'10px','padding-bottom':'5px'}"
      >
        <h3 :style="{'color':'black'}">银行授信列表</h3>
      </div>
      <div :style="{'background':'white','padding-top':'20px','padding-bottom':'20px'}">
        <div :style="{'display':'inline','font-size':'20px'}">搜索：&nbsp;</div>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">Id：</div>
          <el-input
            v-model="idKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,nameKey,strtimeKey)"
          ></el-input>
        </label>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">企业名称：</div>
          <el-input
            v-model="nameKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,nameKey,strtimeKey)"
          ></el-input>
        </label>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">添加时间：</div>
          <el-input
            v-model="strtimeKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,nameKey,strtimeKey)"
          ></el-input>
        </label>
        <p style="margin-top:20px"></p>
        <div :style="{'display':'inline','font-size':'20px'}">添加：&nbsp;&nbsp;&nbsp;</div>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">企业名称：</div>
          <el-input
            v-model="name"
            clearable
            :style="{'width':'20%'}"
            @keyup.enter.native="add"
          ></el-input>
        </label>
        <div :style="{'display':'inline'}">&nbsp;&nbsp;&nbsp;</div>
        <el-button type="primary" round @click="add">确认授信</el-button>
      </div>
    </div>
    <el-table :data="tableData" border height="520" style="width: 100%" @cell-click="getIdClick">
      <el-table-column prop="id" label="Id" width="50" align="center"></el-table-column>
      <el-table-column prop="name" label="企业名称"  align="center"></el-table-column>
      <el-table-column prop="time" label="授信时间" align="center"></el-table-column>
      <el-table-column prop="limits" label="发放额度" align="center" ></el-table-column>


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
        //   name: "四方精创企业",
        //   ctime: new Date(),
        //   strtime: "",
        // },
        // {
        //   id: "2",
        //   name: "四方精创作业企业",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "3",
        //   name: "三方精创作业企业",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "4",
        //   name: "五精创作业企业",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "5",
        //   name: "五方精创企业",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "6",
        //   name: "六方精创作业企业",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "7",
        //   name: "六方精创企业",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "8",
        //   name: "四方精创作业企业",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "9",
        //   name: "四方精创作业企业",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "10",
        //   name: "四方精创作业企业",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "11",
        //   name: "四方精创作业企业",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "12",
        //   name: "四方精创作业企业",
        //   ctime: new Date(),
        //   strtime: ""
        // }
      ],
      tableData: [],
      id: "1",
      name: "",
      time: "",
      strtime: "",
      limits: "",
      idKey: "",
      nameKey: "",
      strtimeKey: "",
      idClick: ""
    };
  },
  created(){
    this.getList();
  },
  methods: {
    getList(){
      this.$api({
        url:"http://localhost:8088/bank/creditManage/credit",
        method:"get",
      }).then(data =>{
        console.log(data);
        this.tableData = data;
      })
    },
    getIdClick(item,attribute){
        if(attribute.label=="操作"){
            this.idClick=item.id
            var index=this.list.findIndex(item =>{
              if(item.id==this.idClick) return true
          })
          this.list.splice(index,1)
        }
        this.search(this.idKey,this.nameKey,this.strtimeKey)
    },
    add(){
      var randomid = false;
      do {
        this.id = Math.floor(Math.random() * (1000 - 1)) + 1;
        this.id = this.id.toString()
        randomid = this.list.every(item => {
          if (item.id == this.id) return true;
        });
        if(this.list.length==0) randomid=false 
      } while (randomid);
      this.ctime = new Date();
      this.strtime = this.setTime(this.ctime)
      this.list.push({
        id: this.id,
        name: this.name,
        ctime: this.ctime,
        strtime: this.strtime
      });
      this.name=""
      this.search(this.idKey,this.nameKey,this.strtimeKey)
    },
    search(idKey, nameKey, strtimeKey) {
      this.tableData = [];
      this.list.forEach(item => {
        if (
          item.id.indexOf(idKey) != -1 &&
          item.name.indexOf(nameKey) != -1 &&
          item.strtime.indexOf(strtimeKey) != -1
        )
          this.tableData.push(item);
      });
    },
    setTime(dt){
        var y = dt.getFullYear();
        var m = dt.getMonth();
        var d = dt.getDate();
        var hh = dt.getHours();
        var mm = dt.getMinutes();
        var ss = dt.getSeconds();
        return y + "-" + m + "-" + d + " " + hh + ":" + mm + ":" + ss;
    },
    init() {
      for (let index = 0; index < this.list.length; index++) {
        const element = this.list[index];
        this.list[index].strtime=this.setTime(this.list[index].ctime)
        // var dt = element.ctime;
        // var y = dt.getFullYear();
        // var m = dt.getMonth();
        // var d = dt.getDate();
        // var hh = dt.getHours();
        // var mm = dt.getMinutes();
        // var ss = dt.getSeconds();
        // this.list[index].strtime =
        //   y + "-" + m + "-" + d + " " + hh + ":" + mm + ":" + ss;
      }
      this.tableData = this.list;
    }
  },
  mounted() {
    {
      // this.init();
    }
  }
};
</script>

<style>
.tablewin {
  background-color: lightblue;
}
</style>
