<template>
  <div class="containWins">
    <div>
      <div :style="{'background':'#f2f2f2','height':'40px','padding-top':'10px','padding-bottom':'5px'}">
        <h3 :style="{'color':'black'}">合同签署</h3>
      </div>
      <div :style="{'background':'white','padding-top':'60px','padding-bottom':'20px'}">
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">合同名称：</div>
          <el-input v-model="name" clearable :style="{'width':'30%'}"></el-input>
        </label>
        <p style="margin-top:50px"> </p>
         <label>
          <div :style="{'display':'inline'}">甲方：</div>
          <el-input v-model="partyA" clearable :style="{'width':'20%'}"></el-input>
        </label>
        <p style="margin-top:50px"> </p>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">乙方：</div>
          <el-input v-model="partyB" clearable :style="{'width':'20%'}"></el-input>
        </label>
        <p style="margin-top:50px"> </p>
        <!-- action="后端链接" -->
        <el-upload
          class="upload-demo"
          action="http://localhost:8088/contract/uploadA"  
          :before-remove="beforeRemove"
          multiple
          :limit="1"
          :on-success="handleSuccess"
          :on-exceed="handleExceed"
          :file-list="fileList">
          <el-button type="primary" round>添加合同文本</el-button>
        </el-upload>
        <p style="margin-top:40px"></p>
        <div :style="{'display':'inline'}">合同文本hash值：&nbsp;&nbsp;&nbsp;&nbsp;{{contractHash}}</div>
        <p style="margin-top:40px"></p>
        <el-button type="primary" round @click="addContract">上传</el-button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      fileList: [],
      list: [{id:"1",name:"",partyA:"",partyB:"",ctime:"",contractTXT:null}],
      id: "",
      name: "",
      partyA: "",
      partyB: "",
      ctime: "",
      contractHash: ""
    };
  },
  methods: {
    handleSuccess(response){
      this.contractHash=response.info.partyAHash
    },
    handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${ file.name }？`);
    },
    setTime(dt){
        var y = dt.getFullYear();
        var m = dt.getMonth();
        var d = dt.getDate();
        return y + "-" + m + "-" + d;
    },
    addContract(){
        // var randomid=false
        // do{
        //     this.id=Math.floor(Math.random()*(1000-1))+1;
        //     this.id = this.id.toString()
        //     randomid=this.list.every((item)=>{
        //         if(item.id==this.id)
        //         return true 
        //     })
        //     if(this.list.length==0) randomid=false 
        // }while(randomid)
        // this.ctime=new Date()
        // this.list.push({id:this.id,name:this.name,partA:this.partA,partB:this.partB,ctime:this.ctime})

        this.ctime=this.setTime(new Date())
        this.$api({
        url:"http://localhost:8088/contract/signedA",
        method:"post",
        data:{
          name:this.name,
          partyA:this.partyA,
          partyB:this.partyB,
          time:this.ctime
          //合同文本待传
        }
      }).then((response) =>{
        console.log("签署合同")
        // console.log(response);
        //设置contractHash
      } )
    },    
  },
};

</script>

<style>
.containWins {
  height: 715px;
}
</style>
