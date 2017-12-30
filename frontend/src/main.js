// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import App from './App';
import router from './router';

import * as VueGoogleMaps from 'vue2-google-maps';

import './assets/less/style.less';
const $ = require('jquery');
window.jQuery = $;
require('bootstrap-less/js/bootstrap');

Vue.config.productionTip = false;
Vue.use(VueGoogleMaps, {
  load: {
    key: 'AIzaSyAuldH1cG6aVHzWpmxdGAIiHvaBXzZAqPc'
  }
});
const moment = require('moment');
require('moment/locale/et');
Vue.use(require('vue-moment'), {
  moment
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: {App}
});
