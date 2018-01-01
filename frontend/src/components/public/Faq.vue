<template lang="pug">
  .container
    h1.text-center(v-t="'faq.faqLong'")
    .faqs
      .faq(v-for="i in 7")
        p: strong(v-t="'faq.questions.' + i + '.q'")
        p(v-t="'faq.questions.' + i + '.a'")
</template>

<script>
  export default {
    name: 'Faq',
    data () {
      return {};
    }
  };
</script>
