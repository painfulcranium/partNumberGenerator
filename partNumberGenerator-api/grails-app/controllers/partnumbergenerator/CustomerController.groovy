package partnumbergenerator


import grails.rest.*
import grails.converters.*

class CustomerController extends RestfulController {
    static responseFormats = ['json']
    CustomerController() {
        super(Customer)
    }

    def index() {
        def customers = Customer.list()
        respond( customers, [view: 'customerBasic'])
    }

    @Override
    save(){
        respond null
    }

}
