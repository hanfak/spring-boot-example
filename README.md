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

### OThers

- Controllers for other crud functions
- extract repository to usecase
- controller responible for just delegating action of request and delegating response is formed
- Return xml (https://docs.spring.io/spring-boot/docs/current/reference/html/howto-spring-mvc.html)
- Unit testing
- Acceptance testing
- intgeration testing
    - http://www.baeldung.com/integration-testing-in-spring
- Talk to database, use sql queries implement repsitory that talks to h2 database
- Use JpaRepository to have in built methods
- USe custom JPA methods
- Use flyway, to setup database migration, maven to run flyway
- use hibernate (http://www.baeldung.com/hibernate-4-spring)
- use mysql database
- spring logging
- spring actuator
- static webpage/with some js
- job scheduler
- use jsp for web page
- link to non http app, ie javafx or just simple main mmethod
- dockerise, fabric8
- use jetty server
    - https://howtodoinjava.com/spring/spring-boot/configure-jetty-server/