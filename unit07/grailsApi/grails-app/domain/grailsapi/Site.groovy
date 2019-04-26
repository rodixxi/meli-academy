package grailsapi

import grails.rest.Resource

@Resource(formats = ['json', 'xml'])
class Site {

    String id
    String name

    static mapping = {
        id generator: 'assigned'
    }

    static constraints = {
        id blank: false, nullable: false
        name blank: false, nullable: false
    }
}
