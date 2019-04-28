package partnumbergenerator

import grails.core.GrailsApplication
import grails.plugins.*

class ApplicationController implements PluginManagerAware {

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager

    def index() {
        // Removed default output for sample
        // [grailsApplication: grailsApplication, pluginManager: pluginManager, view: 'notFound']
        respond(response.status = 404, [view: 'notFound'])
    }
}
