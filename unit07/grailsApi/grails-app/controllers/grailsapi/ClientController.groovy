package grailsapi

import groovy.json.JsonSlurper

class ClientController {

    def index() {
        def url = "https://api.mercadolibre.com/sites"
        [result: callUrl(url)]
    }

    def get_category() {
        url = "https://api.mercadolibre.com/sites/$params.id/categories"
        [category: callUrl(url)]
    }

    Object callUrl(String urlString) {
        def url = new URL(urlString)
        def connection = (HttpURLConnection) url.openConnection()
        connection.setRequestMethod('GET')
        connection.setRequestProperty('Accept', 'application/json')
        connection.setRequestProperty('User-Agent', 'Mozilla/5.0')
        JsonSlurper json = new JsonSlurper()
        def result = json.parse(connection.getInputStream())
        result.sort {a,b -> a.name <=> b.name}
        return result
    }
}
