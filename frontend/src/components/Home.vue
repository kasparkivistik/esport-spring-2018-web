<template lang="pug">
  div
    .hero
      .container
        .row
          .col-sm-6.col-xs-12.center-content
            span
              h1 9.-11. veebruar
              h1 CSGO
    .container.content-block
      h1.text-center Piletid
      .row
        .col-lg-4.col-md-6.col-xs-12
          .ticket
            .ticket-content
              h2.ticket-name Early Bird CSGO
              h3.ticket-price 15€
              p.ticket-remaining 15tk alles
              p.ticket-description Saadaval kuni 05. jaanuar
            //router-link.buy-btn(to="/") Osta
            span.buy-btn.disabled Osta
    .container.content-block
      h1.text-center Sponsorid
      .row.is-flex.sponsors
        .col-lg-6.col-sm-12: img.img-responsive(src="../assets/sponsors/arvutitark_logo.svg")
        .col-lg-6.col-sm-12: img.img-responsive(src="../assets/sponsors/msi-gaming.png")
        .col-lg-6.col-sm-12: img.img-responsive(src="../assets/sponsors/itt.png")
        .col-lg-6.col-sm-12: img.img-responsive(src="../assets/sponsors/ituk.svg")
</template>

<script>
  export default {
    name: 'Home',
    data () {
      return {
      };
    }
  };
</script>
