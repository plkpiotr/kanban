<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
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

    <script src="../../js/bootstrap.min.js"></script>
    <script src="../../js/jquery-3.2.1.min.js"></script>
</head>
<body>
    <h2>Registration</h2>
    ${info}
    <form method="post">
        <p>Name:</p>
        <label>
            <input name="name" maxlength="15">
        </label>
        <p>Surname:</p>
        <label>
            <input name="surname" maxlength="20">
        </label>
        <p>Nick:</p>
        <label>
            <input name="nick" maxlength="10">
        </label>
        <p>Password:</p>
        <label>
            <input type="password" name="password" maxlength="15">
        </label>
        <p>Avatar:</p>
        <label>
            <input name="avatar" maxlength="10">
        </label>
        <p>Sex:</p>
        <label>
            <input name="sex" maxlength="10">
        </label>
        <p>Company:</p>
        <label>
            <input name="company" maxlength="10">
        </label>
        <input type="submit" value="Register">
    </form>
    <a href="index">Index</a><br>
    <a href="login">Login</a>
</body>
</html>