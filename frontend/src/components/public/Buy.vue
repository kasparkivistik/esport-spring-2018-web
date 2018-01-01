<template lang="pug">
  .container
    h1.text-center(v-t="'buy.buyTicket'")
    h2.text-center {{ ticket.name }}
    form
      .form-group
        label.control-label(v-t="'buy.teamName'")
        input.form-control.input-lg
      .form-group
        label.control-label(v-t="'buy.email'")
        input.form-control.input-lg
      .form-group
        label.control-label(v-t="'buy.personalCode'")
        input.form-control.input-lg
      .form-group
        button.btn-sm.btn.btn-default.disabled
          i.fa.fa-steam
          |  {{ $t('buy.connectWithSteam') }}
      blockquote.form-group
        p {{ $t('buy.numberOfPlayers') }}:
          span.text-primary  {{ ticket.teamSize }}
        p {{ $t('buy.pricePerPlayer') }}:
          span.text-primary  {{ ticket.cost / ticket.teamSize }}€
        p.lead {{ $t('buy.total') }}:
          span.text-primary  {{ ticket.cost }}€
      .form-group
        button.btn.btn-primary.btn-lg(v-t="'buy.buyTicket'")
      .form-group
        p.text-muted(v-t="'buy.info'")
</template>

<script>
  export default {
    name: 'Buy',
    data () {
      return {
        sending: false,
        ticket: {
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
        }
      };
    }
  };
</script>
