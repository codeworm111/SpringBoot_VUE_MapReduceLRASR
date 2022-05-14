import Vue from 'vue'
import Router from 'vue-router'
import Algorithm from '../components/Algorithm'
import Upload from '../components/Upload'

Vue.use(Router)

export default new Router({
  routes: [
    {path:'/algorithm',component:Algorithm,name:'algorithm'},
    {path:'/upload',component:Upload,name:'upload'},
  ]
})
