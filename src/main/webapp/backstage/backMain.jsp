<%--
  Created by IntelliJ IDEA.
  User: Infinity233
  Date: 2018/6/5
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<script src="layui/layui.js" charset="utf-8"></script>

<%--<script type="text/javascript" src="jquery-easyui-1.5.4.2/jquery.min.js"></script>--%>
<%--<script type="text/javascript" src="jquery-easyui-1.5.4.2/jquery-1.11.2.min.js"></script>--%>
<link rel="stylesheet" type="text/css" href="common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css" href="common/global.css" media="all">
<link rel="stylesheet" type="text/css" href="css/adminstyle.css" media="all">

<html>
<body>
<div class="layui-layout layui-layout-admin" id="layui_layout">
    <!-- 顶部区域 -->
    <div class="layui-header header header-demo">
        <div class="layui-main">
            <!-- logo区域 -->
            <div class="admin-logo-box">
                <a class="logo" href="http://www.kuxuebao.net" title="logo">后台管理系统</a>
                <div class="larry-side-menu">
                    <i class="fa fa-bars" style="margin-top: 8px;"></i>
                </div>
            </div>
            <!-- 右侧导航 -->
            <ul class="layui-nav larry-header-item">
                <li class="layui-nav-item" disabled="true">
                    账户名： Infinity233
                </li>
                <li class="layui-nav-item">
                    <a href=""><i class="iconfont icon-exit"></i>退出</a>
                </li>
            </ul>
        </div>
    </div>
    <!-- 左侧侧边导航开始 -->
    <div class="layui-side layui-side-bg layui-larry-side" id="larry-side">
        <div class="layui-side-scroll" id="larry-nav-side" lay-filter="side">

            <!-- 左侧菜单 -->
            <ul class="layui-nav layui-nav-tree">
                <li class="layui-nav-item layui-this">
                    <a href="javascript:;" data-url="main.html">
                        <i class="iconfont icon-home1" data-icon='icon-home1'></i>
                        <span>后台首页</span>
                    </a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="iconfont icon-jiaoseguanli"></i>
                        <span>用户管理</span>
                        <em class="layui-nav-more"></em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" data-url="userManage.jsp">
                                <i class="iconfont icon-geren1" data-icon='icon-geren1'></i>
                                <span>用户管理</span>
                            </a>
                        </dd>
                    </dl>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" data-url="managerManage.jsp">
                                <i class="iconfont icon-geren1" data-icon='icon-geren2'></i>
                                <span>管理员管理</span>
                            </a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="iconfont icon-jiaoseguanli"></i>
                        <span>剧目管理</span>
                        <em class="layui-nav-more"></em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" data-url="FilmManage.jsp">
                                <i class="iconfont icon-geren1" data-icon='icon-geren1'></i>
                                <span>剧目管理</span>
                            </a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="performManage.jsp">
                                <i class="iconfont icon-iconfuzhi01" data-icon='icon-iconfuzhi01'></i>
                                <span>场次管理</span>
                            </a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="iconfont icon-jiaoseguanli"></i>
                        <span>演出厅信息管理</span>
                        <em class="layui-nav-more"></em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" data-url="studioManage.jsp">
                                <i class="iconfont icon-geren1" data-icon='icon-geren1'></i>
                                <span>演出厅信息管理</span>
                            </a>
                        </dd>
                    </dl>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" data-url="seatManage.jsp">
                                <i class="iconfont icon-geren1" data-icon='icon-geren2'></i>
                                <span>座位管理</span>
                            </a>
                        </dd>

                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="iconfont icon-jiaoseguanli"></i>
                        <span>售票信息管理</span>
                        <em class="layui-nav-more"></em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" data-url="newTicketManage.jsp">
                                <i class="iconfont icon-iconfuzhi01" data-icon='icon-iconfuzhi01'></i>
                                <span>售票信息管理</span>
                            </a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="newTicketUserManage.jsp">
                                <i class="iconfont icon-piliangicon" data-icon='icon-piliangicon'></i>
                                <span>用户票务管理</span>
                            </a>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <!-- 左侧侧边导航结束 -->
    <!-- 右侧主体内容 -->
    <div class="layui-body" id="larry-body" style="bottom: 0;border-left: solid 2px #2299ee;">
        <div class="layui-tab layui-tab-card larry-tab-box" id="larry-tab" lay-filter="demo" lay-allowclose="true">
            <div class="go-left key-press pressKey" id="titleLeft" title="滚动至最右侧"><i
                    class="larry-icon larry-weibiaoti6-copy"></i></div>
            <ul class="layui-tab-title">
                <li class="layui-this" id="admin-home"><i class="iconfont icon-diannao1"></i><em>后台首页</em></li>
            </ul>
            <div class="go-right key-press pressKey" id="titleRight" title="滚动至最左侧"><i
                    class="larry-icon larry-right"></i></div>
            <div class="layui-tab-content" style="min-height: 150px; ">
                <div class="layui-tab-item layui-show">
                    <iframe class="larry-iframe" data-id='0' src="main.html"></iframe>
                </div>
            </div>
        </div>
    </div>
    <!-- 底部区域 -->
    <div class="layui-footer layui-larry-foot" id="larry-footer">
        <div class="layui-mian">
            <p class="p-admin">
                <span>2018 &copy;</span>
                Infinity233 版权所有
            </p>
        </div>
    </div>
</div>
<!-- 加载js文件-->
<script type="text/javascript" src="common/layui/layui.js"></script>
<script type="text/javascript" src="js/larry.js"></script>
<script type="text/javascript" src="js/index.js"></script>

</body>
</html>
