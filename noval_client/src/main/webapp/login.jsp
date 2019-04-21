<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/13
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>小说网登录界面</title>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
            font-family: "微软雅黑";
        }

        p {
            display: block;
            font-style: normal;
            font-size: 14px;
            color: rgb(179, 177, 177)
        }

        li {
            list-style: none;
            display: inline-block;
        }

        li a {
            text-decoration: none;
        }
        button,input{
            outline: none;
        }
        html,
        body,
        .wrapper {
            width: 100%;
            height: 100%;
            overflow: hidden;
            background-image: url(images/background.jpg);
        }

        .wrapper {
            background-image: url("../img/bj.gif");
            background-size: 100% 100%;
            position: relative;
        }

        article {
            width: 1200px;
            margin: 0 auto;
        }

        article {
            width: 400px;
            margin: 100px auto 0px auto;
        }

        article h1 {
            width: 400px;
            color: #AFEEE;
            text-align: center;
            margin-bottom: 15px;
            font-weight: normal;
        }

        article h1 em {
            display: inline-block;
            color: white;
            font-size: 25px;
        }

        .main {
            padding: 40px 0px;
            width: 100%;
            background-color: rgba(24, 80, 137, 0.3);
        }

        form {
            width: 297px;
            margin: 0 auto;
        }

        .main form input {
            margin: 10px 0;
            width: 280px;
            height: 35px;
            border-radius: 3px;
            display: inline-block;
            background: #CCCCCC;
            border: 1px solid rgba(165, 161, 161, 0.1);
            padding-left: 10px;
        }

        #one {
            margin-left: 90px;
            width: 100px;
            height: 35px;
            color: white;
            border: none;
            background: #006699;
            margin-top: 15px;
            letter-spacing: 10px;
            font-size: 16px;
            text-align: center;
            cursor:pointer;
        }
    </style>
    <script type="text/javascript" src="js/jquery.min.js"></script>
</head>

<body>
<div class="wrapper">
    <article>
        <h1><em>小说网</em></h1>
        <div class="main">
            <form action="index.html">
                <div class="userName">
                    <input type="text" id="userName" placeholder="用户名"><p>由5-8个字符组成！</p>
                </div>
                <div class="password">
                    <input type="password" id="pwd" placeholder="密码"><p>使用字母、数字、符号两种及以上的组合，8-12个字符</p>
                </div>

                <input type="button" value="登录" id="one">
            </form>
        </div>
    </article>

</div>

</body>

</html>
