<%--
  Created by IntelliJ IDEA.
  perform: Infinity233
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

    <link rel="stylesheet" href="../layui-v2.3.0/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="../css/font_eolqem241z66flxr.css" media="all"/>
    <link rel="stylesheet" href="../css/news.css" media="all"/>
</head>
<body>

<blockquote class="layui-elem-quote demoTable">
    <div class="layui-inline">
        <div class="layui-input-inline">
            <input type="text" value="" id="search_performName" placeholder="请输入关键字" class="layui-input search_input">
        </div>
        <a class="layui-btn search_btn" data-type="reload">查询</a>
    </div>
    <div class="layui-inline">
        <a class="layui-btn linksAdd_btn" style="background-color:#5FB878" data-type="add_perform">添加用户</a>
    </div>
    <div class="layui-inline">
        <a class="layui-btn layui-btn-danger batchDel" data-type="delete_performs">批量删除</a>
    </div>
    <%--<div class="layui-inline">--%>
    <%--<div class="layui-form-mid layui-word-aux">本页面刷新后除新添加的链接外所有操作无效，关闭页面所有数据重置</div>--%>
    <%--</div>--%>
</blockquote>

<table class="layui-table"
       lay-data="{cellMinWidth: 80 , height: 'full-87', url:'/perform/selectAll.do', page:true, id:'idTest'}"
       lay-filter="demo">
    <thead>
    <tr>
        <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
        <th lay-data="{field:'id', width:80, sort: true, fixed: true}">ID</th>
        <th lay-data="{field:'film', templet: '<div>{{d.film.name}}</div>'}'}">电影名</th>
        <th lay-data="{field:'studio', templet: '<div>{{d.studio.name}}</div>'}">演出厅名</th>
        <th lay-data="{field:'price'}">票价</th>
        <th lay-data="{field:'startTime', templet:function(d){return formatTime(d);}}">开始时间</th>
        <th lay-data="{field:'sold'}">已售（张）</th>
        <th lay-data="{fixed: 'right', align:'center', toolbar: '#barDemo'}"></th>
    </tr>
    </thead>
</table>

<script>
    function formatTime(d) {
        var start = d.startTime;
        var end = d.endTime;

        if (end != null) {
            end = end.substring(end.indexOf(' ')+1);
        }
        console.log(start + " ~ " + end);
        return start + "~" + end;
    }
</script>

<form class="layui-form layui-form-pane" lay-filter="performForm" id="performForm" hidden>

    <input type="hidden" name="id" id="id">

    <div class="layui-form-item" style="margin-top: 20px">
        <label class="layui-form-label">电影名</label>
        <div class="layui-input-block">
            <select name="filmId" id="filmId">
                <option value="0"></option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">演出厅名</label>
        <div class="layui-input-block">
            <select name="studioId" id="studioId">
                <option value="0"></option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">票价</label>
        <div class="layui-input-block">
            <input type="text" name="price" id="price" lay-verify="required" placeholder="请输入票价"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">日期</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input" name="publishDate" id="publishDate" lay-verify="required"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">时刻</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input" name="startTime" id="startTime" lay-verify="required"/>
        </div>
    </div>

    <div class="layui-form-item" style="text-align:center">
        <input typ="button" class="layui-btn" id="imageAction" value="提交" style="width: 68px;"/>
        <button type="reset" class="layui-btn layui-btn-primary" id="reset">重置</button>
    </div>
</form>

<script type="text/html" id="barDemo">
    <%--<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>--%>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>

    layui.use(['laydate', 'table'], function () {
        var table = layui.table;
        var $ = layui.$;
        var form = layui.form
            , layer = layui.layer
            , laydate = layui.laydate;

        laydate.render({
            elem: '#publishDate'
        });
        laydate.render({
            elem: '#startTime'
            , type: 'time'
            , format: 'HH:mm'
            , range: true
        });

        function loadForm() {
            var filmSelect = $('#filmId');
            var studioSelect = $('#studioId');
            $.ajax({
                type: "post",
                url: "/film/selectHotFilm.do",
                dataType: "json",
                // async: true,
                error: function (request) {
                    console.log(request);
                    layer.confirm('获取热门电影失败', {
                        skin: 'layui-layer-molv'
                        , title: '系统提示'
                        , btn: ['确定']
                        , anim: 4 //动画类型
                    });
                },
                success: function (data) {
                    var filmList = data.data;
                    console.log(filmList+"...");
                    filmSelect.empty();
                    filmSelect.append("<option value=\"0\"></option>");
                    for (var i = 0; i < filmList.length; ++i) {
                        filmSelect.append("<option value=" + filmList[i].id + ">" + filmList[i].name + "</option>");
                    }
                }
            });

            $.ajax({
                type: "post",
                url: "/studio/selectAll.do",
                dataType: "json",
                // async: true,
                error: function (request) {
                    console.log(request);
                    layer.confirm('获取演出厅失败', {
                        skin: 'layui-layer-molv'
                        , title: '系统提示'
                        , btn: ['确定']
                        , anim: 4 //动画类型
                    });
                },
                success: function (data) {
                    var studioList = data.data;
                    studioSelect.empty();
                    studioSelect.append("<option value=\"0\"></option>");
                    for (var i = 0; i < studioList.length; ++i) {
                        studioSelect.append("<option value=" + studioList[i].id + ">" + studioList[i].name + "</option>");
                    }
                }
            });

            renderForm();
        }
        function renderForm() {
            layui.use('form', function () {
                var form = layui.form;
                form.render();
            });
        }
        // 修改
        $("#imageAction").click(function () {

            var url = "/perform/update.do";

            //add
            if ($('#id').val() == null || $('#id').val() == "") {
                url = "/perform/add.do";
            }

            $.ajax({
                type: "post",
                url: url,
                data: $('#performForm').serialize(),
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

        function deleteperforms(ids) {
            $.ajax({
                type: "post",
                url: "/perform/delete.do",
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
                    deleteperforms(data.id);
                    // layer.close(index);
                });
            } else if (obj.event === 'edit') {
                // layer.alert('编辑行：<br>'+ JSON.stringify(data));
                loadForm();
                $('#reset').trigger("click");

                layer.open({
                    type: 1
                    , title: '编辑数据'
                    , content: $("#performForm")
                    , zIndex: layer.zIndex
                });

                var start = data.startTime;
                var end = data.endTime;

                $("#id").val(data.id);
                $("#publishDate").val(start.substring(0,start.indexOf(' ')));
                $("#price").val(data.price);
                $("#startTime").val(start.substring(start.indexOf(' ')+1)+" - "+end.substring(end.indexOf(' ')+1))
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
            , delete_performs: function () {
                var checkStatus = table.checkStatus('idTest')
                    , data = checkStatus.data;

                var resStr = data[0].id.toString();
                for (var i = 1; i < data.length; ++i) {
                    resStr += "," + data[i].id;

                }
                deleteperforms(resStr);
            }
            , add_perform: function () {

                loadForm();

                $('#reset').trigger("click");
                layer.open({
                    type: 1
                    , title: '添加数据'
                    // ,shade: 0
                    // ,maxmin: true
                    , content: $("#performForm")
                    , zIndex: layer.zIndex
                });

            }
            , reload: function () {
                table.reload('idTest', {
                    url: '/perform/selectByperformname.do'
                    , where: {
                        performname: $("#search_performName").val()
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
