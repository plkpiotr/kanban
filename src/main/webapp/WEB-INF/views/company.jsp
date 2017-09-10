<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
    <meta name="description" content="Kanban board implemented in Java EE, Hibernate and JPA - Company">
    <meta name="keywords" content="kanban, java, ee, hibernate, jpa, jpql, criteria api, maven, tomcat, postgresql">
    <meta name="author" content="Piotr Pałka">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Company | Kanban</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="icon" href="../../img/post-it.png">
    <script src="../../js/jquery-3.2.1.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script src="../../js/backToTheSamePlace.js"></script>
</head>
<body>
    <nav class="navbar navbar-default navbar-static-top">
        <div class="container">
            <p class="navbar-text navbar-left">
                <img src="../../img/post-it-mini.png" alt="Notes">
            </p>
            <p class="navbar-text navbar-left">
                Kanban
            </p>
            <ul class="nav navbar-nav navbar-left">
                <li class="active"><a href="company">Company</a></li>
                <li><a href="profile">Profile</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="logout">Log out</a></li>
            </ul>
        </div>
    </nav>
    <main>
        <article class="container">
            <header class="row">
                <div class="col-xs-12">
                    <h2>Team:</h2>
                </div>
            </header>
            <section class="row">
                <div class="col-xs-12">
                    <c:forEach items="${employees}" var="employee">
                        <figure style="display: inline-block;">
                            <img src="../../img/${employee.getAvatar()}" alt="Avatar"
                                 style="margin: 10px; width: 150px;">
                            <figcaption>
                                <c:choose>
                                    <c:when test="${employee.getName().length() + employee.getName().length() < 20}">
                                        ${employee.getName()} ${employee.getSurname()}
                                    </c:when>
                                    <c:otherwise>
                                        ${employee.getName().charAt(0)}. ${employee.getSurname()}
                                    </c:otherwise>
                                </c:choose>
                            </figcaption>
                        </figure>
                    </c:forEach>
                </div>
            </section>
            <section class="row">
                <div class="col-xs-12">
                    <h2 style="margin-bottom: 2%;">Projects:</h2>
                    <p class="bg-info text-center">${infoProject}</p>
                    <table class="table table-hover table-bordered">
                        <thead>
                        <tr>
                            <th>Delete</th>
                            <th>Project</th>
                            <th>Description</th>
                            <th>Tasks</th>
                            <th>Enter</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${projects}" var="project">
                            <tr>
                                <td>
                                    <form method="post">
                                        <input type="hidden" name="idProject" value="${project.getId()}">
                                        <button class="btn btn-danger btn-xs">Delete</button>
                                    </form>
                                </td>
                                <td>${project.getName()}</td>
                                <td>${project.getDescription()}</td>
                                <td>${project.getListOfTasks().size()}</td>
                                <td>
                                    <a href="project?idProject=${project.getId()}">
                                        <span class="badge">»</span>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </section>
            <section class="row">
                <div class="col-xs-12">
                    <h2 style="margin-bottom: 4%;">Add a new project:</h2>
                    <form method="post">
                        <div class="col-sm-4 text-center">
                            <div class="form-group">
                                <label for="name">Name:</label>
                                <input class="form-control" id="name" placeholder="Name" name="name"
                                       minlength="3" maxlength="15" style="margin-top: 1%;" required>
                            </div>
                        </div>
                        <div class="col-sm-4 text-center">
                            <div class="form-group">
                                <label for="description">Content:</label>
                                <input class="form-control" id="description" placeholder="Description"
                                       name="description" minlength="8" maxlength="64" style="margin-top: 1%;" required>
                            </div>
                        </div>
                        <div class="col-sm-4 text-center">
                            <input type="hidden" name="idProject" value="0">
                            <button class="btn btn-primary" style="margin-top: 25px;">Add the project »</button>
                        </div>
                    </form>
                </div>
            </section>
        </article>
    </main>
    <footer class="navbar navbar-default navbar-static-top margin-footer" style="margin-bottom: 0">
        <div class="container">
            <p class="navbar-text navbar-center">
                Kanban implemented in Java EE & Hibernate by
                <a href="https://github.com/plkpiotr">plkpiotr</a>.
            </p>
            <p class="navbar-text navbar-left">
                PNG files on the website were made by
                <a href="https://www.flaticon.com/authors/those-icons" title="Those Icons">Those Icons</a> and
                <a href="https://www.flaticon.com/authors/eucalyp" title="Eucalyp">Eucalyp</a> from
                <a href="https://www.flaticon.com/" title="Flaticon">flaticon.com</a> is licensed by
                <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a>.
            </p>
        </div>
    </footer>
</body>
</html>