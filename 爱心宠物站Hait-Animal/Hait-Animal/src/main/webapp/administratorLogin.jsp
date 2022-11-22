<%--
  Created by IntelliJ IDEA.
  User: wangzhen
  Date: 2022/7/30
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="css/login.css" rel="stylesheet">
</head>

<body>
<%--是否忽略el表达式--%>
<%@ page isELIgnored="false" %>
<div id="loginDiv" style="height: 350px">
    <form action="/Hait-Animal/administratorLoginServlet" id="form">
        <h1 id="loginMsg">LOGIN IN</h1>
        <div id="errorMsg">${login_msg} ${register_msg}</div>
        <%--        获取cookie的值，并显示--%>
        <p>Username:<input id="username" name="username" type="text" value="${cookie.username.value}"></p>
        <p>Password:<input id="password" name="password" type="password" value="${cookie.password.value}"></p>
        <p>Remember:<input id="remember" name="remember" type="checkbox" value="1"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <a href="login.jsp">普通登录</a>
        </div>
    </form>
</div>

</body>
</html>





