package grailsapi

class BootStrap {

    def init = { servletContext ->

        def s1 = new Site(id: 'MLA' , name: "Argentina").save()

        def c1 = new Category(id: "MLA5725", name: "Accesorios para Vehículos").save()
        def c2 = new Category(id: "MLA1403", name: "Alimentos y Bebidas").save()
        def c3 = new Category(id: "MLA1071", name: "Animales y Mascotas").save()

        new Item(name: "Item1", price: 10, category: c1).save()
        new Item(name: "Item2", price: 20, category: c1).save()
        new Item(name: "Item3", price: 30, category: c1).save()
        new Item(name: "Item4", price: 40, category: c2).save()
    }

    def destroy = {
    }
}
