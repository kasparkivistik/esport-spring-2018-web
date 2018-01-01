import Vue from 'vue';
import VueI18n from 'vue-i18n';

Vue.use(VueI18n);

const i18n = new VueI18n({
  locale: 'et',
  fallbackLocale: 'et',
  messages: {
    'et': require('./assets/languages/et.json'),
    'en': require('./assets/languages/en.json')
  }
});

if (module.hot) {
  module.hot.accept(['./assets/languages/et.json', './assets/languages/en.json'], () => {
    i18n.setLocaleMessage('et', require('./assets/languages/et.json'));
    i18n.setLocaleMessage('en', require('./assets/languages/en.json'));
    console.log('hot reload', this, arguments);
  });
}

export default i18n;
