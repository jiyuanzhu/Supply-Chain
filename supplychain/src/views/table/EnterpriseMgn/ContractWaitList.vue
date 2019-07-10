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
      <el-table-column prop="partyA" label="甲方" align="center"></el-table-column>
      <el-table-column prop="partyB" label="乙方" align="center"></el-table-column>
      <el-table-column prop="ctime" label="签署时间" align="center"></el-table-column>
      <el-table-column prop="partyAHash" label="甲方合同Hash值" align="center"></el-table-column>
      <el-table-column prop="partyBHash" label="乙方合同Hash值" align="center"></el-table-column>
      <el-table-column label="乙方合同操作" align="center" width="160px" >
        <el-upload
          class="upload-demo"
          action="http://localhost:8088/contract/uploadB"  
          :before-remove="beforeRemove"
          multiple
          :limit="1"
          :on-success="handleSuccess"
          :on-exceed="handleExceed"
          :file-list="fileList">
          <el-button type="primary" size="mini" round>上传乙方合同</el-button>
        </el-upload>
      </el-table-column>
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
      fileList: [],
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
      partyA: "",
      partyB: "",
      ctime: "",
      idClick: "",
      contractTXT: null,
      idKey: "",
      nameKey: "",
      partAKey: "",
      partBKey: "",
      strtimeKey: "",
      clickIndex: "",
      partyBHash: "",
      partyBHashList: [],
      poststate: "",

    };
  },
  created() {
    this.getList()
  },
  methods: {
    combinePartyBHash(){
      console.log("here")
      for (let index = 0; index < this.partyBHashList.length; index++) {
        const element = this.partyBHashList[index];
        const idx=this.list.findIndex(item=>{
          if(item.id==element.id) return true
        })
        this.list[idx].partyBHash=element.partyBHash

        console.log(this.list)
        console.log(element.partyBHash)

      }

      this.tableData=this.list
      this.tableData.push({})
      this.tableData.splice(this.tableData.length-1,1)
    },
    handleSuccess(response){
      console.log("合同上传成功")
      console.log(response.info.partyBHash)
      this.partyBHash=response.info.partyBHash
      this.partyBHashList.push({id:this.list[this.clickIndex].id,partyBHash:this.partyBHash})
      this.combinePartyBHash()
    },
    handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${ file.name }？`);
    },
    getList(){
      this.$api({
        url:"http://localhost:8088/contract/unsignedList",
        method:"get",
        params: {
          company_name : this.userInfo.cname,
          state : "0"
        }
      }).then(data =>{
        console.log(this.userInfo.cname)

        console.log("待签列表")
        console.log(data)
        // console.log(this.company_name);
        // console.log(data);
        this.tableData = data;
        this.list=this.tableData
        this.combinePartyBHash()
      })
    },
    getIdClick(item,attribute){
        if(attribute.label=="确认操作" || attribute.label=="取消操作" ){
          if(attribute.label=="确认操作")  this.poststate="1";
           else this.poststate="2"
          this.idClick=item.id
          var index=this.list.findIndex(item =>{
            if(item.id==this.idClick) return true
          })
          this.$api({
            url:"http://localhost:8088/contract/signed",
            method:"post",
            data:{
              id:this.list[index].id,
              state: this.poststate
            }
          }).then((response) =>{
            console.log("确认/取消合同")
            // console.log(response);
            this.getList()
          })
        } else
        if(attribute.label=="乙方合同操作" ){
          this.poststate="0"
          this.idClick=item.id
          var index=this.list.findIndex(item =>{
            if(item.id==this.idClick) return true
          })
          this.clickIndex=index;
          this.$api({
            url:"http://localhost:8088/contract/signed",
            method:"post",
            data:{
              id:this.list[index].id,
              state: this.poststate
            }
          }).then((response) =>{
            console.log("点击上传合同")
            // console.log(response);
          })
        }
    },
    search(idKey, nameKey, partAKey, partBKey, strtimeKey) {
      this.tableData = [];
      this.list.forEach(item => {
        if (
          item.id.toString().indexOf(idKey.toString()) != -1 &&
          item.name.indexOf(nameKey) != -1 &&
          item.partA.indexOf(partAKey) != -1 &&
          item.partB.indexOf(partBKey) != -1 &&
          item.time.indexOf(strtimeKey) != -1
        )
          this.tableData.push(item);
      });
    }
  },
};
</script>

<style>
.tablewin {
  background-color: lightblue;
}
</style>
