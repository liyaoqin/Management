<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/newlayui/layui/css/layui.css" media="all">
    <script src="${ pageContext.request.contextPath }/newlayui/layui/layui.js"></script>
</head>
<body>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">项目编号</label>
        <div class="layui-input-block">
            <input type="text" name="projectSnumber" required  lay-verify="required" value="${result.projectSnumber}"
                   autocomplete="off"
                   class="layui-input" disabled>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">课题名称</label>
        <div class="layui-input-block">
            <input type="text" name="projectTitle" required  lay-verify="required" value="${result.projectTitle}"
                   autocomplete="off"
                   class="layui-input" disabled>
        </div>
    </div>


    <button
            class="layui-btn"><a style="color: white;"
                                 href="http://localhost:8080/admin/upload/download?filename=${result.cresults}">点击下载该结题材料
    </a></button>
</form>

<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form,
            $= layui.jquery;

    });
</script>
</body>
</html>
