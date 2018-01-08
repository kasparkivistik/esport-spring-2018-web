// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import router from './router';
import VueResource from 'vue-resource';
import VueConfig from 'vue-config';

import Vuex from 'vuex';
import * as VueGoogleMaps from 'vue2-google-maps';
import i18n from './language';
import App from './App';
import VueLocalStorage from 'vue-localstorage';
import VueAnalytics from 'vue-analytics';
import Notifications from 'vue-notification';

import './assets/less/style.less';
const $ = require('jquery');

window.jQuery = $;
require('bootstrap-less/js/bootstrap');

Vue.use(VueLocalStorage);
Vue.use(Vuex);
Vue.config.productionTip = false;
Vue.use(VueGoogleMaps, {
  load: {
    key: 'AIzaSyAuldH1cG6aVHzWpmxdGAIiHvaBXzZAqPc'
  }
});

const moment = require('moment');
require('moment/locale/et');
require('moment/locale/en-gb');
Vue.use(require('vue-moment'), {
  moment
});

Vue.use(VueAnalytics, {
  id: 'UA-111484189-1',
  router
});

Vue.use(Notifications);

Vue.use(VueConfig, {
  apiBase: process.env.apiBase,
  steamLoginReturnTo: process.env.steamLoginReturnTo
});

Vue.use(VueResource);

const AUTHORIZATION_HEADER = 'Authorization';
const AUTH_TOKEN = 'authToken';
Vue.http.interceptors.push((request, next) => {
  let authToken = localStorage.getItem(AUTH_TOKEN);
  if (authToken) {
    request.headers.set(AUTHORIZATION_HEADER, authToken);
  }
  request.headers.set('Accept', 'application/json');
  next(result => {
    let authToken = result.headers.get(AUTHORIZATION_HEADER);
    if (authToken) {
      localStorage.setItem(AUTH_TOKEN, authToken);
    }
  });
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  i18n,
  router,
  template: '<App/>',
  components: {App},
  methods: {}
});
