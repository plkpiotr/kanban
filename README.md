# Kanban
## Description
[TODO]
## Technologies
[TODO]
## Features
[TODO]
## Software tools
- IntelliJ IDEA 2017.2.2
- PostgreSQL 9.6 [pgAdmin 4]
- Apache Tomcat 8.5.20
## Structure project's
- src:
  - main:
    - java/com/plkpiotr/kanban/api:
      - Company.java
      - Employee.java
      - Project.java
      - Task.java
    - java/com/plkpiotr/kanban/dao:
      - CompanyDAO.java
      - EmployeeDAO.java
      - ProjectDAO.java
      - TaskDAO.java
    - java/com/plkpiotr/kanban/filters:
      - LoggedOnFilter.java
    - java/com/plkpiotr/kanban/listeners:
      - ConfigurationListener.java
      - InitializationListener.java
    - java/com/plkpiotr/kanban/servlets:
      - CompanyServlet.java
      - IndexServlet.java
      - LogInServlet.java
      - LogOutServlet.java
      - NewProjectServlet.java
      - NewTaskServlet.java
      - ProfileServlet.java
      - ProjectServlet.java
      - RegistrationServlet.java
    - resources/META-INF:
      - persistence.xml
    - webapp:
      - css:
        - style.css
      - img:
        - icon, background and avatars [PNG files]
      - js:
        - jquery-3.2.1.min.js [ready-made library]
      - WEB-INF:
        - views:
          - company.jsp
          - index.jsp
          - login.jsp
          - newProject.jsp
          - newTask.jsp
          - profile.jsp
          - project.jsp
          - registration.jsp
        - web.xml
  - test:
    - [TODO]
- pom.xml
- .idea [ready-made files in .zip]
- lib [ready-made files in .zip]
## How to run?
[TODO]
## Comments
[TODO]
## License
Apache License 2.0 