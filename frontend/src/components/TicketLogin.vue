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
      console.log(this.$route.params.loginKey);
    }
  };
</script>
