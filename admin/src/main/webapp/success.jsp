<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-1.6.4.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#myinput").click(function () {
                location.reload();
            });
        });
    </script>
</head>

<input id="myinput" type="button" value="你好">
</body>
</html>