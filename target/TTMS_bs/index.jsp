<%--
  Created by IntelliJ IDEA.
  User: Infinity233
  Date: 2018/6/5
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录系统</title>

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/form-elements.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="layui-v2.3.0/layui/css/layui.css" media="all">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
</head>
<body>
<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>众生平等</strong>剧院票务管理系统</h1>
                    <br/>
                </div>
            </div>
            <br/>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>账号登录</h3>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="" method="post" id="loginForm" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Username</label>
                                <input type="text" name="username" placeholder="用户名"
                                       class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Password</label>
                                <input type="password" name="password" placeholder="密码"
                                       class="form-password form-control" id="form-password">
                            </div>
                            <button type="button" id="loginButton" class="btn">登录</button>
                            <button type="button" id="regButton" class="btn" style="margin-top: 20px">注册</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<form class="layui-form layui-form-pane" lay-filter="userForm" id="userForm" hidden>

    <input type="hidden" name="id" id="id">

    <div class="layui-form-item" style="margin-top: 20px">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="username" id="username" lay-verify="required" placeholder="请输入用户名"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="text" name="password" id="password" lay-verify="required" placeholder="请输入密码"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">昵称</label>
        <div class="layui-input-block">
            <input type="text" name="nickname" id="nickname" lay-verify="required" placeholder="请输入昵称"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-block">
            <input type="text" name="tel" id="tel" lay-verify="required" placeholder="请输入电话" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item" style="text-align:center">
        <%--<button class="layui-btn" id="imageAction" lay-submit lay-filter="submit">提交</button>--%>
        <input typ="button" class="layui-btn" id="imageAction" value="提交" style="width: 68px;"/>
        <button type="reset" class="layui-btn layui-btn-primary" id="reset">重置</button>
    </div>
</form>

<!-- Javascript -->
<script src="layui-v2.3.0/layui/layui.js"></script>
<script src="assets/js/jquery-1.11.1.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.backstretch.min.js"></script>
<script src="assets/js/scripts.js"></script>

<!--[if lt IE 10]>
<script src="assets/js/placeholder.js"></script>
<![endif]-->

<script>
    layui.use('table', function () {

        var table = layui.table;
        var $ = layui.$;
        var form = layui.form
            , layer = layui.layer;


        $("#loginButton").click(function () {
            $.ajax({
                type: 'POST',
                url: "/user/login.do",
                data: $('#loginForm').serialize(),
                async: true,
                success: function (result) {
                    if (result.errorMsg) {
                        alert(result.errorMsg);
                    }
                    else {
                        // alert('成功');
                        window.location.href = 'reception/main.html';
                    }
                },
                error: function () {
                    alert('未知错误');
                }
            });
        });

        $("#regButton").click(function () {
            $('#reset').trigger("click");
            layer.open({
                type: 1
                , title: '注册'
                // , area: ['500px', '350px']
                // ,shade: 0
                // ,maxmin: true
                , content: $("#userForm")
                , zIndex: layer.zIndex
            });
        });

        $("#imageAction").click(function () {
            $.ajax({
                type: "post",
                url: "/user/update.do",
                data: $('#userForm').serialize(),
                dataType: "json",
                async: true,
                error: function (request) {
                    layer.confirm('修改失败', {
                        skin: 'layui-layer-molv'
                        , title: '系统提示'
                        , btn: ['确定']
                        , anim: 4 //动画类型
                    });
                },
                success: function (data) {
                    if(data.errorMsg) {
                        layer.confirm(data.errorMsg, {
                            skin: 'layui-layer-molv'
                            , title: "修改失败"
                            , btn: ['确定']
                            , anim: 4 //动画类型
                        });
                    } else {
                        layer.closeAll();
                        layer.msg("注册成功");
                    }
                }
            });
        });
    });
</script>
</body>
</html>
