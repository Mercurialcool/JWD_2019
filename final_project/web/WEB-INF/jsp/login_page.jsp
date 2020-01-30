<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="head_styles_scripts.jsp" %>
    <link href="static/css/sign-in.css" rel="stylesheet" type="text/css"/>
</head>
<body class="text-center">
<%@ include file="header.jsp" %>
<form class="form-signin" action="login" method="post">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="text" name="name" id="inputEmail" class="form-control" placeholder="Username" required autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
    <button class="btn btn-lg btn-primary btn-block" type="submit" value="login">Sign in</button>
</form>
</body>
</html>
