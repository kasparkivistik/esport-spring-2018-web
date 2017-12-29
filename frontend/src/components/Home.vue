<template lang="pug">
  .container
    .h1 {{ msg }}
</template>

<script>
  export default {
    name: 'Home',
    data () {
      return {
        msg: 'Hello!'
      };
    }
  };
</script>
