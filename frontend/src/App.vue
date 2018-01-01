<template lang="pug">
  #app
    router-view
    notifications(position="bottom left" classes="notification")
</template>

<script>
  export default {
    name: 'app'
  };
</script>
