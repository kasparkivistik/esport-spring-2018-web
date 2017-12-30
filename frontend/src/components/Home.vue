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
        .col-xs-6: img.img-responsive(src="../assets/sponsors/arvutitark_logo.svg")
        .col-xs-6: img.img-responsive(src="../assets/sponsors/msi-gaming.png")
        .col-xs-6: img.img-responsive(src="../assets/sponsors/itt.png")
        .col-xs-6: img.img-responsive(src="../assets/sponsors/ituk.svg")
      .row.is-flex.sponsors-sm
        .col-xs-4.col-sm-3: img(src="../assets/sponsors/noctua.jpg")
        .col-xs-4.col-sm-3: img(src="../assets/sponsors/roccat.jpg")
        .col-xs-4.col-sm-3: img(src="../assets/sponsors/balsnack.svg")
        .col-xs-4.col-sm-3: img(src="../assets/sponsors/wolt.png")
        .col-xs-4.col-sm-3: img(src="../assets/sponsors/boommedia.png")
        .col-xs-4.col-sm-3: img(src="../assets/sponsors/filmiklubi-03.svg")
        .col-xs-4.col-sm-3: img(src="../assets/sponsors/monster-02.svg")
        .col-xs-4.col-sm-3: img(src="../assets/sponsors/network_tomorrow.png")
        .col-xs-4.col-sm-3: img(src="../assets/sponsors/academic_hostel.svg")
        .col-xs-4.col-sm-3: img(src="../assets/sponsors/bytelife.png")
        .col-xs-4.col-sm-3: img(src="../assets/sponsors/exit_room.jpg")
        .col-xs-4.col-sm-3: img(src="../assets/sponsors/iveco.jpg")
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
