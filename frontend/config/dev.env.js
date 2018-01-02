'use strict';
const merge = require('webpack-merge');
const prodEnv = require('./prod.env');

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  apiBase: '"http://localhost.e-sport.ee:8080"',
  steamLoginReturnTo: '"http://localhost.e-sport.ee:8083/static/verifySteamLogin.html"'
});
