<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>table模块快速使用</title>
    <link rel="stylesheet" href="../newlayui/layui/css/layui.css" media="all">
</head>
<body>

<table id="demo" lay-filter="test"></table>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>
<script src="../newlayui/layui/layui.js"></script>
<script>
    layui.use('table', function(){
        var table = layui.table;

        //第一个实例
        table.render({
            elem: '#demo'
            ,url: '${ pageContext.request.contextPath }/cnotice/view' //数据接口
            ,width:1500
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'dnoticeId', title: 'ID', width:150, sort: true, fixed: 'left'}
                ,{field: 'title', title: '结题通知标题', width:300}
                ,{field: 'content', title: '结题通知内容', width:400}
                ,{field: 'creports', title: '结题报告模板', width:200}
                ,{field: 'date', title: '发布时间', width: 177}
                ,{field:'right', title: '操作',toolbar:"#barDemo"}
            ]]
        });

        //监听工具条
        table.on('tool(test)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                parent.layer.open({
                    type: 2,
                    title: '此结题通知内容',
                    shadeClose: false, //点击遮罩关闭
                    area: ['500px', '500px'],
                    content: '${ pageContext.request.contextPath }/page/vlcnotice/'+data.id,

                });
                console.log(document.getElementsByClassName('lyq'));
            } else if(obj.event === 'del'){
                parent.layer.confirm('真的删除此条通知么', function(index){
                    obj.del();
                    parent.layer.close(index);
                    parent.layer.msg("删除成功", {icon: 6});
                    $.post("${ pageContext.request.contextPath }/cnotice/delcnotice/"+data.id,function(data){
                    });
                });
            } else if(obj.event === 'edit'){
                parent.layer.open({
                    type: 2,
                    title: '修改此结题通知',
                    shadeClose: false, //点击遮罩关闭
                    area: ['500px', '500px'],
                    content: '${ pageContext.request.contextPath }/page/veditcnotice/'+data.id
                });
            }
        });

    });
</script>
</body>
</html>