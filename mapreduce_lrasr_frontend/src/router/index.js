import Vue from 'vue'
import Router from 'vue-router'
import LRASR from '../components/LRASR'
import Upload from '../components/Upload'

Vue.use(Router)

export default new Router({
  routes: [
    {path:'/lRASR',component:LRASR,name:'lRASR'},
    {path:'/upload',component:Upload,name:'upload'},
  ]
})
