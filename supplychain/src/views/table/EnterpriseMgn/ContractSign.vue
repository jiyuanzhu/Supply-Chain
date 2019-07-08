<template>
  <div class="containWins">
    <div>
      <div :style="{'background':'#f2f2f2','height':'40px','padding-top':'10px','padding-bottom':'5px'}">
        <h3 :style="{'color':'black'}">合同签署</h3>
      </div>
      <div :style="{'background':'white','padding-top':'80px','padding-bottom':'20px'}">
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">合同名称：</div>
          <el-input v-model="name" clearable :style="{'width':'30%'}"></el-input>
        </label>
        <p style="margin-top:60px"> </p>
         <label>
          <div :style="{'display':'inline'}">甲方：</div>
          <el-input v-model="partA" clearable :style="{'width':'20%'}"></el-input>
        </label>
        <p style="margin-top:60px"> </p>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">乙方：</div>
          <el-input v-model="partB" clearable :style="{'width':'20%'}"></el-input>
        </label>
        <p style="margin-top:50px"> </p>
        <!-- action="后端链接" -->
        <el-upload
          class="upload-demo"
          action="https://jsonplaceholder.typicode.com/posts/"  
          :before-remove="beforeRemove"
          multiple
          :limit="1"
          :on-exceed="handleExceed"
          :file-list="fileList">
          <el-button type="primary" round>添加合同文本</el-button>
        </el-upload>
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
      fileList: [{name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'}],
      list: [{id:"1",name:"",partA:"",partB:"",ctime:"",contractTXT:null}],
      id: "",
      name: "",
      partA: "",
      partB: "",
      ctime: "",
    };
  },
  methods: {
    handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${ file.name }？`);
    },
    addcontractTXT(){

    },
    addContract(){
        var randomid=false
        do{
            this.id=Math.floor(Math.random()*(1000-1))+1;
            this.id = this.id.toString()
            randomid=this.list.every((item)=>{
                if(item.id==this.id)
                return true 
            })
            if(this.list.length==0) randomid=false 
        }while(randomid)
        this.ctime=new Date()
        this.list.push({id:this.id,name:this.name,partA:this.partA,partB:this.partB,ctime:this.ctime})
    },    
    init(){
    }
  },
  mounted(){
    {this.init()}
  }
};

</script>

<style>
.containWins {
  height: 715px;
}
</style>
