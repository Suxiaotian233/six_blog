<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>峰凌博客</title>
    <link rel="stylesheet" href="static/css/index.css">
</head>
<body>
<div class="main">
    <!--顶部栏-->
    <div class="top">
        <div class="fllogo">
            <img src="static/image/flblogo.png">
        </div>
        <div class="nav">
            <ul>
                <li><a href="/index">首页</a></li>
                <c:choose>
                    <c:when test="${login_user ==null}"><li><a href="/login">个人页面</a></li></c:when>
                    <c:when test="${login_user !=null}"><li><a href="/geren">个人页面</a></li></c:when>
                </c:choose>
                <li><a href="/download">相关下载</a></li>
                <li><a href="/lianxi">联系我们</a></li>
            </ul>
        </div>
        <div class="dl_zc">
            <c:if test="${login_user == null}">
                <div class="zhuce">
                    <a href="/register" id="zhuce"><img src="static/image/zhu2.jpg" alt=""></a>
                </div>
                <div class="denglu">
                    <a href="/login" id="denglu"><img src="static/image/deng2.jpg" alt=""></a>
                </div>
            </c:if>
            <c:if test="${login_user != null}">
                <a class="user" href="/geren" style="font-weight: bolder;text-decoration: none" >用户中心</a>
                <a class="zhuxiao" href="/logout" style="font-weight: bolder;text-decoration: none;color: #5c5c5c">注销</a>
            </c:if>
        </div>


    </div>
    <!--内容栏-->
    <div class="middle">
        <!--内容栏左-->
        <div class="left">
            <div class="limg">
                <img src="static/image/limg.jpg" alt="">
            </div>
            <div class="lul">
                <h1>热门搜索</h1>
                <ul>
                    <li>《复联4》票房破两项吉尼斯纪录</li>
                    <li>Ella回复孟美岐高仿号本尊机智回应</li>
                    <li>《流浪地球》下映 内地票房超46亿元</li>
                    <li>《复联4》成全球票房亚军</li>
                    <li>张杰卡点为谢娜庆生：爱你</li>
                    <li>阿Sa带92岁奶奶现身日月潭</li>
                    <li>水滴筹回应德云社吴鹤臣众筹</li>
                    <li>北京一饭店为尽早打烊，冬天开冷风</li>
                    <li>英国盗贼作案，假肢脱落被抓。</li>
                    <li>夫妇离婚，用竞价方式分配共有财产。</li>
                    <li>中国自研最大水陆两栖飞机首飞成功</li>
                    <li>墨西哥一电视剧连续35年播出</li>
                </ul>
            </div>
        </div>
        <!--内容栏右-->
        <div class="right">
            <!--内容栏右banner轮播-->
            <div class="banner">
                <div >
                    <img src="static/image/ban33.jpg" alt="" id="banner1">
                </div>
                <div id="spanbtn">
                    <span onmouseover="showbannerbyid(1)"  onmouseout="btnMouseOut()">1</span>
                    <span onmouseover="showbannerbyid(2)"  onmouseout="btnMouseOut()">2</span>
                    <span onmouseover="showbannerbyid(3)"  onmouseout="btnMouseOut()">3</span>
                    <span onmouseover="showbannerbyid(4)"  onmouseout="btnMouseOut()">4</span>
                </div>

            </div>
            <!--内容栏右文章推送一-->
            <div class="index_article">
            <c:forEach items="${article}" var="a">
            <div class="article1">
                <div class="aimg1">
                    <img src="${a.picture}" alt="">
                </div>
                <div class="acontent">
                    <h3>${a.title}</h3>
                    <p>${a.summary}</p>
                    <span><fmt:formatDate value="${a.addTime}" pattern="yyyy-MM-dd"/>
                        阅读数：${a.readTotal}评论数：${a.plnumber}点赞数：${a.dznumber}<br>
                        <c:if test="${a.user.id == login_user.id}">
                            <a href="/article_modify?id=${a.id}" style="color: #5c5c5c">修改</a>
                            <a href="/article_delect?id=${a.id}" style="color: #5c5c5c">删除</a>
                        </c:if>
                    </span>
                    <a href="/article?id=${a.id}"><img src="static/image/a11.jpg"></a>


                </div>
            </div>

            </c:forEach>
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
<script type="text/javascript" src="WEB-INF/jquery-3.4.0.min.js"></script>
<script>
    //***图片切换效果
    /*实例话一个数组,用于存放图片路径*/
    var arr = new Array;
    arr[0] = "static/image/ban33.jpg";
    arr[1] = "static/image/ban3.jpg";
    arr[2] = "static/image/ban6.jpg";
    arr[3] = "static/image/ban11.jpg";
    var count = 0;
    /*实现自动切换图片*/
    function autoPlayer() {
        if (arr.length == count)
            count = 0;
        document.getElementById("banner1").src= arr[count];
        count++;
    }
    /*让图片切换的延时*/
    var Timer = setInterval(autoPlayer,2000);
    /*清除定时器对象*/
    function clearTimer() {
        clearInterval(Timer);
    }
    /*鼠标悬停时侯指定播放的图片*/
    function showbannerbyid(num) {
        clearTimer();
        var index = parseInt(num);
        document.getElementById("banner1").src=arr[index-1];
        count = index;
    }
    /*鼠标离开回复，自动恢复图片自动播放效果*/
    function btnMouseOut(num) {
        Timer=setInterval(autoPlayer,2000);
    }



    !function(){

        function n(n,e,t){

            return n.getAttribute(e)||t

        }

        function e(n){

            return document.getElementsByTagName(n)

        }

        function t(){

            var t=e("script"),o=t.length,i=t[o-1];

            return{

                l:o,z:n(i,"zIndex",-1),o:n(i,"opacity",.5),c:n(i,"color","0,0,0"),n:n(i,"count",99)

            }

        }

        function o(){

            a=m.width=window.innerWidth||document.documentElement.clientWidth||document.body.clientWidth,

                c=m.height=window.innerHeight||document.documentElement.clientHeight||document.body.clientHeight

        }

        function i(){

            r.clearRect(0,0,a,c);

            var n,e,t,o,m,l;

            s.forEach(function(i,x){

                for(i.x+=i.xa,i.y+=i.ya,i.xa*=i.x>a||i.x<0?-1:1,i.ya*=i.y>c||i.y<0?-1:1,r.fillRect(i.x-.5,i.y-.5,1,1),e=x+1;e<u.length;e++)n=u[e],

                null!==n.x&&null!==n.y&&(o=i.x-n.x,m=i.y-n.y,

                    l=o*o+m*m,l<n.max&&(n===y&&l>=n.max/2&&(i.x-=.03*o,i.y-=.03*m),

                    t=(n.max-l)/n.max,r.beginPath(),r.lineWidth=t/2,r.strokeStyle="rgba("+d.c+","+(t+.2)+")",r.moveTo(i.x,i.y),r.lineTo(n.x,n.y),r.stroke()))

            }),

                x(i)

        }

        var a,c,u,m=document.createElement("canvas"),

            d=t(),l="c_n"+d.l,r=m.getContext("2d"),
            x=window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||window.oRequestAnimationFrame||window.msRequestAnimationFrame||

                function(n){

                    window.setTimeout(n,1e3/45)

                },

            w=Math.random,y={x:null,y:null,max:2e4};m.id=l,m.style.cssText="position:fixed;top:0;left:0;z-index:"+d.z+";opacity:"+d.o,e("body")[0].appendChild(m),o(),window.onresize=o,

            window.onmousemove=function(n){

                n=n||window.event,y.x=n.clientX,y.y=n.clientY

            },

            window.onmouseout=function(){

                y.x=null,y.y=null

            };

        for(var s=[],f=0;d.n>f;f++){

            var h=w()*a,g=w()*c,v=2*w()-1,p=2*w()-1;s.push({x:h,y:g,xa:v,ya:p,max:6e3})

        }

        u=s.concat([y]),

            setTimeout(function(){i()},100)

    }();

</script>

</html>