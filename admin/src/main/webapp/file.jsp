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
<div class="layui-upload">
    <button type="button" class="layui-btn" id="test1">
        <i class="layui-icon">&#xe67c;</i>点击上传
    </button>
    文件名称: <span id="fileName"></span><br>
    <button type="button" class="layui-btn" id="test9">开始上传</button>

    <div class="layui-progress layui-progress-big" lay-showpercent="true" lay-filter="uploadProgressBar">
        <div class="layui-progress-bar" lay-percent="0%"></div>
    </div>

    <img src="upload/ycy.jpg" class="layui-upload-img" id="demo1" width="50px" height="50px">
    <p id="demoText"></p>
    <input type="hidden" name="pid" id="myinput" value="">
    <button class="layui-btn" id="tj">立即提交</button>
    <h1>a文件下载</h1>
    <a href="upload/download?filename=支部党员干部应知应会理论知识.docx">点这里下载</a><br/>
</div>
<script>
    layui.use(["layer","form","upload","jquery","element"], function(){
        var layer=layui.layer,
        upload = layui.upload,
            $=layui.jquery,
            element=layui.element;
        //执行实例
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            ,url: '${ pageContext.request.contextPath }/upload/pic' //上传接口
            ,accept:'file'
            ,auto: false
            ,bindAction: '#test9'
            ,choose: function(obj) {
                    obj.preview(function(index, file, result) {
                        $("#fileName").html(file.name);
                    });
                },progress:function(value){//上传进度回调 value进度值
                    element.progress('uploadProgressBar', value+'%')//设置页面进度条
                }
            ,done: function(res){
                if(res.code > 0){
                    return layer.msg('上传失败');
                }
                $("#myinput").val(res.href);
                console.log($("#myinput").val());
                return layer.msg('上传成功');
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });
        $("#tj").click(function () {
            if($("#myinput").val()==""){
                layer.alert('您还未上传文件', {
                    icon: 5,
                    title: "提示"
                });
                return;
            }
        });
    });
</script>
</body>
</html>
