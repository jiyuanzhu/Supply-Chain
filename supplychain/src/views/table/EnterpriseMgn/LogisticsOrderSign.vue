<template>
  <div class="containWins">
    <div>
      <div
        :style="{'background':'#f2f2f2','height':'40px','padding-top':'10px','padding-bottom':'5px'}"
      >
        <h3 :style="{'color':'black'}">确认订单</h3>
      </div>
      <div :style="{'background':'white','padding-top':'70px','padding-bottom':'20px'}">
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">物流公司：</div>
          <el-input v-model="name" clearable :style="{'width':'30%'}"></el-input>
        </label>
        <p style="margin-top:50px"></p>
        <label>
          <div :style="{'display':'inline'}">寄货方：</div>
          <el-input v-model="partA" clearable :style="{'width':'20%'}"></el-input>
        </label>
        <p style="margin-top:50px"></p>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">收货方：</div>
          <el-input v-model="partB" clearable :style="{'width':'20%'}"></el-input>
        </label>
        <p style="margin-top:50px"></p>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">运输物品：</div>
          <el-input v-model="goods" clearable :style="{'width':'20%'}"></el-input>
        </label>
        <p style="margin-top:50px"></p>
        <label :style="{'display':'inline'}">
          <div :style="{'display':'inline'}">Token费用：</div>
          <el-input v-model="tokenCost" clearable :style="{'width':'20%'}"></el-input>
        </label>
        <p style="margin-top:60px"></p>
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
    addLogistics() {
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
        name: this.name,
        partA: this.partA,
        partB: this.partB,
        ctime: this.ctime,
        orderState: "待发货",
        goods: this.goods,
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
