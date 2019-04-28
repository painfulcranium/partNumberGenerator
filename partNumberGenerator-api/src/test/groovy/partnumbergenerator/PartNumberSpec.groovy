package partnumbergenerator

import grails.testing.gorm.DomainUnitTest
import grails.testing.mixin.integration.Integration
import org.springframework.test.annotation.Rollback
import spock.lang.Specification

@Rollback
class PartNumberSpec extends Specification implements DomainUnitTest<PartNumber> {

    Customer customer
    PartNumber partNumber

    def setup() {
        customer = new Customer( name: 'test1', internalId: 600).save()
        partNumber = new PartNumber( internalId: 99, revision: 99, customer: customer ).save()
    }

    def cleanup() {
    }

    void "test number of part numbers"() {
        expect: PartNumber.count() == 1
    }

    void "test customer relation"() {
        expect: PartNumber.findAllByCustomer( customer ).size() == 1
    }

    void "test ean13 length on first item"() {
        when:
            def partNumbers = PartNumber.findAllByCustomer( customer )
        then:
            partNumbers && partNumbers[0].calculateEAN13WithCheckSum().length() == 11
    }

}
