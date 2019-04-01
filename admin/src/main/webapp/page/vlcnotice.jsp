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
        <label class="layui-form-label">结题通知标题</label>
        <div class="layui-input-block">
            <input id="lyq" type="text" name="title" required  lay-verify="required" value="${title}" autocomplete="off"
                   class="layui-input lyq" disabled />
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">结题通知内容</label>
        <div class="layui-input-block">
            <textarea name="content" class="layui-textarea" disabled>${content}</textarea>
        </div>
    </div>
    <button
            class="layui-btn"><a style="color: white;"
                                 href="http://localhost:8080/admin/upload/download?filename=${creports}">点击下载该通知申报书模板
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
