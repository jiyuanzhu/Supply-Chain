<template>
  <div class="containWins">
    <div>
      <div
        :style="{'background':'#f2f2f2','height':'40px','padding-top':'10px','padding-bottom':'5px'}"
      >
        <h3 :style="{'color':'black'}">保单购买</h3>
      </div>
      <div :style="{'background':'white','padding-top':'70px','padding-bottom':'20px'}">
        <label>
          <div :style="{'display':'inline'}">投保人：</div>
          <el-input v-model="partA" clearable :style="{'width':'20%'}"></el-input>
        </label>
        <p style="margin-top:50px"></p>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">承保人：</div>
          <el-input v-model="partB" clearable :style="{'width':'20%'}"></el-input>
        </label>
        <p style="margin-top:50px"></p>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">Token费用：</div>
          <el-input v-model="tokenCost" clearable :style="{'width':'20%'}"></el-input>
        </label>
        <p style="margin-top:50px"> </p>
        <el-button type="primary" round @click="addInsuranceTXT">添加保单文本</el-button>
        <p style="margin-top:40px"></p>
        <el-button type="primary" round @click="addInsurance">上传</el-button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      list:[],  
      id: "",
      partA: "",
      partB: "",
      tokenCost: "",
      ctime: ""
    };
  },
  methods: {
    addInsuranceTXT(){},  
    addInsurance() {
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
      this.list.push({
        id: this.id,
        partA: this.partA,
        partB: this.partB,
        ctime: this.ctime,
        tokenCost: this.tokenCost
      });
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
