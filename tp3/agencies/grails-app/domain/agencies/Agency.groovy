package agencies

class Agency {

    Address address
    String agency_code
    String correspondent_id
    String description
    String disabled
    String distance
    String id
    String payment_method_id
    String phone
    String site_id
    String terminal

    static mapping = {
        id generator: 'assigned'

    }
    static constraints = {
        agency_code nullable: true
        correspondent_id nullable: true
        description nullable: true
        disabled nullable: true
        distance nullable: true
        payment_method_id nullable: true
        phone nullable: true
        site_id nullable: true
        terminal nullable: true
    }

}
