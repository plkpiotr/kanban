<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
    <meta name="description" content="Kanban board implemented in Java EE, Hibernate and JPA - Project">
    <meta name="keywords" content="kanban, java, ee, hibernate, jpa, jpql, criteria api, maven, tomcat, postgresql">
    <meta name="author" content="Piotr Pałka">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Project | Kanban</title>
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
                <li><a href="company">Company</a></li>
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
                    <h1><strong>${project.getName()}</strong></h1>
                    <h2>${project.getDescription()}</h2>
                </div>
            </header>
            <section class="row">
                <div class="col-xs-12">
                    <a href="addtask?idProject=${project.getId()}">
                        <button class="btn btn-default" type="button">Add a task</button>
                    </a>
                </div>
            </section>
            <section class="row">
                <div class="col-xs-12">
                    <h3 style="margin-bottom: 2%">Summary:</h3>
                    <a href="#todo">
                        <button class="btn btn-warning" type="button">
                            To do: <span class="badge">${fn:length(todoTasks)}</span>
                        </button>
                    </a>
                    <a href="#doing">
                        <button class="btn btn-success" type="button">
                            Doing: <span class="badge">${fn:length(doingTasks)}</span>
                        </button>
                    </a>
                    <a href="#done">
                        <button class="btn btn-info" type="button">
                            Done: <span class="badge">${fn:length(doneTasks)}</span>
                        </button>
                    </a>
                </div>
            </section>
            <section class="row">
                <div class="col-xs-12">
                    <h3 id="todo"><strong>To do:</strong></h3>
                    <c:if test="${todoTasks[0] == null}">
                        <p>No tasks.</p>
                    </c:if>
                    <c:forEach items="${todoTasks}" var="task">
                        <div class="media yellow-note neat">
                            <img src="../../img/${task.getEmployee().getAvatar()}" alt="Avatar">
                            <h4>${task.getEmployee().getName()}</h4>
                            <p><strong>${task.getContent()}</strong></p>
                        </div>
                    </c:forEach>
                </div>
            </section>
            <section class="row">
                <div class="col-xs-12">
                    <h3 id="doing"><strong>Doing:</strong></h3>
                    <c:if test="${doingTasks[0] == null}">
                        <p>No tasks.</p>
                    </c:if>
                    <c:forEach items="${doingTasks}" var="task">
                        <div class="media green-note neat">
                            <img src="../../img/${task.getEmployee().getAvatar()}" alt="Avatar">
                            <h4>${task.getEmployee().getName()}</h4>
                            <p><strong>${task.getContent()}</strong></p>
                        </div>
                    </c:forEach>
                </div>
            </section>
            <div class="row">
                <div class="col-xs-12">
                    <h3 id="done"><strong>Done:</strong></h3>
                    <c:if test="${doneTasks[0] == null}">
                        <p>No tasks.</p>
                    </c:if>
                    <c:forEach items="${doneTasks}" var="task">
                        <div class="media blue-note neat">
                            <img src="../../img/${task.getEmployee().getAvatar()}" alt="Avatar">
                            <h4>${task.getEmployee().getName()}</h4>
                            <p><strong>${task.getContent()}</strong></p>
                        </div>
                    </c:forEach>
                </div>
            </div>
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
