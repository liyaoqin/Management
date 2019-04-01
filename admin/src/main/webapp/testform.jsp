<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>submitUserList_4</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<script language="JavaScript" src="${ pageContext.request.contextPath }/js/jquery-1.6.4.js" ></script>
<script type="text/javascript" language="JavaScript">
    //将表单序列化成json格式的数据(但不适用于含有控件的表单，例如复选框、多选的select)
    (function($){
        $.fn.serializeJson = function(){
            var jsonData1 = {};
            var serializeArray = this.serializeArray();
            // 先转换成{"id": ["12","14"], "name": ["aaa","bbb"], "pwd":["pwd1","pwd2"]}这种形式
            $(serializeArray).each(function () {
                if (jsonData1[this.name]) {
                    if ($.isArray(jsonData1[this.name])) {
                        jsonData1[this.name].push(this.value);
                    } else {
                        jsonData1[this.name] = [jsonData1[this.name], this.value];
                    }
                } else {
                    jsonData1[this.name] = this.value;
                }
            });
            // 再转成[{"id": "12", "name": "aaa", "pwd":"pwd1"},{"id": "14", "name": "bb", "pwd":"pwd2"}]的形式
            var vCount = 0;
            // 计算json内部的数组最大长度
            for(var item in jsonData1){
                var tmp = $.isArray(jsonData1[item]) ? jsonData1[item].length : 1;
                vCount = (tmp > vCount) ? tmp : vCount;
            }

            if(vCount > 1) {
                var jsonData2 = new Array();
                for(var i = 0; i < vCount; i++){
                    var jsonObj = {};
                    for(var item in jsonData1) {
                        jsonObj[item] = jsonData1[item][i];
                    }
                    jsonData2.push(jsonObj);
                }
                return JSON.stringify(jsonData2);
            }else{
                return "[" + JSON.stringify(jsonData1) + "]";
            }
        };
    })(jQuery);

    function submitUserList_4() {
        var jsonStr = $("#form1").serializeJson();
        //console.log("jsonStr:\r\n" + jsonStr);
        alert(jsonStr);
        $.ajax({
            url: "page/submitUserList_4",
            type: "POST",
            contentType : 'application/json;charset=utf-8', //设置请求头信息
            dataType:"json",
            data: jsonStr,
            success: function(data){
                alert(JSON.stringify(data));
            },
            error: function(res){
                alert(res.responseText);
            }
        });
    }
    function submitUserList_5() {
        var jsonStr1 = $("#form1").serializeJson();
        var jsonStr2 = $("#form2").serializeJson();
        //console.log("jsonStr:\r\n" + jsonStr);
        //jsonStr1["data"]=jsonStr2;
       var obj1={"aa":"lyq","bb":"456"};
       jsonStr2=JSON.parse(jsonStr2);
       obj1["data"]=jsonStr2;
        alert(JSON.stringify(obj1));
        obj1=JSON.stringify(obj1);
        $.ajax({
            url: "page/submitUserList_4",
            type: "POST",
            contentType : 'application/json;charset=utf-8', //设置请求头信息
            dataType:"json",
            data: jsonStr1,
            success: function(data){
                alert(JSON.stringify(data));
            },
            error: function(res){
                alert(res.responseText);
            }
        });
    }
</script>
</head>

<body>
<h1>submitUserList_4</h1>
<form id="form1">
    ID:<input type="text" name="id"><br/>
    Username:<input type="text" name="name"><br/>
    Password:<input type="text" name="pwd"><br/><br/>

    ID:<input type="text" form="form2" name="id"><br/>
    Username:<input type="text" form="form2" name="name"><br/>
    Password:<input type="text" form="form2" name="pwd"><br/><br/>
    ID:<input type="text" form="form2" name="id"><br/>
    Username:<input type="text" form="form2" name="name"><br/>
    Password:<input type="text" form="form2" name="pwd"><br/><br/>
    <input type="button" value="submit" onclick="submitUserList_4();">
</form>
<form id="form2">
    <input type="button" value="提交2" onclick="submitUserList_5();"/>
</form>
</body>

</html>