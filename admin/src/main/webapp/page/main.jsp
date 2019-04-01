<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
欢迎进入学生科研项目管理系统
<c:if test="${!empty activeUser}">
    <span class="desc">你好，${activeUser.username}，</span>
</c:if>
</body>
</html>