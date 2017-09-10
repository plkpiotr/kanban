<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
    <meta name="description" content="Kanban board implemented in Java EE, Hibernate and JPA - Profile">
    <meta name="keywords" content="kanban, java, ee, hibernate, jpa, jpql, criteria api, maven, tomcat, postgresql">
    <meta name="author" content="Piotr Pałka">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Profile | Kanban</title>
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
                <li class="active"><a href="profile">Profile</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="logout">Log out</a></li>
            </ul>
        </div>
    </nav>
    <main>
        <article class="container">
            <header class="row">
                <header class="col-xs-12 col-md-3">
                    <figure>
                        <img src="../../img/${employee.getAvatar()}" alt="Avatar">
                        <figcaption>
                            <h3>${employee.getName()} ${employee.getSurname()}</h3>
                        </figcaption>
                    </figure>
                </header>
                <div class="col-xs-12 col-md-9">
                    <h2 style="margin-bottom: 2%;">Your tasks:</h2>
                    <h4>To do: </h4>
                    <div class="progress progress-striped">
                        <div class="progress-bar progress-bar-warning" style="width: ${todoPercent}%">
                            ${todoTasks.size()}/${allTasks.size()}
                        </div>
                    </div>
                    <h4>Doing: </h4>
                    <div class="progress progress-striped">
                        <div class="progress-bar progress-bar-success" style="width: ${doingPercent}%">
                            ${doingTasks.size()}/${allTasks.size()}
                        </div>
                    </div>
                    <h4>Done: </h4>
                    <div class="progress progress-striped">
                        <div class="progress-bar progress-bar-info" style="width: ${donePercent}%">
                            ${doneTasks.size()}/${allTasks.size()}
                        </div>
                    </div>
                </div>
            </header>
            <section class="row">
                <div class="col-xs-12">
                    <h3>To do:</h3>
                    <c:if test="${todoTasks[0] == null}">
                        <p>No tasks.</p>
                    </c:if>
                    <c:forEach items="${todoTasks}" var="task">
                        <div class="media yellow-note">
                            <div class="media-body">
                                <div class="media-body">
                                    <h4 class="media-heading">
                                        <a href="project?idProject=${task.getProject().getId()}">${task.getProject().getName()}</a>
                                    </h4>
                                    <strong>${task.getContent()}</strong>
                                    <form method="post">
                                        <input type="hidden" name="idTask" value="${task.getId()}">
                                        <button class="btn btn-warning btn-xs">Move down</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </section>
            <section class="row">
                <div class="col-xs-12">
                    <h3>Doing:</h3>
                    <c:if test="${doingTasks[0] == null}">
                        <p>No tasks.</p>
                    </c:if>
                    <c:forEach items="${doingTasks}" var="task">
                        <div class="media green-note">
                            <div class="media-body">
                                <h4 class="media-heading">
                                    <a href="project?idProject=${task.getProject().getId()}">${task.getProject().getName()}</a>
                                </h4>
                                <strong>${task.getContent()}</strong>
                                <form method="post">
                                    <input type="hidden" name="idTask" value="${task.getId()}">
                                    <button class="btn btn-success btn-xs">Move down</button>
                                </form>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </section>
            <section class="row">
                <div class="col-xs-12">
                    <h3>Done:</h3>
                    <c:if test="${doneTasks[0] == null}">
                        <p>No tasks.</p>
                    </c:if>
                    <c:forEach items="${doneTasks}" var="task">
                        <div class="media blue-note">
                            <div class="media-body">
                                <div class="media-body">
                                    <h4 class="media-heading">
                                        <a href="project?idProject=${task.getProject().getId()}">${task.getProject().getName()}</a>
                                    </h4>
                                    <strong>${task.getContent()}</strong>
                                    <form method="post">
                                        <input type="hidden" name="idTask" value="${task.getId()}">
                                        <button class="btn btn-info btn-xs">Delete</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
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
