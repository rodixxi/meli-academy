package melitable

class Site {

    String id
    String name
    static hasMany = [categoreis: Category]

    static constraints = {
    }


    @Override
    public String toString() {
        return name
    }
}
