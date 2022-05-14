import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import global from './Global'
import axios from 'axios'
import VueAxios from 'vue-axios'
import * as echarts from 'echarts'

Vue.config.productionTip = false
Vue.prototype.global = global;

Vue.use(ElementUI);
Vue.use(VueAxios,axios);
Vue.prototype.$echarts = echarts

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
