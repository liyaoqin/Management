<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>注册界面</title>
    <link href="${ pageContext.request.contextPath }/css/default.css" rel="stylesheet" type="text/css" />
    <!--必要样式-->
    <link href="${ pageContext.request.contextPath }/css/styles.css" rel="stylesheet" type="text/css" />
    <link href="${ pageContext.request.contextPath }/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="${ pageContext.request.contextPath }/css/loaders.css" rel="stylesheet" type="text/css" />
    <link href="${ pageContext.request.contextPath }/layui/css/layui.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-1.6.4.js"></script>
</head>
<body>
<div style="text-align:center; font-size: 50px;">欢迎注册学生科研项目管理系统</div>
<div class='login'>
    <div class="errorInfo">${error}</div>
    <div class='login_title'>
        <div>已有账号
            <a href="login" target="_self" style="color: white;">去登录</a>
        </div>
        <span>注册</span>
    </div>

    <div class='login_fields'>
        <form name="formlogin" method="post" action="register" id="formregister">
            <div class='login_fields__user'>
                <div class='icon'>
                    <img alt="" src='images/user_icon_copy.png'>
                </div>
                <input name="username" id="regName" placeholder='用户名' maxlength="16" type='text' autocomplete="off"/>
                <div class='validation'>
                    <img alt="" src='images/tick.png'>
                </div>
            </div>
            <div class='login_fields__password'>
                <div class='icon'>
                    <img alt="" src='images/lock_icon_copy.png'>
                </div>
                <input name="password" id="pwd" placeholder='密码' maxlength="16" type='password' autocomplete="off">
                <div class='validation'>
                    <img alt="" src='images/tick.png'>
                </div>
            </div>
            <div class='login_fields__password'>
                <div class='icon'>
                    <img alt="" src='images/lock_icon_copy.png'>
                </div>
                <input name="pwdRepeat" id="pwdRepeat" placeholder='确认密码' maxlength="16" type='password' autocomplete="off">
                <div class='validation'>
                    <img alt="" src='images/tick.png'>
                </div>
            </div>
            <div class='login_fields__user'>
                <div class='icon'>
                    <img alt="" src='images/user_icon_copy.png'>
                </div>
                <input name="phone" id="phone" placeholder='电话' maxlength="16" type='text' autocomplete="off"/>
                <div class='validation'>
                    <img alt="" src='images/tick.png'>
                </div>
            </div>
            <div class='login_fields__user'>
                <div class='icon'>
                    <img alt="" src='images/user_icon_copy.png'>
                </div>
                <input name="email" id="email" placeholder='邮箱' maxlength="30" type='text' autocomplete="off"/>
                <div class='validation'>
                    <img alt="" src='images/tick.png'>
                </div>
            </div>
            <div class='login_fields__submit'>
                <input type='button' value='注册' onclick="REGISTER.reg();">
            </div>

        </form>

    </div>

</div>



<script type="text/javascript">
    var REGISTER={
        param:{
            //单点登录系统的url
            surl:""
        },
        inputcheck:function(){
            //不能为空检查
            if ($("#regName").val() == "") {
                alert("用户名不能为空");
                $("#regName").focus();
                return false;
            }
            if ($("#pwd").val() == "") {
                alert("密码不能为空");
                $("#pwd").focus();
                return false;
            }
            if ($("#phone").val() == "") {
                alert("手机号不能为空");
                $("#phone").focus();
                return false;
            }
            if ($("#email").val() == "") {
                alert("邮箱不能为空");
                $("#phone").focus();
                return false;
            }
            //密码检查
            if ($("#pwd").val() != $("#pwdRepeat").val()) {
                alert("确认密码和密码不一致，请重新输入！");
                $("#pwdRepeat").select();
                $("#pwdRepeat").focus();
                return false;
            }
            return true;
        },
        beforeSubmit:function() {
            //检查用户是否已经被占用
            $.ajax({
                url : "${ pageContext.request.contextPath }/check/"+escape($("#regName").val())+"/1?r=" + Math.random(),
                success : function(data) {
                    if (data.data) {
                        //检查手机号是否存在
                        $.ajax({
                            url : "${ pageContext.request.contextPath }/check/"+$("#phone").val()+"/2?r=" + Math.random(),
                            success : function(data) {
                                if (data.data) {
                                    $.ajax({
                                        url : "${ pageContext.request.contextPath }/check/"+$("#email").val()+"/3?r=" + Math.random(),
                                        success : function(data) {
                                            if (data.data) {
                                                REGISTER.doSubmit();
                                            } else {
                                                alert("此邮箱已经被注册！");
                                                $("#email").select();
                                            }
                                        }
                                    });
                                } else {
                                    alert("此手机号已经被注册！");
                                    $("#phone").select();
                                }
                            }
                        });
                    } else {
                        alert("此用户名已经被占用，请选择其他用户名");
                        $("#regName").select();
                    }
                }
            });

        },
        doSubmit:function() {
            $.post("register",$("#formregister").serialize(), function(data){
                if(data.status == 200){
                    alert('用户注册成功，请登录！');
                    REGISTER.login();
                } else {
                    alert("注册失败！");
                }
            });
        },
        login:function() {
            location.href = "login";
            return false;
        },
        reg:function() {
            if (this.inputcheck()) {
                this.beforeSubmit();
            }
        }
    };
</script>
</body>
</html>
