package partnumbergenerator

import grails.boot.GrailsApp
import grails.core.GrailsApplication
import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import org.springframework.test.annotation.Rollback
import spock.lang.Specification

@Rollback
class PartNumberServiceSpec extends Specification implements ServiceUnitTest<PartNumberService>, DataTest {

    Customer customer
    PartNumber partNumber
    PartNumber partNumberFromService

    def setup() {
        mockDomain Customer
        customer = new Customer( name: 'test1', internalId: 600).save()

        mockDomain PartNumber
        partNumber = new PartNumber( internalId: 99, revision: 99, customer: customer ).save()
        partNumberFromService = service.generateCustomerPartNumberAndRevision( customer )
    }

    def cleanup() {
    }

    void "test number of part numbers"() {
        expect: PartNumber.count() == 2
    }

    void "test customer relation"() {
        expect: PartNumber.findAllByCustomer( customer ).size() == 2
    }




}
