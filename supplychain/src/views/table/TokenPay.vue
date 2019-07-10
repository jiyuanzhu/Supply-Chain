<template>
  <div class="containWins">
    <div>
      <div
        :style="{'background':'#f2f2f2','height':'40px','padding-top':'10px','padding-bottom':'5px'}"
      >
        <h3 :style="{'color':'black'}">Token支付</h3>
      </div>
      <div :style="{'background':'white','padding-top':'70px','padding-bottom':'20px'}">
        <label>
          <div :style="{'display':'inline'}">付款方：</div>
          <el-input v-text="partA" clearable :style="{'width':'20%'}"></el-input>
        </label>
        <p style="margin-top:50px"></p>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">收款方：</div>
          <el-input v-model="partB" clearable :style="{'width':'20%'}"></el-input>
        </label>
        <p style="margin-top:50px"></p>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">支付Token金额：</div>
          <el-input v-model="tokenCost" clearable :style="{'width':'20%'}"></el-input>
        </label>
        <p style="margin-top:60px"></p>
        <el-button type="primary" round @click="tokenPayCertain">确认支付</el-button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
          partA: "",
          partB: "",
          tokenCost: ""
    };
  },
  created(){
    this.init()
  },
  methods: {
    init(){
      this.partA=this.userInfo.cname;
    },
    tokenPayCertain() {
      console.log(this.partA)
      console.log(this.partB)
      console.log(this.tokenCost)
      this.$api({
        url:"http://localhost:8088/token/pay",
        method:"post",
        data:{
          companySubName: this.partA,
          companyAddName: this.partB,
          amount: this.tokenCost
        }
      }).then((response)=>{
        console.log("token支付")
        this.tokenCost=""
        alert("支付成功")
        //console.log(response);
      })
    },
  },
};
</script>

<style>
.containWins {
  height: 715px;
}
</style>
