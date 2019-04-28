package partnumbergenerator

import grails.gorm.transactions.Transactional

@Transactional
class PartNumberService {

    PartNumber generateCustomerPartNumberAndRevision( Customer customer ) {

        def existingPartNumber = PartNumber.findByCustomer( customer, [ sort: "internalId", order: "desc", max: 1 ] )
        PartNumber newPartNumber
        if( existingPartNumber ) {
            // Generate a new part number based on the old one
            newPartNumber = new PartNumber(
                    customer: customer,
                    internalId: existingPartNumber.internalId + 1
            ).save()
        } else {
            newPartNumber = new PartNumber(
                    customer: customer,
                    internalId: 1
            ).save()
        }
        return newPartNumber ?: null
    }
}
