<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/newlayui/layui/css/layui.css"/>
    <script src="${ pageContext.request.contextPath }/newlayui/layui/layui.js"></script>
</head>
<body>
<form action="doExport2" id="download_form" method="post" class="layui-inline" style="display: inline;">
    <input type="hidden" id="page_data" class="layui-inline" name="userList">
    <input type="button" class="layui-btn layui-btn-normal layui-inline" id="export_excel" value="导出数据"/>
</form>
<script>
    layui.use('jquery', function(){
            $=layui.jquery;
        $('#export_excel').on('click',function () {
            var json=[{"id":1,"name":"zhang3","password":12345,"gender":"gender1","nichen":"nichen1","birthday":"birthday1"},{"id":2,"name":"li4","password":12345,"gender":"gender2","nichen":"nichen3","birthday":"birthday4"}];
            $('#page_data').val(JSON.stringify(json));
            $("#download_form").submit();
            //$.ajax();
        });
    });
</script>
</body>
</html>
