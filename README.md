# First Spring app

First attempt at creating a spring web app

localhost:8080

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
7. Controllers for other crud functions
8. extract repository to usecase
9. controller responible for just delegating action of request and delegating response is formed
10. Return xml (https://docs.spring.io/spring-boot/docs/current/reference/html/howto-spring-mvc.html)
11. Unit testing
12. Acceptance testing
13. Talk to database, implement reopsitory that talks to h2 database
14. Use JpaRepository to have in built methods
xx. Use flyway, to setup database migration, maven to run flyway