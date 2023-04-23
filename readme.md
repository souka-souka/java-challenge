### How to use this spring-boot project

- Install packages with `mvn package`
- Run `mvn spring-boot:run` for starting the application (or use your IDE)

Application (with the embedded H2 database) is ready to be used ! You can access the url below for testing it :

- Swagger UI : http://localhost:8080/swagger-ui.html
- H2 UI : http://localhost:8080/h2-console

> Don't forget to set the `JDBC URL` value as `jdbc:h2:mem:testdb` for H2 UI.



### Instructions

- download the zip file of this project
- create a repository in your own github named 'java-challenge'
- clone your repository in a folder on your machine
- extract the zip file in this folder
- commit and push

- Enhance the code in any ways you can see, you are free! Some possibilities:
  - Add tests
  - Change syntax
  - Protect controller end points
  - Add caching logic for database calls
  - Improve doc and comments
  - Fix any bug you might find
- Edit readme.md and add any comments. It can be about what you did, what you would have done if you had more time, etc.
- Send us the link of your repository.

#### Restrictions
- use java 8


#### What we will look for
- Readability of your code
- Documentation
- Comments in your code 
- Appropriate usage of spring boot
- Appropriate usage of packages
- Is the application running as expected
- No performance issues

#### Your experience in Java
-I've been working with Java for 3 years, of which 1 year specifically with SpringBoot.

#### Comments:
1. Add transaction and exception handler
2. Added input validation
3. made response to be json(contains message,result code etc.)
4. Added authentication system using Spring Security,JWT and redis（caching logic）to protect controller end points:
 　※This function cannot be implemented in H2,so I create table in mysql. When create table in mysql,Don't forget to make id auto increment.


#### Left out of scope as don't have enough time:
1. Entities should not be used for transfer data.
2. message should be put in message.properties file or make them to be constant
3. Logging and security audit logging
4. Obtain permission information and encapsulate it into Authentication
5. Caching logic for database calls can be used in toppages which is not be changed frequently, Employee information is not suitable

