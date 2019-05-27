<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="static/css/login_register.css">
</head>
<body>

    <div class="bj">


        <c:if test="${login == 1}">
            <div class="li1"><h3>登录</h3></div>
            <form action="/login" method="post" id="login">
                <input type="text" name="username" placeholder="用户名">
                <input type="password" name="password" placeholder="密码">
                <button>立即登录</button>
            </form>
        </c:if>
        <c:if test="${register == 1}">
        <div class="li2"><h3>注册</h3></div>
        <form action="/register" method="post" id="register">

            <input type="text" name="username" placeholder="用户名">
            <input type="password" name="password" placeholder="密码">
            <input type="text" name="nickname" placeholder="昵称">
            <input type="text" name="email" placeholder="请输入邮箱地址">
            <button>立即注册</button>
        </form>
        </c:if>
    </div>
</body>
<script type="text/javascript" src="jquery-3.4.0.min.js"></script>
</html>
