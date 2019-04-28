package partnumbergenerator

import grails.testing.gorm.DomainUnitTest
import org.springframework.test.annotation.Rollback
import spock.lang.Specification

@Rollback
class CustomerSpec extends Specification implements DomainUnitTest<Customer> {

    Customer customer
    PartNumber partNumber

    def setup() {
        customer = new Customer( name: 'customer1', internalId: 500).save(flush: true)
        mockDomain PartNumber
        partNumber = new PartNumber( internalId: 888, revision: 88, customer: customer).save(flush: true)
    }

    def cleanup() {
    }

    void "number of test customers"() {
        expect: Customer.count() == 1
    }

    void "check customer name"() {
        expect: assert customer.name == 'customer1'
    }

    void "check total part numbers for customer"() {
        expect: assert customer.getPartNumbers().size() == 1
    }

    void "check part number info"() {
        when:
            def partNumbers = customer.getPartNumbers()
        then:
            assert partNumbers && partNumbers[0].revision == 88
    }

}
