<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
    <meta name="description" content="Kanban board implemented in Java EE, Hibernate and JPA - newTask">
    <meta name="keywords" content="kanban, java, ee, hibernate, jpa, jpql, criteria api, maven, tomcat, postgresql">
    <meta name="author" content="Piotr Pałka">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Add task | Kanban</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="icon" href="../../img/post-it.png">
    <script src="../../js/jquery-3.2.1.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
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
            <section>
                <form method="post">
                    <div class="row">
                        <div class="col-xs-12">
                            <h3>Add new task to the project:</h3>
                            <p class="bg-info text-center">${infoTask}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4 text-center">
                            <p><strong>Assign employee:</strong></p>
                            <c:forEach items="${employees}" var="employee">
                                <div class="radio" style="padding: 2%; background-color: #f8f8f8">
                                    <label>
                                        <input type="radio" name="nick" value="${employee.getNick()}" required>
                                            ${employee.getName()} ${employee.getSurname()}
                                    </label>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="col-sm-4 text-center">
                            <p><strong>Select category:</strong></p>
                            <div class="form-group">
                                <div class="radio yellow-note" style="padding: 2%;">
                                    <label>
                                        <input type="radio" name="category" value="todo" required>
                                        To do
                                    </label>
                                </div>
                                <div class="radio green-note" style="padding: 2%;">
                                    <label>
                                        <input type="radio" name="category" value="doing" required>
                                        Doing
                                    </label>
                                </div>
                                <div class="radio blue-note" style="padding: 2%;">
                                    <label>
                                        <input type="radio" name="category" value="done" required>
                                        Done
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4 text-center">
                            <div class="form-group">
                                <label for="content">Content:</label>
                                <input class="form-control" id="content" placeholder="Content" name="content"
                                       minlength="8" maxlength="64" style="margin-top: 1%;" required>
                            </div>
                        </div>
                    </div>
                    <div class="row" style="margin-bottom: 1%;">
                        <div class="col-xs-1"></div>
                        <div class="col-xs-3 col-md-2 text-right">
                            <a class="btn btn-default" href="project?idProject=${project.getId()}">
                                « Back to the project
                            </a>
                        </div>
                        <div class="col-xs-4 col-md-2"></div>
                        <div class="col-xs-3 col-md-6 text-right">
                            <button class="btn btn-primary">Add the task »</button>
                        </div>
                        <div class="col-xs-1"></div>
                    </div>
                </form>
            </section>
        </article>
    </main>
</body>
</html>