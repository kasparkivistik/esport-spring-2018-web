<template lang="pug">
  div
    .hero
      .container.center-content
            span
              h1: strong 9.-11. veebruar
              h2 CSGO
              h2 32 meeskonda
              h1 Piletid varsti saadaval!
    .container.content-block
      h1.text-center Piletid
      .row.is-flex
        .col-lg-3.col-md-4.col-sm-6.col-xs-12(v-for="ticket in tickets")
          .ticket
            .ticket-content
              h2.ticket-name {{ ticket.name }}
              h3.ticket-price(v-if="ticket.promotions != null")
                | {{ ticket.promotions[0].cost / ticket.promotions[0].teamSize }}€
                small.text-default(v-if="ticket.promotions[0].teamSize > 1")  /inimene
              p.ticket-description(v-if="ticket.promotions != null")
                | kuni {{ [ticket.promotions[0].availableUntil, 'YYYY-MM-DD:THH:mm:ssZ'] | moment("Do MMMM") }}
              h3.ticket-price(v-bind:class="ticket.promotions != null? 'has-promotion' : ''")
                span.text-default(v-if="ticket.promotions != null") Tavapilet&nbsp
                | {{ ticket.cost / ticket.teamSize }}€
                small.text-default(v-if="ticket.teamSize > 1 && ticket.promotions != null")  /in
                small.text-default(v-if="ticket.teamSize > 1 && ticket.promotions == null")  /inimene
              p.ticket-description(v-bind:class="ticket.promotions != null? 'has-promotion' : ''")
                | saadaval kuni {{ [ticket.availableUntil, 'YYYY-MM-DD:THH:mm:ssZ'] | moment("Do MMMM") }}
              p.ticket-remaining.text-lead(v-if="ticket.amountAvailable != null") alles {{ ticket.amountAvailable }}
                span(v-if="ticket.teamSize > 1")  tiimile
                span(v-else)  tk
              p.ticket-at-location-cost(v-if="ticket.atLocationCost != null") Kohapealt ostes
                span.text-primary  {{ ticket.atLocationCost / ticket.teamSize }}€
                small.text-default(v-if="ticket.teamSize > 1")  /inimene
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
        .col-xs-4.col-sm-3: img(src="../assets/sponsors/ye.jpg")
</template>

<script>
  export default {
    name: 'Home',
    data () {
      return {
        tickets: [
          {
            name: 'CS:GO meeskond',
            amountAvailable: 32,
            cost: 100,
            atLocationCost: 200,
            teamSize: 5,
            availableUntil: '2018-02-03:T00:00:00+02:00',
            promotions: [
              {
                name: 'Early bird',
                amountAvailable: 32,
                cost: 75,
                teamSize: 5,
                availableUntil: '2018-01-15:T00:00:00+02:00'
              }
            ]
          },
          {
            name: 'CS:GO VIP meeskond',
            amountAvailable: 2,
            cost: 150,
            teamSize: 5,
            availableUntil: '2018-02-03:T00:00:00+02:00'
          },
          {
            name: 'Tavamängija',
            amountAvailable: 20,
            cost: 15,
            atLocationCost: 25,
            teamSize: 1,
            availableUntil: '2018-02-03:T00:00:00+02:00',
            promotions: [
              {
                name: 'Early bird',
                amountAvailable: 20,
                cost: 10,
                teamSize: 1,
                availableUntil: '2018-01-15:T00:00:00+02:00'
              }
            ]
          },
          {
            name: 'Pealtvaataja',
            amountAvailable: null,
            cost: 5,
            atLocationCost: 8,
            teamSize: 1,
            availableUntil: '2018-02-03:T00:00:00+02:00'
          }
        ]
      };
    }
  };
</script>
