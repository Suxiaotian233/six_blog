<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>峰凌博客</title>
    <link rel="stylesheet" href="static/css/geren.css">
</head>
<body>
<div class="main">

    <!--顶部栏-->
    <div class="top">
        <div class="fllogo">
            <img src="static/image/flblogo.png" alt="">
        </div>
        <div class="nav">
            <ul>
                <li><a href="/index">首页</a></li>
                <li><a href="/geren">个人页面</a></li>
                <li><a href="/download">相关下载</a></li>
                <li><a href="/lianxi">联系我们</a></li>
            </ul>
        </div>
        <div class="zhuce">
            <a href="/article_insert">
                <img src="static/image/fabiao.jpg" alt="">
            </a>
        </div>

    </div>
    <!--内容栏-->
    <div class="content">
        <!--内容栏左-->
        <div class="left">
            <!--文章-->

            <c:forEach items="${article}" var="a">
                <c:if test="${a.user.id == login_user.id}">
                <div class="article1">
                    <div class="aimg1">
                        <img src="${a.picture}" alt="">
                    </div>
                    <div class="acontent">
                        <h3>${a.title}</h3>
                        <p>${a.summary}</p>
                        <span><fmt:formatDate value="${a.addTime}" pattern="yyyy-MM-dd"/></span>
                        <a href="/article?id=${a.id}"><img src="static/image/a11.jpg" alt=""></a>
                    </div>
                </div>
                </c:if>
            </c:forEach>
        </div>
        <!--内容栏右-->
        <div class="right">
            <!-- 用户信息-->
            <div class="geren">
                <div class="gerenimg">
                    <img src="${login_user.upicture}" alt="">
                </div>
                <div class="geren1">
                    <h4 style="text-align: center">${login_user.nickName}</h4>
                </div>
                <div class="ge2">
                    <ul>
                        <li>${login_user.love}</li>
                        <li>${login_user.fans}</li>
                        <li>${login_user.weiBo}</li>
                    </ul>
                </div>
                <div class="ge3">
                    <ul>
                        <li>关注</li>
                        <li>粉丝</li>
                        <li>微博</li>
                    </ul>
                </div>
            </div>
            <!--列表-->
            <div class="list">
                <div class="lul">
                    <h1>个人博客</h1>
                    <ul>
                        <li><a href="/geren">我的博客</a></li>
                        <li><a href="">关于我</a></li>
                        <li><a href="">我的相册</a></li>

                    </ul>
                    <h1>文章点击排行</h1>
                    <ul>
                        <li>个人博客</li>
                        <li>你好，五月</li>
                        <li>欠你的情书唯有交给时光看</li>
                        <li>好好睡觉，在谈生活</li>
                        <li>阳光正好，微风不燥</li>
                        <li>如果可以怎样爱</li>
                        <li>感谢现在的自己</li>
                        <li></li>
                    </ul>

                </div>
            </div>
        </div>
    </div>
    <!--底部栏-->
    <div class="botton">
        <p>
            本站部分文章、资源来自互联网，版权归原作者及网站所有，如果侵犯了您的权利，请及时联系我删除！
            <br>©峰凌博客. 版权六组所有     站点地图
            <br>晋ICP备16004636号-2
            <br>我们是有底线的
        </p>
    </div>
</div>
</body>
</html>