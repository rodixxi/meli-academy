package melitable

class Category {

    String id
    String name
    static hasMany = [items: Item]
    static belongsTo = [site: Site]

    static constraints = {
    }


    @Override
    public String toString() {
        return name
    }
}
