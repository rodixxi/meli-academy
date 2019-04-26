package grailsapi

import grails.rest.Resource

@Resource(formats = ['json', 'xml'])
class Category {

    String id
    String name
    Site site

    static mapping = {
        id generator: 'assigned'
    }

    static constraints = {
        id blank: false, nullable: false
        name blank: false, nullable: false
    }
}
