<%--
  Created by IntelliJ IDEA.
  User: wangzhen
  Date: 2022/8/13
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎访问</title>
<%--    <link href="css/login.css" rel="stylesheet">--%>
    <link href="css/animal.css" rel="stylesheet">
</head>
<body>

<style type="text/css">
    body{

        background: url("imgs/Desert1.jpg") no-repeat 0px 0px;
        background-repeat: no-repeat;
        background-size: 100% 100%;
        -moz-background-size: 100% 100%;

    }
</style>
<%--是否忽略el表达式--%>
<%@ page isELIgnored="false" %>
<script src="js/axios-0.18.0.js"></script>
<%-- 获取存储在session域中的值--%>
<h1 >${user.username} 欢迎您！！！</h1>

            <p align="center"><font color="red" size="3">序号：${animal.id}</font></p>

            <p align="center"><font color="red" size="3">动物名称：${animal.animalName}</font></p>

            <p align="center"><font color="red" size="3">动物性别：${animal.sex}</font></p>

            <p align="center"><font color="red" size="3">存活状态：${animal.isLive}</font></p>

            <p align="center"><font color="red" size="3">动物介绍：${animal.description}</font></p>

            <p align="center"><font color="red" size="3">点赞：${animal.likes}</font></p>


<%-- count记录点赞次数 双击两次发送请求点赞成功  再次双击取消点赞--%>
<img class="aligncenter" id="myimg" width=50px height=50px src="imgs/off.PNG">
<script>
    let count = 0;
    document.getElementById("myimg").onclick = function (){
        count++;
        if(count == 2){
            document.getElementById("myimg").src = "imgs/on.PNG";
            axios({
                method:"post",
                url:"http://localhost:8080/Hait-Animal/addLikesServlet",
                data: ${animal.id}
            }).then(function (resp){
                if(resp.data == "success"){
                //    点赞 没啥好写的
                }
            })
        }
        if(count == 4){
            document.getElementById("myimg").src = "imgs/off.PNG";
            count = 0;

        }

    }
</script>

<%-- 通过拼字符串的方式来实现图片展示 其中id为1 展示animal1 id为2 展示animal2--%>
            <p align="center"><font color="red" size="3">图片：</font></p>

            <img class="aligncenter" id="animalimg" width=400px height=300px src="">
            <script>
                let id = ${animal.id};
                document.getElementById("animalimg").src = "/Hait-Animal/animalImgs/animal" + id + ".jpg";
            </script>


<br>
<a href="http://localhost:8080/Hait-Animal/customerAnimal.html" target="_blank"><font color="red" size="5">返回</font></a>


</body>
</html>
