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
            li: router-link(:to="{ name: 'Home' }") {{ $t('navbar.home') }}
            li: router-link(:to="{ name: 'Contact' }") {{ $t('navbar.contact') }}
            li: router-link(:to="{ name: 'Faq' }") {{ $t('navbar.faq') }}
            li: a(href="https://discord.gg/W5Psxu3" target="_blank") Discord
            li: a(href="#", v-on:click.stop.prevent="setLanguage('en')" v-if="getLanguage != 'en'"): strong EN
            li: a(href="#", v-on:click.stop.prevent="setLanguage('et')" v-if="getLanguage != 'et'"): strong ET
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
      },
      showSteamLoggedIn: function () {
        this.$notify({
          title: this.$t('login.steam.title'),
          text: this.$t('login.steam.text'),
          classes: 'black'
        });
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
    },
    data () {
      return {
        tickets: null
      };
    },
    mounted: function () {
      const self = this;
      this.$http.get(this.$config.apiBase + '/api/ticketTypes').then(function (res) {
        self.tickets = res.body;
      });
    }
  };
</script>
