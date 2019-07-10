<template>
  <div class="containWins">
    <div>
      <div
        :style="{'background':'#f2f2f2','height':'40px','padding-top':'10px','padding-bottom':'5px'}"
      >
        <h3 :style="{'color':'black'}">确认订单</h3>
      </div>
      <div :style="{'background':'white','padding-top':'50px','padding-bottom':'20px'}">
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">物流公司：</div>
          <el-input v-model="name" clearable :style="{'width':'30%'}"></el-input>
        </label>
        <p style="margin-top:30px"></p>
        <label>
          <div :style="{'display':'inline'}">寄货方：</div>
          <el-input v-model="partA" clearable :style="{'width':'20%'}"></el-input>
        </label>
        <p style="margin-top:30px"></p>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">收货方：</div>
          <el-input v-model="partB" clearable :style="{'width':'20%'}"></el-input>
        </label>
        <p style="margin-top:30px"></p>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">运输物品：</div>
          <el-input v-model="goods" clearable :style="{'width':'20%'}"></el-input>
        </label>
        <p style="margin-top:30px"></p>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">费用：</div>
          <el-input v-model="tokenCost" clearable :style="{'width':'20%'}"></el-input>
        </label>
        <p style="margin-top:40px"></p>
        <el-upload
          class="upload-demo"
          action="http://localhost:8088/trans/upload"
          :before-remove="beforeRemove"
          multiple
          :limit="1"
          :on-exceed="handleExceed"
          :file-list="fileList">
          <el-button type="primary" round>添加订单文本</el-button>
        </el-upload>
        <p style="margin-top:40px"></p>
        <el-button type="primary" round @click="addLogistics">上传</el-button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      fileList:[],
      list: [
        {
          id: "1",
          name: "",
          partA: "",
          partB: "",
          ctime: "",
          orderState: "",
          goods: "",
          tokenCost: ""
        }
      ],
      id: "",
      name: "",
      partA: "",
      partB: "",
      goods: "",
      tokenCost: "",
      ctime: ""
    };
  },
  methods: {
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
    addLogistics() {
      // var randomid = false;
      // do {
      //   this.id = Math.floor(Math.random() * (1000 - 1)) + 1;
      //   this.id = this.id.toString()
      //   randomid = this.list.every(item => {
      //     if (item.id == this.id) return true;
      //   });
      //   if(this.list.length==0) randomid=false 
      // } while (randomid);
      // this.ctime = new Date();
      // this.list.push({
      //   id: this.id,
      //   name: this.name,
      //   partA: this.partA,
      //   partB: this.partB,
      //   ctime: this.ctime,
      //   orderState: "待发货",
      //   goods: this.goods,
      //   tokenCost: this.tokenCost
      // });
      this.ctime=this.setTime(new Date())
        this.$api({
        url:"http://localhost:8088/trans/add",
        method:"post",
        data:{
          company:this.name,
          sender:this.partA,
          receiver:this.partB,
          item:this.goods,
          time:this.ctime,
          cost:this.tokenCost
        },
          emulateJson:true
      }).then((response) =>{
        console.log("物流订单确定")
        // console.log(response);
      })
    },
    init() {}
  },
  mounted() {
    {
      this.init();
    }
  }
};
</script>

<style>
.containWins {
  height: 715px;
}
</style>
