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
		<form class="layui-form" action="">
     <input type="hidden" name="pid" value="${pid}">
     <input type="hidden" name="userId" value="${userid}">
	<div class="layui-form-item">
    <label class="layui-form-label">课题类别</label>
    <div class="layui-input-block">
      <select name="scategory" lay-verify="required">
        <option value=""></option>
        <option value="0">哲学社会科学类社会调查报告及学术论文</option>
        <option value="1">自然科学类学术论文</option>
        <option value="2">发明制作类作品</option>
        <option value="3">创作成果类作品</option>
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">学科类别</label>
    <div class="layui-input-block">
      <select name="dcategory" lay-verify="required">
        <option value=""></option>
        <option value="0">机械与控制</option>
        <option value="1">信息技术</option>
        <option value="2">能源化工</option>
        <option value="3">生命科学</option>
        <option value="0">数理</option>    
      </select>
    </div>
  </div>
		
  <div class="layui-form-item">
    <label class="layui-form-label">课题名称</label>
    <div class="layui-input-block">
      <input type="text" name="title" required  lay-verify="required" placeholder="请输入课题类别" autocomplete="off"
             class="layui-input">
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label">负责人</label>
    <div class="layui-input-block">
      <input type="text" name="head" required  lay-verify="required" placeholder="请输入负责人姓名（如:张三）" autocomplete="off" class="layui-input">
    </div>
  </div>

 <div class="layui-form-item">
    <label class="layui-form-label">参与人员1</label>
    <div class="layui-input-block">
      <input type="text" name="participants" required  lay-verify="required"
             placeholder="请输入参与人员1姓名（格式如:张三）" autocomplete="off" class="layui-input">
    </div>
  </div>
            <div class="layui-form-item">
                <label class="layui-form-label">其他参与人员(非必填)</label>
                <div class="layui-input-block">
                    <input type="text" name="oparticipants"
                           placeholder="请输入其他参与人员姓名（格式如:张三,李四,王五,...,陈七）" autocomplete="off" class="layui-input">
                </div>
            </div>

 <div class="layui-form-item">
    <label class="layui-form-label">年级</label>
    <div class="layui-input-block">
      <input type="text" name="grade" required  lay-verify="required" placeholder="请输入年级（格式如:软件学院2015级）" autocomplete="off" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">经费预算(单位:元)</label>
    <div class="layui-input-block">
      <input type="text" name="budget" required  lay-verify="required" placeholder="请输入经费预算（如:3000）" autocomplete="off"
             class="layui-input">
    </div>
  </div>

            <input type="hidden" name="pdeclaration" id="myinput" value="">
            <label class="layui-form-label">上传申报书模板</label>
            <button type="button" class="layui-btn" id="test1">
                <i class="layui-icon">&#xe67c;</i>点击上传
            </button>
            文件名称: <span id="fileName"></span><br>
            <button type="button" class="layui-btn" id="test9">上传项目申报书(请下载申报书模板填写好后上传)</button><br/>
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
    $ = layui.jquery,
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
      $.ajax({
          url: "${ pageContext.request.contextPath }/project/declare",
          type: "POST",
          data:data.field,
          success: function(msg){
              if(msg.status==200){
                  layer.msg("提交成功，待审核", {icon: 6});
                  setTimeout(function(){
                      window.parent.location.reload();
                  }, 1000);
              }else{
                  layer.msg("提交失败", {icon: 5});
              }
          }
      });
      return false;
  });
});
</script>
	</body>
</html>
