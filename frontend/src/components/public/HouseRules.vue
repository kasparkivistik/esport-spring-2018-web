<template lang="pug">
  .container
    h1.text-center(v-t="'navbar.houseRules'")
    .house-rules
      h3 {{ $t('houseRules.notPermitted') }}:
      ul(v-for="(subrules, rule) in houseRules[0]")
        li.rule {{ rule }}
        ul(v-if="subrules != null" v-for="subrule in subrules")
          li.rule.subrule {{ subrule }}
      p {{ $t('houseRules.afterRules') }}
</template>

<script>
  export default {
    name: 'HouseRules',
    data () {
      return {};
    },
    computed: {
      houseRules: function () {
        return this.$t('houseRules.rules');
      }
    }
  };
</script>
