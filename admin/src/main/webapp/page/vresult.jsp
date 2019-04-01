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
            ,url: '${ pageContext.request.contextPath }/result/view' //数据接口
            ,width:2500
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'projectSnumber', title: '项目编号', width:150, sort: true, fixed: 'left'}
                ,{field: 'projectTitle', title: '课题名称', width:300}
                ,{field: 'audit', title: '审核状态', width:100}
                ,{field: 'cresults', title: '申报书模板', width:150}
                ,{field: 'date', title: '申请时间', width: 177}
                ,{field:'right', title: '操作',toolbar:"#barDemo"}
            ]]
        });
    });
</script>
</body>
</html>