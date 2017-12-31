<template lang="pug">
  #public
    .navbar.navbar-default.navbar-static-top
      .container
        .navbar-header
          button.navbar-toggle.collapsed(type="button" data-toggle="collapse" data-target=".navbar-collapse")
            span.sr-only Toggle navigation
            span.icon-bar
            span.icon-bar
            span.icon-bar
          router-link.navbar-brand(to="/"): img.navbar-logo(src="../assets/svg/logo.long.svg")
        .collapse.navbar-collapse
          ul.nav.navbar-nav.navbar-right
            li: router-link(to="/") {{ $t('navbar.home') }}
            li: router-link(to="contact") {{ $t('navbar.contact') }}
            li: a(href="#", v-on:click.stop.prevent="setLanguage('en')" v-if="getLanguage != 'en'") ENG
            li: a(href="#", v-on:click.stop.prevent="setLanguage('et')" v-if="getLanguage != 'et'") EST
    router-view.view
    .footer.center-content
      a.footer-link.footer-social(href="https://www.facebook.com/ttuesport/"): i.fa.fa-lg.fa-facebook
      a.footer-link.footer-social(href="https://www.instagram.com/ttuesport/"): i.fa.fa-lg.fa-instagram
      a.footer-link.footer-social(href="mailto:esport@ituk.ee"): i.fa.fa-lg.fa-envelope
      a.footer-link.footer-social(href="https://github.com/ituk-ttu/esport-spring-2018-web"): i.fa.fa-lg.fa-github
</template>

<script>
  export default {
    name: 'public',
    methods: {
      setLanguage: function (language) {
        this.$root.$i18n.locale = language;
        this.$moment.locale(this.$root.$i18n.t('moment'));
        this.$root.$localStorage.set('language', language);
      }
    },
    computed: {
      getLanguage: function () {
        return this.$root.$i18n.locale;
      }
    },
    created () {
      this.$root.$i18n.locale = this.$root.$localStorage.get('language', 'et');
      this.$moment.locale(this.$root.$i18n.t('moment'));
    }
  };
</script>
