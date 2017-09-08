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
    <title>New task | Kanban</title>
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
                <div class="col-xs-12">
                    <h3>Add new task to the project:</h3>
                </div>
                <div class="row">
                    <div class="col-xs-2"></div>
                    <div class="col-xs-8">
                        <div class="form-group">
                            <label for="content">Content:</label>
                            <input class="form-control" id="content" placeholder="Content" name="content" minlength="8"
                                   maxlength="64" required>
                        </div>
                        <div class="row">
                            <p><strong>Assign employee:</strong></p>
                            <c:forEach items="${employees}" var="employee">
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="id" value="${employee}" required>
                                        ${employee.getName()} ${employee.getSurname()}
                                    </label>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="col-xs-2"></div>
                </div>
            </section>
        </article>
    </main>
</body>
</html>