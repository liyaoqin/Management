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
  <input type="hidden" name="pid" value="${pid}">
  <div class="layui-form-item">
    <label class="layui-form-label">结题通知</label>
    <div class="layui-input-block">
      <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
    </div>
  </div>

 <label class="layui-form-label">结题通知内容</label>
    <div class="layui-input-block">
      <textarea name="content" placeholder="请输入内容" class="layui-textarea"></textarea>
    </div>
  </div>
            <input type="hidden" name="creports" id="myinput" value="">
            <label class="layui-form-label">上传结题报告书模板</label>
            <button type="button" class="layui-btn" id="test1">
                <i class="layui-icon">&#xe67c;</i>点击上传
            </button>
            文件名称: <span id="fileName"></span><br>
            <button type="button" class="layui-btn" id="test9">开始上传</button><br/>
            <p id="demoText"></p>
            <div class="layui-progress layui-progress-big" lay-showpercent="true" lay-filter="uploadProgressBar">
                <div class="layui-progress-bar" lay-percent="0%"></div>
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
layui.use(["layer","form","upload","jquery","element"], function(){
    var form = layui.form,
        $= layui.jquery,
        layer=layui.layer,
        upload = layui.upload,
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
    //监听提交
    form.on('submit(formDemo)', function(data){
        if($("#myinput").val()==""){
            parent.layer.alert('您还未上传文件', {
                icon: 5,
                title: "提示"
            });
            return;
        }
        $.post("${ pageContext.request.contextPath }/cnotice/release", data.field,function(data){
            if (data.status == 200) {
                layer.msg("发布成功", {icon: 6});
                setTimeout(function(){
                   location.reload();
                }, 1000);
            } else {
                layer.msg("发布失败", {icon: 5});
            }
        });
        return false;
    });
});
</script>
	</body>
</html>
