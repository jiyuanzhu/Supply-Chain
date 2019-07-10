<template>
  <div class="containWins">
    <div>
      <div :style="{'background':'#f2f2f2','height':'40px','padding-top':'10px','padding-bottom':'5px'}">
        <h3 :style="{'color':'black'}">送达货物</h3>
      </div>
      <div :style="{'background':'white','padding-top':'80px','padding-bottom':'20px'}">
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">订单编号：</div>
          <el-input v-model="id" clearable :style="{'width':'30%'}"></el-input>
        </label>
        <p style="margin-top:40px"></p>
        <el-button type="primary" round @click="achieveSendingCertain">确认送达</el-button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      id: ""
    };
  },
  methods: {
    achieveSendingCertain(){
      this.$api({
        url:"http://localhost:8088/trans/update",
        method:"post",
        data:{
          id: this.id,
          orderState: "1"
        }
      }).then((response) =>{
        console.log("发出货物")
        //console.log(response);
      })
    }
  },
};

</script>

<style>
.containWins {
  height: 715px;
}
</style>
