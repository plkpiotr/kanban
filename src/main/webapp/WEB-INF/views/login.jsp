<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
    <meta name="description" content="Kanban board implemented in Java EE, Hibernate and JPA - Login">
    <meta name="keywords" content="kanban, java, ee, hibernate, jpa, jpql, criteria api, maven, tomcat, postgresql">
    <meta name="author" content="Piotr Pałka">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Login | Kanban</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="icon" href="../../img/post-it.png">
    <script src="../../js/jquery-3.2.1.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
    <main class="container">
        <div class="row">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <h2 style="margin-bottom: 5%;">Log in <small>to the Kanban</small></h2>
                <p class="bg-info">${infoLogin}</p>
                <form method="post">
                    <div class="form-group">
                        <label for="nick">Nick:</label>
                        <input class="form-control" id="nick" placeholder="Nick" name="nick" maxlength="10" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" class="form-control" id="password" placeholder="Password"
                               name="password" maxlength="15" required>
                    </div>
                    <nav>
                        <div class="col-xs-12" style="margin-bottom: 5%;">
                            <button class="btn btn-primary">Log in »</button>
                        </div>
                        <div class="col-xs-12" style="margin-bottom: 5%;">
                            <a class="btn btn-default" href="index">« Home page</a>
                        </div>
                        <div class="col-xs-12" style="margin-bottom: 5%;">
                            <a class="btn btn-default" href="registration">« Registration</a>
                        </div>
                    </nav>
                </form>
            </div>
            <div class="col-sm-4"></div>
        </div>
    </main>
</body>
</html>
