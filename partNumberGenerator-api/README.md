**API for Part Number Generator App/UI**
-
## Description:
 
This is a sample grails 3.3.9 project built using the rest-api profile. This is an example application that can
be used to generate part numbers for example customers and also retrieve them.

This application uses an H2 in memory database to run

Sample data is loaded via BootStrap.groovy, and there is also 
an example migration script that adds the necessary schema for the application.
 

## Run the application
Once grails 3.3.9 is installed, run `grails run-app` to run the app on port 8080.

## Run the unit tests
To run the unit tests, run `grails test-app`

## Misc
There is also a corresponding Angular UI that can be used to test out the API, as well as a PostMan collection in the root of this project directory

There will probably be a few bugs...this is a demo application ;)

## Exclusions
Although the Spring REST Security plugin is loaded, and has a minimal configuration, it is not heavily used (yet) as this application
was done primarily as a 'demo' application and is not meant to be very secure, or robust, or really run anywhere but
on a local machine.... :)
