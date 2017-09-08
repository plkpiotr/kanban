<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
    <meta name="description" content="Kanban board implemented in Java EE, Hibernate and JPA - Registration">
    <meta name="keywords" content="kanban, java, ee, hibernate, jpa, jpql, criteria api, maven, tomcat, postgresql">
    <meta name="author" content="Piotr Pałka">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Registration | Kanban</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="icon" href="../../img/post-it.png">
    <script src="../../js/jquery-3.2.1.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h2 class="text-center">Join <small>the Community of Kanban</small></h2>
        <p class="bg-info text-center">${infoRegistration}</p>
        <form method="post">
            <div class="row">
                <div class="col-sm-6">
                    <div class="row">
                        <div class="col-xs-2"></div>
                        <div class="col-xs-8">
                            <div class="form-group">
                                <label for="name">Name:</label>
                                <input class="form-control" id="name" placeholder="Name" name="name" maxlength="15">
                            </div>
                            <div class="form-group">
                                <label for="surname">Surname:</label>
                                <input class="form-control" id="surname" placeholder="Surname" name="surname" maxlength="20">
                            </div>
                            <div class="form-group">
                                <label for="nick">Nick:</label>
                                <input class="form-control" id="nick" placeholder="Nick" name="nick" maxlength="10">
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" id="password" placeholder="Password" name="password"
                                       maxlength="15">
                            </div>
                            <div class="form-group">
                                <label for="company">Company:</label>
                                <input class="form-control" id="company" placeholder="Company" name="company" maxlength="15">
                            </div>
                        </div>
                        <div class="col-xs-2"></div>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="row">
                        <p><strong>Select your avatar:</strong></p>
                        <c:forEach var = "i" begin = "1" end = "49">
                            <div class="radio" style="display: inline;">
                                <label>
                                    <input type="radio" name="avatar" value="${i}.png">
                                    <img src="../../img/${i}.png" alt="Avatar" style="width: 50px; padding: 5% 2%;">
                                </label>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="row" style="margin-bottom: 1%;">
                <div class="col-xs-1"></div>
                <div class="col-xs-3 col-md-2 text-right">
                    <a class="btn btn-default" href="index">« Home page</a>
                </div>
                <div class="col-xs-4 col-md-2 text-right">
                    <a class="btn btn-default" href="login">« Login</a>
                </div>
                <div class="col-xs-3 col-md-6 text-right">
                    <button class="btn btn-primary">Register »</button>
                </div>
                <div class="col-xs-1"></div>
            </div>
        </form>
    </div>
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