<template lang="pug">
  .center-content
    i.fa.fa-gear.fa-spin.fa-2x
</template>

<script>
  export default {
    name: 'TicketLogin',
    data () {
      return {};
    },
    mounted: function () {
      const self = this;
      self.$http.get(self.$config.apiBase + '/api/ticket/token/' + this.$route.params.loginKey).then(() => {
        self.$router.push({ name: 'MyTickets' });
      });
    }
  };
</script>
