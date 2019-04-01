<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>登录界面</title>
    <link href="${ pageContext.request.contextPath }/css/default.css" rel="stylesheet" type="text/css" />
    <!--必要样式-->
    <link href="${ pageContext.request.contextPath }/css/styles.css" rel="stylesheet" type="text/css" />
    <link href="${ pageContext.request.contextPath }/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="${ pageContext.request.contextPath }/css/loaders.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div style="text-align:center; font-size: 50px;">欢迎登录学生科研项目管理系统</div>
<div class='login'>
    <div class="errorInfo">${error}</div>
    <div class='login_title'>
        <div>还没有账号？
            <a href="register" target="_self" style="color: white;">立即注册</a>
        </div>
        <span>登录</span>
    </div>

    <div class='login_fields'>
        <form name="formlogin" method="post" action="login" id="formlogin">
            <div class='login_fields__user'>
                <div class='icon'>
                    <img alt="" src='images/user_icon_copy.png'>
                </div>
                <input name="username" placeholder='用户名' maxlength="16" type='text' autocomplete="off"/>
                <div class='validation'>
                    <img alt="" src='images/tick.png'>
                </div>
            </div>
            <div class='login_fields__password'>
                <div class='icon'>
                    <img alt="" src='images/lock_icon_copy.png'>
                </div>
                <input name="password" placeholder='密码' maxlength="16" type='password' autocomplete="off">
                <div class='validation'>
                    <img alt="" src='images/tick.png'>
                </div>
            </div>
            <div class='login_fields__submit'>
                <input type='submit' value='登录'>
            </div>

        </form>

    </div>

</div>


<link href="${ pageContext.request.contextPath }/layui/css/layui.css" rel="stylesheet" type="text/css" />

</body>
</html>
