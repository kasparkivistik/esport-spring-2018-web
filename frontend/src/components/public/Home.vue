<template lang="pug">
  div
    .hero
      .container.center-content
            span
              h1: strong(v-t="'hero.date'")
              h2(v-t="'hero.game'")
              h2(v-t="'hero.teams'")
    .container.content-block
      h1.text-center(v-t="'tickets.tickets'")
      .text-center.center-content(v-if="$parent.tickets == null")
        i.fa.fa-2x.fa-cog.fa-spin
      .row.is-flex
        .col-lg-3.col-md-4.col-sm-6.col-xs-12(v-for="ticket in $parent.tickets" v-if="$parent.tickets != null")
          .ticket
            .ticket-content
              h2.ticket-name {{ $t('tickets.names["' + ticket.name + '"]') }}
              h3.ticket-price(v-if="ticket.promotions != null")
                | {{ ticket.promotions[0].cost / ticket.promotions[0].teamSize }}€
                small.text-default(v-if="ticket.promotions[0].teamSize > 1")  {{ $t('tickets.perPerson') }}
              p.ticket-description(v-if="ticket.promotions != null")
                | {{ $t('tickets.until') }}
                |  {{ ticket.promotions[0].availableUntil | moment("Do MMMM") }}
              h3.ticket-price(v-bind:class="ticket.promotions != null? 'has-promotion' : ''")
                span.text-default(v-if="ticket.promotions != null") {{ $t('tickets.regularTicket') }}&nbsp
                | {{ ticket.cost / ticket.teamSize }}€
                small.text-default(v-if="ticket.teamSize > 1 && ticket.promotions != null")
                  |  {{ $t('tickets.perPersonShort') }}
                small.text-default(v-if="ticket.teamSize > 1 && ticket.promotions == null")
                  |  {{ $t('tickets.perPerson') }}
              p.ticket-description(v-bind:class="ticket.promotions != null? 'has-promotion' : ''")
                | {{ $t('tickets.availableUntil') }}
                |  {{ ticket.availableUntil | moment("Do MMMM") }}
              // p.ticket-remaining.text-lead(v-if="ticket.amountAvailable != null")  {{ ticket.amountAvailable }}
                span(v-if="ticket.teamSize > 1")  {{ $t('tickets.teams') }}
                span(v-else)  {{ $t('tickets.pieces') }}
              p.ticket-at-location-cost(v-if="ticket.atLocationCost != null") {{ $t('tickets.atLocation') }}
                span.text-primary  {{ ticket.atLocationCost / ticket.teamSize }}€
                small.text-default(v-if="ticket.teamSize > 1")  {{ $t('tickets.perPerson') }}
            router-link.buy-btn(:to="{ name: 'Buy', params: { ticketId: ticket.promotions != null ? ticket.promotions[0].id : ticket.id } }")
              | Osta
    .container.content-block
      h1.text-center(v-t="'home.sponsors'")
      .row.is-flex.sponsors
        .col-xs-6: img.img-responsive(src="../../assets/sponsors/arvutitark_logo.svg")
        .col-xs-6: img.img-responsive(src="../../assets/sponsors/msi-gaming.png")
        .col-xs-6: img.img-responsive(src="../../assets/sponsors/itt.png")
        .col-xs-6: img.img-responsive(src="../../assets/sponsors/ituk.svg")
      .row.is-flex.sponsors-sm
        .col-xs-4.col-sm-3: img(src="../../assets/sponsors/noctua.jpg")
        .col-xs-4.col-sm-3: img(src="../../assets/sponsors/roccat.jpg")
        .col-xs-4.col-sm-3: img(src="../../assets/sponsors/balsnack.svg")
        .col-xs-4.col-sm-3: img(src="../../assets/sponsors/wolt.png")
        .col-xs-4.col-sm-3: img(src="../../assets/sponsors/boommedia.png")
        .col-xs-4.col-sm-3: img(src="../../assets/sponsors/filmiklubi-03.svg")
        .col-xs-4.col-sm-3: img(src="../../assets/sponsors/monster-02.svg")
        .col-xs-4.col-sm-3: img(src="../../assets/sponsors/network_tomorrow.png")
        .col-xs-4.col-sm-3: img(src="../../assets/sponsors/academic_hostel.svg")
        .col-xs-4.col-sm-3: img(src="../../assets/sponsors/bytelife.png")
        .col-xs-4.col-sm-3: img(src="../../assets/sponsors/exit_room.jpg")
        .col-xs-4.col-sm-3: img(src="../../assets/sponsors/iveco.jpg")
        .col-xs-4.col-sm-3: img(src="../../assets/sponsors/ye.jpg")
</template>

<script>
  export default {
    name: 'Home',
    props: ['tickets']
  };
</script>
