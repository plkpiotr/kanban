<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
    <meta name="description" content="Kanban board implemented in Java EE, Hibernate and JPA - Home page">
    <meta name="keywords" content="kanban, java, ee, hibernate, jpa, jpql, criteria api, maven, tomcat, postgresql">
    <meta name="author" content="Piotr Pałka">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home | Kanban</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="icon" href="../../img/post-it.png">
    <script src="../../js/jquery-3.2.1.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
    <main class="container">
        <header class="row">
            <div class="col-xs-12">
                <h3>Kanban board implemented in Java EE, Hibernate & JPA</h3>
            </div>
        </header>
        <section>
            <div id="carousel-example-generic2" class="carousel slide">
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic2" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic2" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic2" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="../../img/index1.png" alt="Company">
                    </div>
                    <div class="item">
                        <img src="../../img/index2.png" alt="Profile">
                    </div>
                    <div class="item">
                        <img src="../../img/index3.png" alt="Kanban board">
                    </div>
                </div>
                <a class="left carousel-control" href="#carousel-example-generic2" data-slide="prev">
                    <span class="icon-prev"></span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic2" data-slide="next">
                    <span class="icon-next"></span>
                </a>
            </div>
        </section>
        <nav>
            <div class="col-xs-6 text-center" style="margin: 2% 0 2%;">
                <a class="btn btn-default" href="registration">« Registration</a>
            </div>
            <div class="col-xs-6 text-center" style="margin: 2% 0 2%;">
                <a class="btn btn-default" href="login">Log in »</a>
            </div>
        </nav>
    </main>
</body>
</html>
