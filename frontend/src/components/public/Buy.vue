<template lang="pug">
  .container
    h1.text-center(v-t="'buy.buyTicket'")
    h2.text-center {{ ticket.name }}
    form(v-on:submit.prevent="send()")
      .form-group
        label.control-label(v-t="ticket.teamSize <= 1 ? 'buy.name' : 'buy.teamName'")
        input.form-control.input-lg(v-model="ticketDetails.name" required)
      .form-group
        label.control-label(v-t="'buy.email'")
        input.form-control.input-lg(v-model="ticketDetails.ownerEmail" type="email" required)
      .form-group
        steam-login(disabled="true")
      blockquote.form-group
        p {{ $t('buy.numberOfPlayers') }}:
          span.text-primary  {{ ticket.teamSize }}
        p {{ $t('buy.pricePerPlayer') }}:
          span.text-primary  {{ ticket.cost / ticket.teamSize }}€
        p.lead {{ $t('buy.total') }}:
          span.text-primary  {{ ticket.cost }}€
      .form-group
        button.btn.btn-primary.btn-lg(type="submit" v-if="!sending")
          | {{ $t('buy.buyTicket') }}
        button.btn.btn-primary.btn-lg.disabled(type="submit" v-if="sending" disabled)
          i.fa.fa-cog.fa-spin
      .form-group
        p.text-muted(v-t="'buy.info'")
</template>

<script>
  import SteamLogin from './SteamLogin.vue';
  export default {
    name: 'Buy',
    data () {
      return {
        sending: false,
        ticket: null,
        ticketDetails: {
          name: '',
          email: ''
        }
      };
    },
    methods: {
      send: function () {
        if (!this.sending) {
          const self = this;
          this.sending = true;
          this.ticketDetails.ticket = this.ticket;
          this.$http.post(this.$config.apiBase + '/api/ticket', this.ticketDetails).then(function (res) {
            if (res.ok) {
              this.$notify({
                title: this.$t('buy.success.title'),
                text: this.$t('buy.success.text')
              });
            } else {
              this.$notify({
                title: this.$t('buy.fail.title'),
                text: this.$t('buy.fail.text')
              });
            }
            self.sending = false;
          });
        }
      }
    },
    mounted: function () {
      const self = this;
      this.$http.get(this.$config.apiBase + '/api/ticketType/' + this.$route.params.ticketId).then(function (res) {
        self.ticket = res.body;
      });
    },
    components: {
      'steam-login': SteamLogin
    }
  };
</script>
