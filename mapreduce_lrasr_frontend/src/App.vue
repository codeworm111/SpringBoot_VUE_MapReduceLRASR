<template>
  <div id="app">
    <el-container style="height: 100%; border: 3px solid #eee; width: 60%" >
        <el-header style="text-align: left; font-size: 20px" >
            <i class="el-icon-star-off" style="margin-right: 15px" ></i>
            <span style="font: 20px Extra large;">高光谱图像异常检测算法平台</span>
        </el-header>
        <el-container>
            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                <el-menu :default-openeds="['1', '2']"
                         background-color="#545c64"
                         text-color="#fff"
                         active-text-color="#ffd04b">
                    <el-submenu index="1">
                        <template slot="title"><i class="el-icon-message"></i>高光谱图像上传</template>
                        <el-submenu index="1-1">
                            <span slot="title" @click="redirectUrl('/upload')">上传数据</span>
                        </el-submenu>
                    </el-submenu>
                    <el-submenu index="2">
                        <template slot="title"><i class="el-icon-message"></i>异常检测算法运行</template>
                        <el-submenu index="2-1">
                            <span slot="title" @click="redirectUrl('/lRASR')">结果展示</span>
                        </el-submenu>
                    </el-submenu>
                    <el-submenu index="3">
                        <template slot="title"><i class="el-icon-message"></i>探索</template>
                        <el-submenu index="3-1">
                            <span slot="title">探索</span>
                        </el-submenu>
                    </el-submenu>
                </el-menu>
            </el-aside>


            <el-main class="my-main">
              <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
  </div>

</template>

<script>
  export default {
    name: 'app',
    data () {
      return {
        defaultActive: this.$route.name
      }
    },
    methods: {
      redirectUrl(val){
        this.$router.push(val);
      }
    }
  }
</script>

<style>
  .el-header {
      background-color: #3a8ee6;
      color: #303133;
      line-height: 60px;
  }

  .el-aside {
      color: #333;
  }

  .my-main {
    margin: 1em 1em;
  }
</style>
