package partnumbergenerator

class PartNumber extends BaseDomain {

    // static belongsTo = [ customer: Customer ]

    Integer internalId
    Integer revision = 1
    Customer customer

    static constraints = {
        internalId max: 99999
        revision max: 99
    }

    /**
     *
     * @return generated ean-13 part number format based on internal database values, as a string
     */
    def calculateEAN13WithCheckSum() {

        /*
                This is used to produce an ean-13 formatted output based on part number stored internally
                in original "raw" value. This way, we could display any format desired based on how to calculate
                from the raw data

                Generate the checksum bit by multiplying by the proper number in position - up to 12:

                1-3-1-3-1-3-1-3-1-3-1-3

                so for 10 digit number such as 1010000201
                1 0 1 0 0 0 0 2 0 1
                1 3 1 3 1 3 1 3 1 3
                -------------------
                1+0+1+0+0+0+0+6+0+3 = 11

                Next higher multiple of 10 AFTER the result = 20
                Difference of 20 - 11 = 9

                so check digit is 9 and resulting number is 10100002019

         */

        def completeNumber = this.customer?.internalId?.toString()?.padLeft(3, '0')
        completeNumber += this.internalId?.toString()?.padLeft(5,'0')
        completeNumber += this.revision?.toString()?.padLeft(2,'0')

        Integer result = 0
        def multiplier = completeNumber.toString().length() % 2 ? 3 : 1
        completeNumber.toString().each{
            result += it.toInteger() * multiplier
            multiplier = multiplier % 3 ? 3 : 1
        }
        result = (Integer)10*(Math.ceil(Math.abs(result/10))) - result
        return completeNumber.toString() + result.toString()
    }

}
