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
          router-link.navbar-brand(to="/") TTÜ e-Sport
        .collapse.navbar-collapse
          ul.nav.navbar-nav
            li: router-link(to="/") Avaleht
    router-view
</template>

<script>
  export default {
    name: 'app'
  };
</script>
