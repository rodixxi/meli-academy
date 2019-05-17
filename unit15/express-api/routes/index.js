var express = require('express');
var router = express.Router();
var scrips = require('../public/javascripts/scrips')

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

router.get('/sites', function(req, res, next) {
  data = scrips.getSites;
  res.render('card', { data: data });
});

module.exports = router;
