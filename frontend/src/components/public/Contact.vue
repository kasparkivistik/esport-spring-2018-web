<template lang="pug">
  .container
    h1.text-center Kontaktid
    .row
      .col-sm-6.col-xs-12.person
        .person-picture
          img(src="../../assets/images/lauri_kukk.jpg")
        .person-details
          h2 Lauri Kukk
          h4: em Peakorraldaja
          p: a(href="mailto:esport@ituk.ee") esport@ituk.ee
          p: a(href="tel:+37253485349") 5348 5349
      .col-sm-6.col-xs-12.person
        .person-picture
          img(src="../../assets/images/ituk_pic.jpg")
        .person-details
          h2 IT-teaduskonna üliõpilaskogu
          h4: em Korraldajad
          p: a(href="mailto:kontakt@ituk.ee") kontakt@ituk.ee
          p: a(href="https://ituk.ee") ituk.ee
    gmap-map.contact-map(:center="{lat: 59.3952914, lng: 24.6718043}", :zoom="15")
      gmap-marker(:position="{lat: 59.3952914, lng: 24.6718043}")
</template>

<script>
  export default {
    name: 'Contact',
    data () {
      return {};
    }
  };
</script>
