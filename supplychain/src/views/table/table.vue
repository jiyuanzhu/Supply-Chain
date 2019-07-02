<template>
  <div>
      
      <div class="panel panel-primary"><!-- panel窗体控件 -->
              <div class="panel-heading">
                    <h3 class="panel-title">合同列表</h3>
              </div>
                <div class="panel-body form-inline"><!-- form-inline 元素都在一行 -->
                    <div :style="{'font-size':'30px','font-weight':'20'} ">合同关键字搜索</div>
                    <label>
                        Id：
                        <input type="text" v-model="idKey" class="form-control">
                    </label>
                    <label>
                        合同名称：
                        <input type="text" v-model="nameKey" class="form-control">
                    </label>
                    <label>
                        甲方：
                        <input type="text" v-model="partAKey" class="form-control">
                    </label>
                    <label>
                        乙方：
                        <input type="text" v-model="partBKey" class="form-control">
                    </label>
                    <label>
                        添加时间：
                        <input type="text" v-model="ctimeKey" class="form-control">
                    </label>

                    <div :style="{'font-size':'30px','font-weight':'20'} ">合同添加</div>
                    <label>
                        Id:
                        <input type="text" v-model="id" class="form-control">
                    </label>
                    <label>
                        合同名称:
                        <input type="text" v-model="name" class="form-control">
                    </label>
                    <label>
                        甲方:
                        <input type="text" v-model="partA" class="form-control">
                    </label>
                    <label>
                        乙方:
                        <input type="text" v-model="partB" class="form-control">
                    </label>
                    <input type="button" value="添加" class="btn  btn-primary" @click="add()">
                    <!-- 事件绑定机制，加()可给事件传参 -->
              </div>
        </div>
      

      <table class="table table-bordered table-hover table-striped">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>合同名称</th>
                    <th>甲方</th>
                    <th>乙方</th>
                    <th>签署时间</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="item in search(idKey,nameKey,partAKey,partBKey,ctimeKey)" :key="item.id">
                    <td v-for="(val, key, i) in item" :key="i">
                        {{val}}
                    </td>
                    <td>
                        <a href="" @click.prevent="del(item.id)">删除</a>
                    </td>
                </tr>
            </tbody>
        </table>    
  </div>
</template>

<script>
export default {
  name: 'App',
  data(){return{
      list:[{id:'1',name:"四方精创合同",partA:"老师", partB:"学生", ctime:new Date().toString()},
            {id:'2',name:"四方精创作业合同",partA:"学生", partB:"老师", ctime:new Date().toString()}
      ],
      id: '',
      name: '',
      partA: '',
      partB: '',
      ctime: '',
      idKey: '',
      nameKey: '',
      partAKey: '',
      partBKey: '',
      ctimeKey: ''
  }},
  methods:{
      add(){
          this.ctime=new Date()
          var agreement={id:this.id, name:this.name, partA:this.partA, partB:this.partB, ctime:this.ctime.toString()}
          this.list.push(agreement)
      },
      del(id){
          var index=this.list.findIndex(item =>{
              if(item.id==id) return true
          })
          this.list.splice(index,1)
      },
      search(idKey,nameKey,partAKey,partBKey,ctimeKey){
          var newlist=[]
          this.list.forEach(item =>{
              if((item.id.indexOf(idKey)!=-1)&&(item.name.indexOf(nameKey)!=-1)
              &&(item.partA.indexOf(partAKey)!=-1)&&(item.partB.indexOf(partBKey)!=-1)
              &&(item.ctime.indexOf(ctimeKey)!=-1))
              newlist.push(item)
          })
          return newlist
      }
  }
}

</script>

<style>
    .table th, .table td{
        text-align: center;
        vertical-align: middle!important;
    }
</style>