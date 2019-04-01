<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>table模块快速使用</title>
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/newlayui/layui/css/layui.css" media="all">
</head>
<body>
总共有${fn:length(result.data)}人申报该通知项目

<table id="demo" lay-filter="test"></table>
<script src="${ pageContext.request.contextPath }/newlayui/layui/layui.js"></script>

<script>
    layui.use('table', function(){
        var table = layui.table,
            $ = layui.jquery;

        //第一个实例
        table.render({
            elem: '#demo'
            ,url:'${ pageContext.request.contextPath }/dnotice/detaildnotice/'+${id} //数据接口
            ,width:1500
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'snumber', title: '项目编号', width:150, sort: true, fixed: 'left'}
                ,{field: 'title', title: '课题名称', width:300}
                ,{field: 'head', title: '负责人', width:100}
                ,{field: 'participants', title: '参与人员1', width:300}
            ]]
        });
    });
</script>
</body>
</html>