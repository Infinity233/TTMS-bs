<%--
  Created by IntelliJ IDEA.
  Film: Infinity233
  Date: 2018/6/6
  Time: 0:36
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
            <input type="text" value="" id="search_filmname" placeholder="请输入关键字" class="layui-input search_input">
        </div>
        <a class="layui-btn search_btn" data-type="reload">查询</a>
    </div>
    <div class="layui-inline">
        <a class="layui-btn linksAdd_btn" style="background-color:#5FB878" data-type="add_film">添加电影</a>
    </div>
    <div class="layui-inline">
        <a class="layui-btn layui-btn-danger batchDel" data-type="delete_films">批量删除</a>
    </div>
    <%--<div class="layui-inline">--%>
    <%--<div class="layui-form-mid layui-word-aux">本页面刷新后除新添加的链接外所有操作无效，关闭页面所有数据重置</div>--%>
    <%--</div>--%>
</blockquote>

<table class="layui-table"
       lay-data="{cellMinWidth: 80 , height: 'full-87', url:'/film/selectAll.do', page:true, id:'idTest'}"
       lay-filter="demo">
    <thead>
    <tr>
        <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
        <th lay-data="{field:'id', sort: true, fixed: true, width:60}">ID</th>
        <th lay-data="{field:'name'}">电影名</th>
        <th lay-data="{field:'cover', event: 'showImage', templet: '<div><img alt=&quot;暂无图片&quot; src=&quot;../{{d.cover}}&quot; style=&quot;height:30px;width:48px;line-height:48px;&quot;></div>'}">
            海报
        </th>
        <th lay-data="{field:'filmTypes', templet:function(d){return getFilmType(d);}}">电影类型</th>
        <th lay-data="{field:'duration'}">时长</th>
        <th lay-data="{field:'employees', templet:function(d){return getActer(d);}}">演员表</th>
        <th lay-data="{field:'director', templet: '<div>{{d.director.name}}</div>'}">导演</th>
        <th lay-data="{field:'score'}">得分</th>
        <th lay-data="{field:'clickHit'}">点击次数</th>
        <th lay-data="{field:'publishDate'}">上映日期</th>
        <th lay-data="{field:'box'}">票房</th>
        <th lay-data="{fixed: '', align:'center', toolbar: '#barDemo'}"></th>
    </tr>
    </thead>
</table>

<script>

    function getActer(d) {

        var acterList = d.employees;
        var returnStr = "";
        for (var i = 0; i < 2 && i < acterList.length; ++i) {
            returnStr += acterList[i].name + "、";
        }

        if (returnStr.length > 0) {
            returnStr = returnStr.slice(0, -1);
        }
        return returnStr;
    }

    function getFilmType(d) {

        var typeList = d.filmTypes;
        var returnStr = "";
        for (var i = 0; typeList.length >= 1 && i < 1; ++i) {
            returnStr += typeList[i].typeName + "、";
        }

        if (returnStr.length > 0) {
            returnStr = returnStr.slice(0, -1);
        }
        return returnStr;
    }

</script>

<form class="layui-form layui-form-pane" lay-filter="filmForm" id="filmForm"
      enctype="multipart/form-data;charset=utf-8;" hidden>

    <input type="hidden" name="id" id="id">

    <div class="layui-form-item" style="margin-top: 20px">
        <label class="layui-form-label">电影名</label>
        <div class="layui-input-block">
            <input type="text" name="filmname" id="filmname" lay-verify="required" placeholder="请输入电影名"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">电影类型</label>
        <div class="layui-input-block">
            <select name="typeName" id="typeName">
                <option value="0"></option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">海报</label>
        <div class="layui-input-block">
            <input type="file" name="cover" id="cover" lay-verify="required" autocomplete="off">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">时长</label>
        <div class="layui-input-block">
            <input type="text" name="duration" id="duration" lay-verify="required" placeholder="请输入电影时长"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">主演</label>
        <div class="layui-input-block">
            <input type="text" name="employees" id="employees" lay-verify="required" placeholder="请输入主演名"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">导演</label>
        <div class="layui-input-block">
            <input type="text" name="director" id="director" lay-verify="required" placeholder="请输入导演名"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">评分</label>
        <div class="layui-input-block">
            <input type="text" name="score" id="score" lay-verify="required" placeholder="请输入评分" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">上映日期</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input" name="publishDate" id="publishDate" lay-verify="required"/>
            <%--<input type="text" name="publishDate" id="publishDate" lay-verify="required" class="layui-input">--%>
        </div>
    </div>

    <div class="layui-form-item" style="text-align:center">
        <%--<button class="layui-btn" id="imageAction" lay-submit lay-filter="submit">提交</button>--%>
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
        var table = layui.table
            , $ = layui.$
            , form = layui.form
            , layer = layui.layer
            , laydate = layui.laydate;

        // 修改
        $("#imageAction").click(function () {

            var url = "/film/update.do";

            //add
            if ($('#id').val() == null || $('#id').val() == "") {
                url = "/film/add.do";
            }
            var formData = new FormData($('#filmForm')[0]);
            $.ajax({
                type: "post",
                url: url,
                data: formData,
                // data: {"filmname":"qqq", duration:90},
                processData: false,
                contentType: false,
                dataType: "json",
                async: true,
                error: function (request) {
                    layer.confirm('修2改失败', {
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

        function deleteFilms(ids) {
            $.ajax({
                type: "post",
                url: "/film/delete.do",
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
                    deleteFilms(data.id);
                    // layer.close(index);
                });
            } else if (obj.event === 'edit') {
                // layer.alert('编辑行：<br>'+ JSON.stringify(data));
                loadFilmForm();
                console.log(data);
                layer.open({
                    type: 1
                    , title: '编辑数据'
                    , content: $("#filmForm")
                    , zIndex: layer.zIndex
                });

                $("#id").val(data.id);
                $("#filmname").val(data.name);
                $("#duration").val(data.duration);
                $("#employees").val(getActer(data));
                $("#director").val(data.director.name);
                $("#score").val(data.score);
            } else if (obj.event === 'showImage') {
                layer.open({
                    type: 1,
                    area: ["601px", "792px"],
                    content: "<img src=../" + data.cover + " style=\"width:601px;height:792px\">"
                });
            }
        });

        function loadFilmForm() {
            var typeNameSelect = $('#typeName');
            $.ajax({
                type: "post",
                url: "/filmType/selectAll.do",
                dataType: "json",
                // async: true,
                error: function (request) {
                    console.log(request);
                    layer.confirm('获取电影类型失败', {
                        skin: 'layui-layer-molv'
                        , title: '系统提示'
                        , btn: ['确定']
                        , anim: 4 //动画类型
                    });
                },
                success: function (data) {
                    var typeList = data.filmTypeList;
                    typeNameSelect.empty();
                    typeNameSelect.append("<option value=\"0\"></option>");
                    for (var i = 0; i < typeList.length; ++i) {
                        typeNameSelect.append("<option value=" + (i + 1) + ">" + typeList[i].typeName + "</option>");
                    }
                    renderForm();
                }
            });

            laydate.render({
                elem: '#publishDate' //指定元素
            });
        }

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
            , delete_films: function () {
                var checkStatus = table.checkStatus('idTest')
                    , data = checkStatus.data;

                var resStr = data[0].id.toString();
                for (var i = 1; i < data.length; ++i) {
                    resStr += "," + data[i].id;

                }
                deleteFilms(resStr);
            }
            , add_film: function () {

                $('#reset').trigger("click");
                loadFilmForm();

                layer.open({
                    type: 1
                    , title: '添加数据'
                    , content: $("#filmForm")
                    , zIndex: layer.zIndex
                });
            }
            , reload: function () {
                table.reload('idTest', {
                    url: '/film/selectByFilmname.do'
                    , where: {
                        filmname: $("#search_filmname").val()
                    }
                });
            }
        };

        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        function renderForm() {
            layui.use('form', function () {
                var form = layui.form;
                form.render();
            });
        }

    });
</script>

</body>
</html>
