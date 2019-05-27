<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>峰凌博客</title>
    <link rel="stylesheet" href="static/css/lianxi.css">
</head>
<body>
<div class="main">
    <div id="zixunbox">
        <a href="tencent://message/?Menu=yes&uin=871965006"><img src="static/image/kefu.jpg" alt=""></a>
    </div>
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
            <img src="static/image/zhu2.jpg" alt="">
        </div>
        <div class="denglu">
            <img src="static/image/deng2.jpg" alt="">
        </div>
        <!--<div class="nav">
            <ul>
                <li>首页</li>
                <li>个人页面</li>
                <li>App下载</li>
                <li>关于我们</li>
            </ul>
        </div>-->
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
                </ul>
            </div>
        </div>
        <!--内容栏右-->
        <form onsubmit="return isok()">

            <div class="mainbox">

                <!--中间容器-->
                <div class="middlebox">
                    <div class="listright">
                        <div class="chanpin">
                            <img src="static/image/lianxiwomen.jpg" alt="">
                        </div>
                        <div class="content">
                            <div class="cplb">留言咨询</div>
                            <div class="chanpinlist" style="min-height: 570px">
                                <br><br>
                                <table id="tbwords">
                                    <tr>
                                        <td class="tb1">姓名：</td><td><input type="text" id="username" /></td>
                                    </tr>

                                    <tr>
                                        <td class="tb1">Email：</td><td><input type="text" id="Email" /></td>
                                    </tr>

                                    <tr>
                                        <td class="tb1">QQ：</td><td><input type="text" id="QQ" /></td>
                                    </tr>

                                    <tr>
                                        <td class="tb1">电话：</td><td><input type="text" id="Mobile" /></td>
                                    </tr>

                                    <tr>
                                        <td class="tb1">内容：</td><td><textarea type="text" id="content" rows="5" cols="50"></textarea></td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" style="text-align: right">
                                            <input type="reset" id="btnreset" value="取消"/>
                                            <input type="submit" value="提交" id="btnsubmit" >
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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
<script>
    //这个方法验证表单的输入框内是否为空
    function isok() {
        //验证用户名不能为空
        if (document.getElementById("username").value==""||document.getElementById("username").value==NaN){
            alert("用户名不能为空");
            return false;
        }

        //验证Email不能为空
        if (document.getElementById("Email").value==""||document.getElementById("Email").value==NaN){
            alert("Email不能为空");
            return false;
        }
        //验证Email格式不能为空
        var email =/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
        if (!document.getElementById("Email").value.match(email)){
            alert("Email格式错误");
            //重新获取焦点
            document.getElementById("Email").onfocus();
            return false;
        }
        //验证QQ不能为空
        if (document.getElementById("QQ").value==""||document.getElementById("QQ").value==NaN){
            alert("QQ不能为空");
            return false;
        }
        /*  //验证QQ格式
          var QQ =/^[0-9]*[1-9][0-9]*$;
          if (!document.getElementById("QQ").value.match(QQ)){
              alert("QQ格式错误");
              document.getElementById("QQ").onfocus();
              return false;
          }*/
        //验证电话不能为空
        if (document.getElementById("Mobile").value==""||document.getElementById("Mobile").value==NaN){
            alert("电话不能为空");
            return false;
        }
        /* var Mobile =/^[0-9]*[1-9][0-9]*$;
         if (!document.getElementById("Mobile").value.match(Mobile)){
             alert("手机号格式错误");
           //  document.getElementById("Mobile").onfocus();
             return false;
         }*/
        //验证内容不能为空
        if (document.getElementById("content").value==""||document.getElementById("content").value==NaN){
            alert("内容不能为空");
            return false;
        }
        return true;
    }
</script>
</html>