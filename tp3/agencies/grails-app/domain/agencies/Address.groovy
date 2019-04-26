package agencies

class Address {

    String address_line
    String city
    String country
    String location
    String other_info
    String state
    String zip_code

    static constraints = {
        address_line nullable: true
        city nullable: true
        country nullable: true
        location nullable: true
        other_info nullable: true
        state nullable: true
        zip_code nullable: true
    }
}
