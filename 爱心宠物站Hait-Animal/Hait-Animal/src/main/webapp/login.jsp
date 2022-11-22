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
    <form action="/Hait-Animal/loginServlet" id="form">
        <h1 id="loginMsg">LOGIN IN</h1>
        <div id="errorMsg">${login_msg} ${register_msg}</div>
<%--        获取cookie的值，并显示--%>
        <p>Username:<input id="username" name="username" type="text" value="${cookie.username.value}"></p>
        <p>Password:<input id="password" name="password" type="password" value="${cookie.password.value}"></p>
        <p>Remember:<input id="remember" name="remember" type="checkbox" value="1"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <a href="register.jsp">没有账号？</a>
            <a href="administratorLogin.jsp">管理员登录</a>
        </div>
    </form>
</div>
<%-- 循环展示图片--%>
<%-- 虽然引入了login的css样式 但我如下操作进行了覆盖--%>
<%-- 原先的css的desert图片不能删除 要在selectAnimal.jsp中显示--%>
<style type="text/css">
    body{

        background: url("animalImgs/startAnimal1.jpg") no-repeat 0px 0px;
        background-repeat: no-repeat;
        background-size: 100% 100%;
        -moz-background-size: 100% 100%;

    }
</style>

<script>
    var imgs=["../Hait-Animal/animalImgs/startAnimal1.jpg","../Hait-Animal/animalImgs/startAnimal2.jpg","../Hait-Animal/animalImgs/startAnimal3.jpg","../Hait-Animal/animalImgs/startAnimal4.jpg","../Hait-Animal/animalImgs/startAnimal5.jpg","../Hait-Animal/animalImgs/startAnimal6.jpg","../Hait-Animal/animalImgs/startAnimal7.jpg"];
    function changeImgs(){
        var index;
        index=Math.floor(Math.random()*imgs.length);
        console.log(index);
        document.body.style.backgroundImage="url("+imgs[index]+")";
    }
    var time = 0;
    setInterval(function skip (){
        changeImgs()
    },2000);

</script>

</body>
</html>
