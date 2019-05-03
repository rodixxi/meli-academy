package agencies

import grails.gorm.transactions.Transactional
import groovy.json.JsonSlurper

@Transactional
class AgenciesService {

    def agenciesServiceUrl = "http://localhost:8088/agencias/MLA/rapipago?"

    Object call(String near_to, String limit, String offset) {
        def url = new URL(agenciesServiceUrl + "near_to=${near_to}&limit=${limit}&offset=${offset}")
        def connection = (HttpURLConnection) url.openConnection()
        connection.setRequestMethod('GET')
        connection.setRequestProperty('Accept', 'application/json')
        connection.setRequestProperty('User-Agent', 'Mozilla/5.0')
        JsonSlurper json = new JsonSlurper()
        def result = json.parse(connection.getInputStream())
        return result.data
    }
}
