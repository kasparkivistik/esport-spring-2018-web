<template lang="pug">
  .container
    h1.text-center(v-t="'navbar.timetable'")
    .times
      .day(v-for="day in $t('schedule.days')")
        h3 {{ day.title }}
        .time(v-for="(event, time) in day.times")
          p
            span.text-primary {{ time }}:&nbsp
            span.text-default {{ event }}
</template>

<script>
  export default {
    name: 'Schedule',
    data () {
      return {};
    }
  };
</script>
