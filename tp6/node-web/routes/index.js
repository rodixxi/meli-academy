var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index');
});

router.get('/trends', function(req, res, next) {
  res.render('trends');
});

module.exports = router;
