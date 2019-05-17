const fetch = require('node-fetch');

exports.getSites = getSites();


const categoriessUrl = 'https://api.mercadolibre.com/sites/';

function getSites() {
    const sitesUrl = 'https://api.mercadolibre.com/sites';
    var data;
    fetch(sitesUrl)
    .then(response => data = response.json())
    .catch(function(error) {
        data = error.errorMessage;
    })
    return data;
}