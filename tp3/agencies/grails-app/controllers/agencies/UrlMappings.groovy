package agencies

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        post "/like"(controller: 'agencies', action: "like")
        "/search"(controller: 'agencies', action: "search")
        "/"(controller: 'agencies')
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
