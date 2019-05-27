<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }

        form{
            width: 320px;
            padding: 15px;
            box-sizing: border-box;
            border: 1px solid #dddddd;
            border-radius: 8px;
            text-align: center;
            margin: 50px auto;
            box-shadow: 0 0 20px rgba(0,0,0,0.2);
        }
        h1{
            color: #3247dd;
            font-size: 22px;
            margin-bottom: 20px;
        }
        input{
            width: 100%;
            height: 30px;
            font-size: 17px;
            padding: 0 10px;
            box-sizing: border-box;
            margin-bottom: 15px;
        }
        button{
            display: block;
            width: 100%;
            height: 40px;
            background-color: #3247dd;
            color: #fff;
            font-size: 16px;
            border: none;
            border-radius: 6px;
            margin: 10px 0;
        }
    </style>
</head>
<body>
    <form action="/login" method="post">
        <h1>用户登录</h1>
        <input type="text" name="username" placeholder="用户名">
        <input type="password" name="password" placeholder="密码">
        <button type="submit">立即登录</button>
    </form>
</body>
</html>
