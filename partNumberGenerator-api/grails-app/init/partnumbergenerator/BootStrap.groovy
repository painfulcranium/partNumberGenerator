package partnumbergenerator

class BootStrap {

    def init = { servletContext ->

        if( !Customer.findByName('customerA') ){
            new Customer(
                    name: 'customerA',
                    internalId: 100
            ).save()
        }

        if( !Customer.findByName('customerB') ){
            new Customer(
                    name: 'customerB',
                    internalId: 101
            ).save()
        }

        if( !Customer.findByName('customerC') ){
            new Customer(
                    name: 'customerC',
                    internalId: 102
            ).save()
        }



    }
    def destroy = {
    }
}
