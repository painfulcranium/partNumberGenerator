package partnumbergenerator


import grails.rest.*
import grails.converters.*

class PartNumberController extends RestfulController {

    static responseFormats = ['json']

    PartNumberController() {
        super(PartNumber)
    }

    PartNumberService partNumberService

    def index() {
        def customerId = params?.customerID
        List<PartNumber> partNumbers

        if( !customerId ) {
            render params
        } else {
            Customer customer = Customer.findById(customerId as Long)
            if( customer ){
                partNumbers = PartNumber.findAllByCustomer( customer )
                respond( partNumbers, [view: partNumbers ? 'partNumber' : 'notFound'] )
            } else {
                response.status = 404
            }

        }
    }

    def generateNewPartNumber() {

        def customerId = params?.customerID

        if( !customerId ) {
            render params
        } else {
            Customer customer = Customer.findById(customerId as Long)
            if( customer ){
               PartNumber partNumber = partNumberService.generateCustomerPartNumberAndRevision( customer )
               partNumber ? respond(partNumber, [view: 'partNumber']) : respond(response.status = 404)
            } else {
                response.status = 404
            }

        }

    }

    @Override
    save(){
        respond null
    }
}
