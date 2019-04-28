package partnumbergenerator

class UrlMappings {

    static mappings = {
        group '/customer', {
            "/$customerID/partNumber"(controller: 'PartNumber', action: 'generateNewPartNumber', method: 'POST'  )
        }


        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        // Demo app, not looking to create or delete anything ;)
        //delete "/$controller/$id(.$format)?"(action:"delete")
        //post "/$controller(.$format)?"(action:"save")

        "/"(controller: 'application', action:'index', view: '/notFound')
        "500"(view: '/error')
        "404"(view: '/notFound')

    }
}
