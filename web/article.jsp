<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>峰凌博客</title>
    <link rel="stylesheet" href="static/css/article.css">
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
                <img src="static/image/fabiao.jpg">
            </a>
        </div>
    </div>
    <!--内容栏-->
    <div class="content">
            <h3 class="title">${a.title}</h3>
            <p class="info">
                <img src="${a.user.upicture}">
                <span>作者：${a.user.nickName}</span>
                <span>时间：<fmt:formatDate value="${a.addTime}" pattern="yyyy-MM-dd"/></span>
            </p>
            <p class="content1">
                ${a.content}
            </p>
            <c:choose>
                <c:when test="${a.user.id == login_user.id}">
                    <a href="/article_modify?id=${a.id}" class="xiugai">修改</a>
                    <a href="/article_delect?id=${a.id}" class="shanchu">删除</a>
                </c:when>
                <c:when test="${a.user.id != login_user.id}">
                    <%--<a href="/dianzan" class="dianzan">点赞</a>--%>
                    <div class="dianzan1">
                        <a href="/dianzan?id=${a.id}" class="dianzan1" name="点赞">
                            <img src="static/image/133.jpg" alt="">
                        </a>
                    </div>
                    <%--<img src="static/image/13.png" alt="">--%>

                </c:when>
            </c:choose>
            <a onclick="history.back()" class="back">返回</a>

            <div class="contentall">
            <c:forEach items="${comments}" var="c">
                <div class="comment">
                    <div class="nav">
                        <span>评论</span>
                        <a href="#post" style="color: #5c5c5c;position: absolute;right: 40px">发表评论</a>
                    </div>
                    <div class="user">
                        <img src="${c.user.upicture}">
                        <span>作者：${c.user.nickName}</span>
                        <div class="user_comment">
                            ${c.comment}
                        </div>
                        <span>时间：<fmt:formatDate value="${c.addTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                        <c:if test="${login_user.id == c.user.id}">
                            <a href="/comment_delect?id=${c.id}">删除</a><%--如果用户名与作者相同可删除--%>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
            </div>
            <form class="post" action="/comment_insert" method="post" name="post">
                <p>发评论</p>
                <input type="hidden" name="a" value="${a.id}">
                <textarea name="pinglun"></textarea>
                <button type="submit">发评论</button>
            </form>

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
