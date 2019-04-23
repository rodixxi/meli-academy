package melitable

class Item {

    String id
    String title
    String subTitle
    Double price
    String imageUrl
    static belongsTo = [category: Category]

    static constraints = {
        price min: (Double) 0
        subTitle nullable: true
        imageUrl nullable: true
    }


    @Override
    public String toString() {
        return id + ' - ' +
                title + ' - ' +
                subTitle + ' - ' +
                price + ' - ' +
                imageUrl
    }
}
