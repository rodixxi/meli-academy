package grailsapi

class UrlMappings {

    static mappings = {

        "/"(controller: "client")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
