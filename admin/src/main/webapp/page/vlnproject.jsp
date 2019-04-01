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

    <div class="layui-form-item">
        <label class="layui-form-label">课题类别</label>
        <div class="layui-input-block">
            <select name="scategory" lay-verify="required" disabled>
                <option value=""></option>
                <option value="0" <c:if test="${project.scategory eq '哲学社会科学类社会调查报告及学术论文'}">selected</c:if>>哲学社会科学类社会调查报告及学术论文</option>
                <option value="1" <c:if test="${project.scategory eq '自然科学类学术论文'}">selected</c:if>>自然科学类学术论文</option>
                <option value="2" <c:if test="${project.scategory eq '发明制作类作品'}">selected</c:if>>发明制作类作品</option>
                <option value="3" <c:if test="${project.scategory eq '创作成果类作品'}">selected</c:if>>创作成果类作品</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">课题类别</label>
        <div class="layui-input-block">
            <select name="dcategory" lay-verify="required" disabled>
                <option value=""></option>
                <option value="0" <c:if test="${project.dcategory eq '机械与控制'}">selected</c:if>>机械与控制
                </option>
                <option value="1" <c:if test="${project.dcategory eq '信息技术'}">selected</c:if>>信息技术
                </option>
                <option value="2" <c:if test="${project.dcategory eq '能源化工'}">selected</c:if>>能源化工
                </option>
                <option value="3" <c:if test="${project.dcategory eq '生命科学'}">selected</c:if>>生命科学
                </option>
                <option value="0" <c:if test="${project.dcategory eq '数理'}">selected</c:if>>数理</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">课题名称</label>
        <div class="layui-input-block">
            <input type="text" name="title" required  lay-verify="required" value="${project.title}" autocomplete="off"
                   class="layui-input" disabled>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">负责人</label>
        <div class="layui-input-block">
            <input type="text" name="head" required  lay-verify="required" value="${project.head}" autocomplete="off"
                   class="layui-input" disabled>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">参与人员1</label>
        <div class="layui-input-block">
            <input type="text" name="participants" required  lay-verify="required"
                   value="${project.participants}" autocomplete="off" class="layui-input" disabled>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">其他参与人员(非必填)</label>
        <div class="layui-input-block">
            <input type="text" name="oparticipants"
                   value="${project.oparticipants}" autocomplete="off" class="layui-input" disabled>
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">年级</label>
        <div class="layui-input-block">
            <input type="text" name="grade" required  lay-verify="required" value="${project.grade}" autocomplete="off"
                   class="layui-input" disabled>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">经费预算</label>
        <div class="layui-input-block">
            <input type="text" name="budget" required  lay-verify="required" value="${project.budget}"
                   autocomplete="off"
                   class="layui-input" disabled>
        </div>
    </div>

    <button
            class="layui-btn"><a style="color: white;"
                                 href="http://localhost:8080/admin/upload/download?filename=${project.pdeclaration}">点击下载该申报书
    </a></button>

</form>

<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

    });
</script>
</body>
</html>
