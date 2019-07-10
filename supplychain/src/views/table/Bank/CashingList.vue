<template>
  <div id="表格部分" class="tablewin">
    <div>
      <div
        :style="{'background':'#f2f2f2','height':'40px','padding-top':'10px','padding-bottom':'5px'}"
      >
        <h3 :style="{'color':'black'}">Token待兑现表</h3>
      </div>
      <div :style="{'background':'white','padding-top':'20px','padding-bottom':'20px'}">
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">Id：</div>
          <el-input
            v-model="idKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,nameKey,tokenKey,strtimeKey)"
          ></el-input>
        </label>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">兑换方：</div>
          <el-input
            v-model="nameKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,nameKey,tokenKey,strtimeKey)"
          ></el-input>
        </label>
        <p style="margin-top:20px"></p>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">兑换Token金额：</div>
          <el-input
            v-model="tokenKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,nameKey,tokenKey,strtimeKey)"
          ></el-input>
        </label>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">发起时间：</div>
          <el-input
            v-model="strtimeKey"
            clearable
            :style="{'width':'20%'}"
            @change="search(idKey,nameKey,tokenKey,strtimeKey)"
          ></el-input>
        </label>
      </div>
    </div>
    <el-table :data="tableData" border height="520" style="width: 100%" @cell-click="getIdClick">
      <el-table-column prop="id" label="Id" width="50" align="center"></el-table-column>
      <el-table-column prop="name" label="兑换方"  align="center"></el-table-column>
      <el-table-column prop="amount" label="兑换Token金额"  align="center"></el-table-column>
      <el-table-column prop="time" label="发起时间" align="center"></el-table-column>
      <el-table-column label="操作" align="center" >
        <a href="" @click.prevent="handleExchange">完成兑换</a>
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
        // {
        //   id: "1",
        //   name: "四方精创企业",
        //   token: "100",
        //   ctime: new Date(),
        //   strtime: "",
        // },
        // {
        //   id: "2",
        //   name: "四方精创作业企业",
        //   token: "100",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "3",
        //   name: "三方精创作业企业",
        //   token: "100",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "4",
        //   name: "五精创作业企业",
        //   token: "100",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "5",
        //   name: "五方精创企业",
        //   token: "100",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "6",
        //   name: "六方精创作业企业",
        //   token: "100",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "7",
        //   name: "六方精创企业",
        //   token: "100",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "8",
        //   name: "四方精创作业企业",
        //   token: "200",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "9",
        //   name: "四方精创作业企业",
        //   token: "200",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "10",
        //   name: "四方精创作业企业",
        //   token: "200",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "11",
        //   name: "四方精创作业企业",
        //   token: "200",
        //   ctime: new Date(),
        //   strtime: ""
        // },
        // {
        //   id: "12",
        //   name: "四方精创作业企业",
        //   token: "200",
        //   ctime: new Date(),
        //   strtime: ""
        // }
      ],
      tableData: [],
      id: "1",
      name: "",
      time: "",
      strtime: "",
      amount:"",
      idKey: "",
      nameKey: "",
      tokenKey: "",
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
        url:"http://localhost:8088/bank/exchangeList",
        method:"get",
      }).then(data =>{
        // console.log(data);
        console.log("显示待兑现token表")
        this.tableData = data;
        this.list=this.tableData;
      })
    },
    handleExchange(){
      //无用
    },
    getIdClick(item,attribute){
        if(attribute.label=="操作"){
            this.idClick=item.id
            var index=this.list.findIndex(item =>{
              if(item.id==this.idClick) return true
            })
          this.$api({
            url:"http://localhost:8088/token/exchange",
            method:"post",
            data:{
              id: this.list[index].id
            }
          }).then((response) =>{
            console.log("成功兑现")
            //console.log(response);
          })
          this.list.splice(index,1)
        }
        this.search(this.idKey,this.nameKey,this.tokenKey,this.strtimeKey)
    },
    search(idKey, nameKey, tokenKey, strtimeKey) {
      this.tableData = [];
      this.list.forEach(item => {
        if (
          item.id.toString().indexOf(idKey.toString()) != -1 &&
          item.name.indexOf(nameKey) != -1 &&
          item.amount.toString().indexOf(tokenKey.toString()) != -1 &&
          item.time.indexOf(strtimeKey) != -1
        )
          this.tableData.push(item);
      });
    },
    // setTime(dt){
    //     var y = dt.getFullYear();
    //     var m = dt.getMonth();
    //     var d = dt.getDate();
    //     var hh = dt.getHours();
    //     var mm = dt.getMinutes();
    //     var ss = dt.getSeconds();
    //     return y + "-" + m + "-" + d + " " + hh + ":" + mm + ":" + ss;
    // },
    // init() {
    //   for (let index = 0; index < this.list.length; index++) {
    //     const element = this.list[index];
    //     this.list[index].strtime=this.setTime(this.list[index].ctime)
    //   }
    //   this.tableData = this.list;
    // }
  },
};
</script>

<style>
.tablewin {
  background-color: lightblue;
}
</style>
