import Vue from 'vue';
import Router from 'vue-router';
import Public from '@/components/Public';
import Home from '@/components/public/Home';
import Contact from '@/components/public/Contact';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      component: Public,
      children: [
        {
          path: '',
          name: 'Home',
          component: Home
        },
        {
          path: 'contact',
          name: 'Contact',
          component: Contact
        }
      ]
    }
  ]
});
