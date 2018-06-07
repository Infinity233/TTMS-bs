<%--
  Created by InrealnameliJ IDEA.
  User: Infinity233
  Date: 2018/6/7
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <link rel="stylesheet" href="../layui-v2.3.0/layui/css/layui.css" media="all">
    <script src="../layui-v2.3.0/layui/layui.js"></script>

    <link rel="stylesheet" href="../layui-v2.3.0/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="../css/font_eolqem241z66flxr.css" media="all"/>
    <link rel="stylesheet" href="../css/news.css" media="all"/>
</head>
<body>

<blockquote class="layui-elem-quote demoTable">
    <div class="layui-inline">
        <div class="layui-input-inline">
            <input type="text" value="" id="search_username" placeholder="请输入关键字" class="layui-input search_input">
        </div>
        <a class="layui-btn search_btn" data-type="reload">查询</a>
    </div>
    <div class="layui-inline">
        <a class="layui-btn linksAdd_btn" style="background-color:#5FB878" data-type="add_manager">添加管理员</a>
    </div>
    <div class="layui-inline">
        <a class="layui-btn layui-btn-danger batchDel" data-type="delete_managers">批量删除</a>
    </div>
    <%--<div class="layui-inline">--%>
    <%--<div class="layui-form-mid layui-word-aux">本页面刷新后除新添加的链接外所有操作无效，关闭页面所有数据重置</div>--%>
    <%--</div>--%>
</blockquote>

<table class="layui-table"
       lay-data="{cellMinWidth: 80 , height: 'full-87', url:'/managerr/selectAll.do', page:true, id:'idTest'}"
       lay-filter="demo">
    <thead>
    <tr>
        <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
        <th lay-data="{field:'id', sort: true, fixed: true}">ID</th>
        <th lay-data="{field:'realname'}">管理员名</th>
        <th lay-data="{field:'username'}">账户</th>
        <th lay-data="{field:'password'}">密码</th>
        <th lay-data="{fixed: 'right', align:'center', toolbar: '#barDemo'}"></th>
    </tr>
    </thead>
</table>

<form class="layui-form layui-form-pane" lay-filter="managerForm" id="managerForm" hidden>

    <input type="hidden" name="id" id="id">

    <div class="layui-form-item" style="margin-top: 20px">
        <label class="layui-form-label">账号</label>
        <div class="layui-input-block">
            <input type="text" name="username" id="username" lay-verify="required" placeholder="请输入账号"
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
        <label class="layui-form-label">真实姓名</label>
        <div class="layui-input-block">
            <input type="text" name="realname" id="realname" lay-verify="required" placeholder="请输入电话"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item" style="text-align:center">
        <%--<button class="layui-btn" id="imageAction" lay-submit lay-filter="submit">提交</button>--%>
        <input typ="button" class="layui-btn" id="imageAction" value="提交" style="width: 68px;"/>
        <button type="button" class="layui-btn layui-btn-primary" id="reset">重置</button>
    </div>
</form>

<script type="text/html" id="barDemo">
    <%--<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>--%>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>

    layui.use('table', function () {
        var table = layui.table;
        var $ = layui.$;
        var form = layui.form
            , layer = layui.layer;

        $("#reset").click(function (flag) {

            if ($("#username").attr("readOnly") == null) {
                $("#username").val("");
            }

            $("#password").val("");
            $("#realname").val("");
        });


        // 修改
        $("#imageAction").click(function () {
            $.ajax({
                type: "post",
                url: "/managerr/update.do",
                data: $('#managerForm').serialize(),
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
                    if (data.errorMsg) {
                        layer.confirm(data.errorMsg, {
                            skin: 'layui-layer-molv'
                            , title: "修改失败"
                            , btn: ['确定']
                            , anim: 4 //动画类型
                        });
                    } else {
                        layer.msg("您已成功修改一条数据");
                        table.reload('idTest', {});
                    }
                }
            });
        });

        function deleteUsers(ids) {
            $.ajax({
                type: "post",
                url: "/managerr/delete.do",
                data: {delIds: ids},
                async: true,
                // processData: false,   //当设置为true的时候,jquery ajax 提交的时候不会序列化 data，而是直接使用data
                error: function (request) {
                    layer.confirm('删除失败', {
                        skin: 'layui-layer-molv'
                        , title: '系统提示'
                        , btn: ['确定']
                        , anim: 4 //动画类型
                    });
                },
                success: function (data) {
                    layer.msg("删除成功");
                    table.reload('idTest', {});
                }
            });
        }

        //监听表格复选框选择
        // table.on('checkbox(demo)', function (obj) {
        //     console.log(obj)
        // });

        //监听工具条
        table.on('tool(demo)', function (obj) {
            var data = obj.data;

            if (obj.event === 'del') {
                layer.confirm('真的删除么', function (index) {
                    // obj.del();
                    deleteUsers(data.id);
                    // layer.close(index);
                });
            } else if (obj.event === 'edit') {
                // layer.alert('编辑行：<br>'+ JSON.stringify(data));
                $("#username").attr("readOnly", "readonly");
                layer.open({
                    type: 1
                    , title: '编辑数据'
                    , area: ['500px', '270px']
                    // ,shade: 0
                    // ,maxmin: true
                    , content: $("#managerForm")
                    //将数据表格不隐藏显示
                    // ,btn: ['关闭']
                    // ,btn1: function(){
                    //     layer.closeAll();
                    // }
                    , zIndex: layer.zIndex
                });

                $("#id").val(data.id);
                $("#username").val(data.username);
                $("#password").val(data.password);
                $("#realname").val(data.realname);
            }
        });

        var $ = layui.$, active = {
            getCheckData: function () { //获取选中数据
                var checkStatus = table.checkStatus('idTest')
                    , data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            }
            , getCheckLength: function () { //获取选中数目
                var checkStatus = table.checkStatus('idTest')
                    , data = checkStatus.data;
                layer.msg('选中了：' + data.length + ' 个');
            }
            , isAll: function () { //验证是否全选
                var checkStatus = table.checkStatus('idTest');
                layer.msg(checkStatus.isAll ? '全选' : '未全选')
            }
            , delete_managers: function () {
                var checkStatus = table.checkStatus('idTest')
                    , data = checkStatus.data;

                var resStr = data[0].id.toString();
                for (var i = 1; i < data.length; ++i) {
                    resStr += "," + data[i].id;

                }
                deleteUsers(resStr);
            }
            , add_manager: function () {

                $("#id").val("");
                $("#username").val("");
                $("#username").removeAttr("readOnly");
                $('#reset').trigger("click");
                layer.open({
                    type: 1
                    , title: '添加数据'
                    , area: ['500px', '270px']
                    // ,shade: 0
                    // ,maxmin: true
                    , content: $("#managerForm")
                    , zIndex: layer.zIndex
                });

            }
            , reload: function () {
                alert($("#search_username").val());
                table.reload('idTest', {
                    url: '/managerr/mohuSelect.do'
                    , where: {
                        username: $("#search_username").val()
                    } //设定异步数据接口的额外参数
                    //,height: 300
                });
            }
        };

        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

    });
</script>

</body>
</html>