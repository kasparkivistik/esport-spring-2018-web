<template lang="pug">
  #app
    .navbar.navbar-default.navbar-static-top
      .container
        .navbar-header
          button.navbar-toggle.collapsed(type="button" data-toggle="collapse" data-target=".navbar-collapse")
            span.sr-only Toggle navigation
            span.icon-bar
            span.icon-bar
            span.icon-bar
          router-link.navbar-brand(to="/"): img.navbar-logo(src="./assets/svg/logo.long.svg")
        .collapse.navbar-collapse
          ul.nav.navbar-nav.navbar-right
            li: router-link(to="/") Avaleht
            li: router-link(to="/kontakt") Kontakt
    router-view.view
    .footer.center-content
      a.footer-link.footer-social(href="https://www.facebook.com/ttuesport/"): i.fa.fa-lg.fa-facebook
      a.footer-link.footer-social(href="https://www.instagram.com/ttuesport/"): i.fa.fa-lg.fa-instagram
      a.footer-link.footer-social(href="mailto:esport@ituk.ee"): i.fa.fa-lg.fa-envelope
      a.footer-link.footer-social(href="https://github.com/ituk-ttu/esport-spring-2018-web"): i.fa.fa-lg.fa-github
</template>

<script>
  export default {
    name: 'app'
  };
</script>
