<template>
  <div>
    <p>请输入算法名：<el-input style="width:30%" v-model="method" placeholder="算法名"></el-input></p>
    <p>请输入并行度：<el-input style="width:30%" v-model="parallelism" placeholder="并行度"></el-input>     <el-button type="danger"  style="margin-left:15% "  @click="runMethodBtn()">执行算法</el-button></p>
    <p>请输入任务名：<el-input style="width:30%" v-model="jobname" placeholder="任务名"></el-input></p>
    <br/>
    <br/>
    <div class="Echarts">
    <div id="main" style="width: 700px;height:400px;"></div>
    </div>
    <p style="margin-left: 15%; font-size: large;"><el-tag type="success">最终AUC为：</el-tag>{{auc}}</p>
    <p style="margin-left: 15%; font-size: large;"><el-tag type="danger">运行时间(s)为：</el-tag>{{time}}</p>
  </div>

</template>

<script>
    export default {
    name: 'Algorithm',
    data () {
      return {
        method:"",
        parallelism:"",
        jobname:"",
        stopCArray:[],
        stopCIndex:[],
        auc:"",
        time:""
      }
    },
    methods:{
      runMethodBtn(){
        this.axios({
          method:'get',
          url:'http://192.168.2.47:8888/run/?method='+this.method+'&parallelism='+this.parallelism+"&jobname="+this.jobname,
		      timeout:120*60*1000
        })
          .then(res=>{
            this.stopCArray=res.data.stopC
            this.auc=res.data.auc
            this.time=res.data.time
            for (var i=1;i<=this.stopCArray.length;i++){
              this.stopCIndex[i-1]=i;
            }
            this.myEchartsInit();
          }
        )
      },

      myEchartsInit(){
        // 2.基于准备好的dom，初始化echarts实例
        var myChart = this.$echarts.init(document.getElementById('main'));

          //3.配置数据
        let showLable = true;
        var option = {
          title: {
            text: 'stopC 迭代过程'
          },
          tooltip: {},
          legend: {
            data:['stopC']
          },
          xAxis: {
            type: 'category',
            name:'迭代轮数',
            data: this.stopCIndex
          },
          yAxis: { 
            type: 'value',
            name: '迭代损失' }, //Y轴
          series: [{
            name: 'stopC',
            type: 'bar',
            data: this.stopCArray
          }],
          dataZoom: [{
            type: "slider",
            show: true,
            xAxisIndex: [0],
            start: 0,
            end: 100,
            textStyle:{color:"#ccd7d7"}
          }]
        };

          // 4.传入数据
        myChart.setOption(option);
      }
    },
    mounted() {
  	  this.myEchartsInit();
    }
  }
</script>

<style scoped>

</style>