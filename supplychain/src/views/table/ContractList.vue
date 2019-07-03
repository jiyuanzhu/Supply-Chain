<template>
  <div>
    <div>
      <div id="表格部分" class="tablewin" @click.capture.once="list=tableData">
        <!-- panel窗体控件 -->
        <div>
          <div :style="{'background':'#337ab7','height':'30px'}">
            <h3 :style="{'color':'white'}">合同列表</h3>
          </div>
          <div :style="{'background':'white'}">
            <p :style="{'background':'white'}"></p>
            <label :style="{'display':'inline'}">
              <div :style="{'display':'inline'}">Id：</div>
              <el-input
                v-model="idKey"
                clearable
                :style="{'width':'30%'}"
                @change="search(idKey,nameKey,partAKey,partBKey,ctimeKey)"
              ></el-input>
            </label>
            <label :style="{'display':'inline'}">
              <div :style="{'display':'inline'}">合同名称：</div>
              <el-input v-model="nameKey" clearable :style="{'width':'30%'}"></el-input>
            </label>
            <p></p>
            <label :style="{'display':'inline'}">
              <div :style="{'display':'inline'}">甲方：</div>
              <el-input v-model="partAKey" clearable :style="{'width':'30%'}"></el-input>
            </label>
            <label :style="{'display':'inline'}">
              <div :style="{'display':'inline'}">乙方：</div>
              <el-input v-model="partBKey" clearable :style="{'width':'30%'}"></el-input>
            </label>
            <p></p>
            <label :style="{'display':'inline'}">
              <div :style="{'display':'inline'}">添加时间：</div>
              <el-input v-model="ctimeKey" clearable :style="{'width':'30%'}"></el-input>
            </label>
          </div>
        </div>
        <el-table :data="tableData" height="495" border style="width: 100%">
          <el-table-column prop="id" label="Id" width="50"></el-table-column>
          <el-table-column prop="name" label="合同名称" width="160"></el-table-column>
          <el-table-column prop="partA" label="甲方" width="160"></el-table-column>
          <el-table-column prop="partB" label="乙方" width="160"></el-table-column>
          <el-table-column prop="ctime" label="签署时间"></el-table-column>
        </el-table>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "App",
    data() {
      return {
        tableData: [
          {
            id: "1",
            name: "四方精创合同",
            partA: "老师",
            partB: "学生",
            ctime: new Date().toString()
          },
          {
            id: "2",
            name: "四方精创作业合同",
            partA: "学生",
            partB: "老师",
            ctime: new Date().toString()
          },
          {
            id: "3",
            name: "四方精创作业合同",
            partA: "学生",
            partB: "老师",
            ctime: new Date().toString()
          },
          {
            id: "4",
            name: "四方精创作业合同",
            partA: "学生",
            partB: "老师",
            ctime: new Date().toString()
          },
          {
            id: "5",
            name: "四方精创作业合同",
            partA: "学生",
            partB: "老师",
            ctime: new Date().toString()
          },
          {
            id: "6",
            name: "四方精创作业合同",
            partA: "学生",
            partB: "老师",
            ctime: new Date().toString()
          },
          {
            id: "7",
            name: "四方精创作业合同",
            partA: "学生",
            partB: "老师",
            ctime: new Date().toString()
          },
          {
            id: "8",
            name: "四方精创作业合同",
            partA: "学生",
            partB: "老师",
            ctime: new Date().toString()
          }
          // {
          //   id: "9",
          //   name: "四方精创作业合同",
          //   partA: "学生",
          //   partB: "老师",
          //   ctime: new Date().toString()
          // },
          // {
          //   id: "10",
          //   name: "四方精创作业合同",
          //   partA: "学生",
          //   partB: "老师",
          //   ctime: new Date().toString()
          // },
          // {
          //   id: "11",
          //   name: "四方精创作业合同",
          //   partA: "学生",
          //   partB: "老师",
          //   ctime: new Date().toString()
          // }
        ],
        list:[],
        id: "",
        name: "",
        partA: "",
        partB: "",
        ctime: "",
        idKey: "",
        nameKey: "",
        partAKey: "",
        partBKey: "",
        ctimeKey: "",
        numPage: 20,
        nowPage: 1
      };
    },
    methods: {
      // add() {
      //   this.ctime = new Date();
      //   var agreement = {
      //     id: this.id,
      //     name: this.name,
      //     partA: this.partA,
      //     partB: this.partB,
      //     ctime: this.ctime.toString()
      //   };
      //   this.list.push(agreement);
      // },
      // del(id) {
      //   var index = this.list.findIndex(item => {
      //     if (item.id == id) return true;
      //   });
      //   this.list.splice(index, 1);
      // },
      // ab(){
      //   window.onload =function(){
      //   console.log('11')
      //   }
      // },
      search(idKey, nameKey, partAKey, partBKey, ctimeKey) {
        this.tableData = [];
        this.list.forEach(item => {
          if (
            item.id.indexOf(idKey) != -1 &&
            item.name.indexOf(nameKey) != -1 &&
            item.partA.indexOf(partAKey) != -1 &&
            item.partB.indexOf(partBKey) != -1 &&
            item.ctime.indexOf(ctimeKey) != -1
          )
            this.tableData.push(item);
        });
        console.log('111')
      }
    }
  };
</script>

<style>
  .table th,
  .table td {
    text-align: center;
    vertical-align: middle !important;
  }

  .tablewin {
    background-color: rgb(196, 118, 16);
  }

</style>

<style scoped>
  .searchInput >>> .el-textarea__inner {
    font-family: "Microsoft" !important;
    font-size: 50px !important;
  }
</style>
