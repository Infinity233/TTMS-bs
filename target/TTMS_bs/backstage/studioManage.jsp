<%--
  Created by IntelliJ IDEA.
  User: Infinity233
  Date: 2018/6/5
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <link rel="stylesheet" href="../layui-v2.3.0/layui/css/layui.css" media="all">
    <script src="../layui-v2.3.0/layui/layui.js"></script>

    <link rel="stylesheet" href="../css/font_eolqem241z66flxr.css" media="all"/>
    <link rel="stylesheet" href="../css/news.css" media="all"/>
</head>
<body>

<blockquote class="layui-elem-quote demoTable">
    <%--<div class="layui-inline">--%>
        <%--<div class="layui-input-inline">--%>
            <%--<input type="text" value="" id="searth_studioname" placeholder="请输入关键字" class="layui-input search_input">--%>
        <%--</div>--%>
        <%--<a class="layui-btn search_btn" data-type="reload">查询</a>--%>
    <%--</div>--%>
    <div class="layui-inline">
        <a class="layui-btn linksAdd_btn" style="background-color:#5FB878" data-type="add_studio">添加演出厅</a>
    </div>
    <div class="layui-inline">
        <a class="layui-btn layui-btn-danger batchDel" data-type="delete_studios">批量删除</a>
    </div>
    <%--<div class="layui-inline">--%>
    <%--<div class="layui-form-mid layui-word-aux">本页面刷新后除新添加的链接外所有操作无效，关闭页面所有数据重置</div>--%>
    <%--</div>--%>
</blockquote>

<table class="layui-table"
       lay-data="{cellMinWidth: 80 , height: 'full-87', url:'/studio/selectAll.do', page:true, id:'idTest'}"
       lay-filter="demo">
    <thead>
    <tr>
        <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
        <th lay-data="{field:'id', sort: true, fixed: true}">ID</th>
        <th lay-data="{field:'name'}">演出厅名</th>
        <th lay-data="{field:'length'}">演出厅长</th>
        <th lay-data="{field:'width'}">演出厅宽</th>
        <th lay-data="{fixed: 'right', align:'center', toolbar: '#barDemo'}"></th>
    </tr>
    </thead>
</table>

<form class="layui-form layui-form-pane" lay-filter="studioForm" id="studioForm" hidden>

    <input type="hidden" name="id" id="id">

    <div class="layui-form-item" style="margin-top: 20px">
        <label class="layui-form-label">演出厅名</label>
        <div class="layui-input-block">
            <input type="text" name="name" id="name" lay-verify="required" placeholder="请输入演出厅名"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">演出厅长</label>
        <div class="layui-input-block">
            <input type="text" name="length" id="length" lay-verify="required" placeholder="请输入演出厅长"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">演出厅宽</label>
        <div class="layui-input-block">
            <input type="text" name="width" id="width" lay-verify="required" placeholder="请输入演出厅宽"
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
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="seat_detail">查看座位</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>

    layui.use('table', function () {
        var table = layui.table;
        var $ = layui.$;
        var form = layui.form
            , layer = layui.layer;

        $("#reset").click(function () {

            $("#name").val("");
            $("#length").val("");
            $("#width").val("");
        });



        // 修改
        $("#imageAction").click(function () {
            $.ajax({
                type: "post",
                url: "/studio/update.do",
                data: $('#studioForm').serialize(),
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
                        layer.msg("您已成功修改一条数据");
                        table.reload('idTest',{});
                    }
                }
            });

            layer.closeAll();

        });

        function deleteUsers(ids) {
            $.ajax({
                type: "post",
                url: "/studio/delete.do",
                data: { delIds: ids },
                async: true,
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
                    table.reload('idTest',{});
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
                layer.open({
                    type: 1
                    , title: '编辑数据'
                    , area: ['500px', '350px']
                    // ,shade: 0
                    // ,maxmin: true
                    , content: $("#studioForm")
                    //将数据表格不隐藏显示
                    // ,btn: ['关闭']
                    // ,btn1: function(){
                    //     layer.closeAll();
                    // }
                    , zIndex: layer.zIndex
                });

                $("#id").val(data.id);
                $("#name").val(data.name);
                $("#length").val(data.length);
                $("#width").val(data.width);
            } else if (obj.event === 'seat_detail') {

                //查看座位图
                layer.open({
                    type: 2,
                    shade: false,
                    area: ['790px', '580px'],
                    maxmin: true,
                    content: '/backstage/seat.html?studioId='+data.id,
                    zIndex: layer.zIndex, //重点1
                    success: function(layero){
                        layer.setTop(layero); //重点2
                    }
                });


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
            , delete_studios: function() {
                var checkStatus = table.checkStatus('idTest')
                    , data = checkStatus.data;

                var resStr = data[0].id.toString();
                for(var i=1;i<data.length;++i) {
                    resStr+=","+data[i].id;

                }
                deleteUsers(resStr);
            }
            , add_studio: function() {

                $("#id").val("");
                $('#reset').trigger("click");
                layer.open({
                    type: 1
                    , title: '添加演出厅'
                    , area: ['500px', '350px']
                    // ,shade: 0
                    // ,maxmin: true
                    , content: $("#studioForm")
                    , zIndex: layer.zIndex
                });

            }
            , reload: function() {
                table.reload('idTest', {
                    url: '/studio/selectByStudioName.do'
                    ,where: {
                        studioname:$("#searth_studioname").val()
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
