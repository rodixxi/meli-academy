package grailsapi

import grails.rest.Resource

@Resource(formats = ['json', 'xml'])
class Item {

    Category category
    String name
    double price

    static constraints = {
        name blank: false, nullable: false
        price max: 1000d, min: 1d
    }
}
