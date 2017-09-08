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
        ${infoRegistration}
        <div class="row">
            <form method="post">
                <div class="col-sm-6">
                    <div class="row">
                        <div class="col-xs-2"></div>
                        <div class="col-xs-8">
                            <div class="form-group">
                                <label for="name">Name</label>
                                <input class="form-control" id="name" placeholder="Name" name="name" maxlength="15">
                            </div>
                            <div class="form-group">
                                <label for="surname">Surname</label>
                                <input class="form-control" id="surname" placeholder="Surname" name="surname" maxlength="15">
                            </div>
                            <div class="form-group">
                                <label for="nick">Nick</label>
                                <input class="form-control" id="nick" placeholder="Nick" name="nick" maxlength="15">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password" placeholder="Password" name="password"
                                       maxlength="15">
                            </div>
                            <div class="form-group">
                                <label for="company">Company</label>
                                <input class="form-control" id="company" placeholder="Company" name="company" maxlength="15">
                            </div>
                        </div>
                        <div class="col-xs-2"></div>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="row">
                        <div class="col-xs-2"></div>
                        <div class="col-xs-8">
                            <c:forEach var = "i" begin = "1" end = "50">
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="blankRadio" id="blankRadio1" value="option1">
                                        <img src="../../img/02.png" alt="Avatar" style="width: 100px;">
                                    </label>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="col-xs-2"></div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <a href="index">Index</a><br>
    <a href="login">Login</a>
</body>
</html>