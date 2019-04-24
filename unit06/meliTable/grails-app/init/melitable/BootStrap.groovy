package melitable

class BootStrap {

    def init = { servletContext ->
        def mla = new Site(name: "MLA")
        mla.save()
        def cars = new Category(name: "Cars", site: mla)
        cars.save()
        new Item(title: "Autotito", price: (Double) 15, category: cars).save()
    }
    def destroy = {
    }
}
