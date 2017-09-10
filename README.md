# Kanban
## Description
Web application based on scheduling system **Kanban**. The program helps manage programming projects (and not just) on the basis of tasks divided into three category: "to do", "doing" and "done".
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
    - java/com/plkpiotr/kanban/dao:
      - CompanyDAO.java
      - EmployeeDAO.java
      - ProjectDAO.java
      - TaskDAO.java
    - java/com/plkpiotr/kanban/domain:
      - Company.java
      - Employee.java
      - Project.java
      - Task.java
    - java/com/plkpiotr/kanban/listeners:
      - ConfigurationListener.java
      - InitializationListener.java
    - java/com/plkpiotr/kanban/servlets:
      - AddTaskServlet
      - CompanyServlet.java
      - IndexServlet.java
      - LogInServlet.java
      - LogOutServlet.java
      - ProfileServlet.java
      - ProjectServlet.java
      - RegistrationServlet.java
    - resources/META-INF:
      - persistence.xml
    - webapp:
      - css:
        - bootstrap.min.css [ready-made library]
        - style.css
      - img:
        - icon, background and avatars [PNG files]
      - js:
        - backToTheSamePlace.js
        - bootstrap.min.js [ready-made library]
        - jquery-3.2.1.min.js [ready-made library]
      - WEB-INF:
        - views:
          - addtask.jsp
          - company.jsp
          - index.jsp
          - login.jsp
          - profile.jsp
          - project.jsp
          - registration.jsp
        - web.xml
  - test:
    - [TODO]
- pom.xml
- .idea [ready-made files in .zip]
- lib [ready-made files in .zip]
## Comments
Icon of Kanban was made by [Those Icon](https://www.flaticon.com/authors/those-icons) from [FlatIcon](https://www.flaticon.com/) is licensed by [CC BY 3.0](http://creativecommons.org/licenses/by/3.0/).
Avatars on the website were made by [Eucalyp](https://www.flaticon.com/authors/eucalyp) from [FlatIcon](https://www.flaticon.com/) is licensed by [CC BY 3.0](http://creativecommons.org/licenses/by/3.0/).
## License
Apache License 2.0 