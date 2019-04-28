package partnumbergenerator


class Customer extends BaseDomain {

    static hasMany = [ partNumbers: PartNumber ]

    String name
    Integer internalId
    Collection<PartNumber> partNumbers

    static constraints = {
        name( maxSize: 255 )
        internalId( min: 100, max: 999 )
    }

    def getPartNumbers(){
        this.partNumbers = PartNumber.findAllByCustomer( this )
        return this.partNumbers
    }

}
