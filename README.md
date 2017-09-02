# Kanban
## Description
TODO
## Technologies
TODO
## Features
TODO
## Software tools
- IntelliJ IDEA 2017.2.2
- PostgreSQL 9.6 [pgAdmin 4]
- Apache Tomcat 8.5.20
## Structure project's
- src:
  - main:
    - java/com/plkpiotr/kanban/api:
      - Employee.java
      - Project.java
      - Task.java
    - java/com/plkpiotr/kanban/dao:
      - EmployeeDAO.java
      - ProjectDAO.java
      - TaskDAO.java
    - java/com/plkpiotr/kanban/listeners:
      - ConfigurationListener.java
      - InitializationListener.java
    - java/com/plkpiotr/kanban/servlets:
      - IndexServlet.java
    - resources/META-INF:
      - persistence.xml
    - webapp:
      - WEB-INF:
        - web.xml
      - js:
        - jquery-3.2.1.min.js [ready-made library]
      - index.jsp
  - test:
    - TODO
- pom.xml
- .idea [ready-made files in .zip]
- lib [ready-made files in .zip]
## How to run?
TODO
## Comments
TODO
## License
Apache License 2.0 