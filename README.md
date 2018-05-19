# First Spring app

First attempt at creating a spring web app

**NOTE MAIN METHODN IN APPLICATION CLASS MUST BE OUTSIDE OF CONFIGURATION CLASSES**

1. Application class with spring runner set
    - need to have a controller, as when go to uri, nothing can handle request
2. Couple of end points  can be hit with GET request and a response is returned in BlogController.class
3. Use path variables in BlogController.class
    - Set context root and port using property file
    - http://localhost:8090/hanfak/ex/foos/1/Han
    - http://localhost:8090/hanfak/ex/foos/1
4. Use configuration to set port
    - http://localhost:8012/hanfak/ex/foos/1
6. Path variables using regex
    -  http://localhost:8012/hanfak/ex/foos/asfsa // will fail
    -  http://localhost:8012/hanfak/ex/foos/123415 // will pass
5. Use path parameters
    -  http://localhost:8012/hanfak/ex/bars?id=100
    -  http://localhost:8012/hanfak/ex/bars?id=100&second=something
6. Controller will do some logic
    - do some data stuff etc
    - DAO must have default constructor specified
    - Setup a
    - http://localhost:8012/hanfak/blog
    - no usecase, controller talking directly to repository
    - inverted dependency using interface for repository
        - used bean in configuraiont to wire in implementation
        - autowired the repository into the controller
    - The repository implementation used is a map, but can be changed at runtime via the bean to access a database
    - reordered packages to make it a more clean architecture
    - Controller method index(), return list<Blog>, this is serializable by jackson into json, so response is in json
7. Set response and request headers, status code in controller
    - return ResponseEntity, use of new instance and builder
    - set single header and multiple headers
    - use of constructor instead of autowired
    - http://localhost:8012/hanfak/blah or http://localhost:8012/hanfak/blah1
        - must add headers as specified in controller or returns 404
8. Controllers for other crud functions
    - Examples
        -  GET http://localhost:8012/hanfak get all
        -  GET http://localhost:8012/hanfak/1 get item with id = 1
        -  POST http://localhost:8012/hanfak/blog/search Search blogs
        - with body {"text:" : "<search term>"}
        -  POST http://localhost:8012/hanfak/blog add new blog
            - with body {"id":10, "title":"a title" ,"content":"some content"}
            - Note if id should be unique, it is the responisbility of the repository to check that it is unique
                - Throws exception and spring takes care of it (to see this send same body with post)
        - PUT  http://localhost:8012/hanfak/blog/1 update new blog
            - with body {"id":1, "title":"a changed title" ,"content":"some changed content"}
        - DELETE  http://localhost:8012/hanfak/blog/1 delete a blog
9. Handle exception using 'ExceptionHandler'
    - Neater way to handle exceptions, define status code, add some loggin
10. Add logging using slf4j and logback (via spring)
    - xml used to defined custom log output
    - can see in console
11. Extract repository to usecase
    - The controller should not have any knowledge of what happens to the request. This should be passed to elsehwere.
    - Usecase will do all the app logic, call 3rd party api/db all via interfaces.
        - Will do stuff and return somthing that needs to be part of response
        - Can be
    - Usecase implements interface which is called by controller, although does not need to as out layer (controller) does depend on inner layer (usecase) DIP
12. Example of using dto
    - allows object to be returned from the controller, and body is now json
        - field names are the keys, and constructor arg aer the variables
        - need getters, with standard naming conventions
13. DTO turns to xml
    - DTO must have a default constructor only
        - use setters to build object
    - use of annotations
    - add dependency in xml
    - http://localhost:8012/hanfak/ex/xmldto/1

### Others

- Example using presenter to package response and send it to controller
- Handle different exceptions using custom exceptions
- controller responible for just delegating action of request and delegating response is formed
- controller has delegator to form body for non database return values (ie requesters api requirements)
- Return xml (https://docs.spring.io/spring-boot/docs/current/reference/html/howto-spring-mvc.html)
- Unit testing
- Acceptance testing
- intgeration testing
    - http://www.baeldung.com/integration-testing-in-spring
- Talk to database, use sql queries implement repsitory that talks to h2 database
- Use JpaRepository to have in built methods
- USe custom JPA methods
- Use foreign keys in data
- Use flyway, to setup database migration, maven to run flyway
- use hibernate (http://www.baeldung.com/hibernate-4-spring)
- use mysql database
- use in memory database for tests ie h2/darby
- Call third party api
- use different property files for different environments
- spring logging
- use logging template, customise
- spring actuator
- customise actuatur
- create status page
- static webpage/with some js
- use a framework
- job scheduler
- use jsp for web page
- link to non http app, ie javafx or just simple main mmethod
- dockerise, fabric8
- use jetty server
    - https://howtodoinjava.com/spring/spring-boot/configure-jetty-server/
    - issues with configuring jetty in bean
