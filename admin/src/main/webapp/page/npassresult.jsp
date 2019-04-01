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
    <input type="hidden" name="id" value="${id}">
    <textarea name="audit" placeholder="请输入内容" class="layui-textarea"></textarea>

    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script>
    //Demo
    layui.use(["layer","form","jquery","element"], function(){
        var form = layui.form,
            $=layui.jquery,
            layer=layui.layer,
            element=layui.element;

        //监听提交
        form.on('submit(formDemo)', function(data){
            $.post("${ pageContext.request.contextPath }/result/npassresult",data.field,function(msg){
                if(msg.status==200){
                    layer.msg("操作成功", {icon: 6});
                    setTimeout(function(){
                        window.parent.location.reload();
                    }, 1000);
                }else{
                    layer.msg("操作失败", {icon: 5});
                }
            });
            return false;
        });
    });
</script>
</body>
</html>
