<template lang="pug">
  .container
    h1.text-center(v-t="'tickets.tickets'")
    table.table.table-bordered.table-striped
      thead
        tr
          th(v-t="'tickets.id'")
          th(v-t="'tickets.name'")
          th(v-t="'tickets.status'")
          th(v-t="'tickets.boughtOnDate'")
          th(v-t="'tickets.price'")
      tbody
        tr(v-for="ticket in tickets")
          td {{ticket.id}}
          td {{ticket.type.name}}
          td {{ticket.status}}
          td {{ticket.dateCreated | moment("Do MMMM") }}
          td {{ticket.type.cost}} €

</template>

<script>
  export default {
    name: 'MyTickets',
    data () {
      return {
        tickets: null
      };
    },
    mounted: function () {
      const self = this;
      this.$http.get(this.$config.apiBase + '/api/tickets').then(result => {
        self.tickets = result.body;
      });
    }
  };
</script>
