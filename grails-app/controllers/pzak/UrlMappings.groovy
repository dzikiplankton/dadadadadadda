package pzak

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index1")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
