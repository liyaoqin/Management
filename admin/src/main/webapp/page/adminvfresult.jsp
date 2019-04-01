<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>table模块快速使用</title>
    <link rel="stylesheet" href="../newlayui/layui/css/layui.css" media="all">
</head>
<body>
<table id="demo" lay-filter="test"></table>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>
</script>
<script src="../newlayui/layui/layui.js"></script>
<script>
    layui.use('table', function(){
        var table = layui.table,
            $=layui.jquery;

        //第一个实例
        table.render({
            elem: '#demo'
            ,url: '${ pageContext.request.contextPath }/result/adminviewfresult'
            ,width:2500
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'projectSnumber', title: '项目编号', width:150, sort: true, fixed: 'left'}
                ,{field: 'projectTitle', title: '课题名称', width:300}
                ,{field: 'cresults', title: '结题材料', width:150}
                ,{field: 'reason', title: '申报失败原因', width:200}
                ,{field: 'date', title: '申请时间', width: 177}
                ,{field:'right', title: '操作',toolbar:"#barDemo"}
            ]]
        });
        //监听工具条
        table.on('tool(test)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                parent.layer.open({
                    type: 2,
                    title: '此成果内容',
                    shadeClose: false, //点击遮罩关闭
                    area: ['500px', '500px'],
                    content: '${ pageContext.request.contextPath }/page/vlnresult/'+data.id

                });
                console.log(document.getElementsByClassName('lyq'));
            } else if(obj.event === 'del'){
                parent.layer.confirm('真的删除此条成果么', function(index){
                    obj.del();
                    parent.layer.close(index);
                    parent.layer.msg("删除成功", {icon: 6});
                    $.post("${ pageContext.request.contextPath }/result/delnresult/"+data.id,function(data){
                    });
                });
            } else if(obj.event === 'edit'){
                parent.layer.open({
                    type: 2,
                    title: '修改此成果',
                    shadeClose: false, //点击遮罩关闭
                    area: ['500px', '500px'],
                    content: '${ pageContext.request.contextPath }/page/veditnresult/'+data.id
                });
            }
        });
    });
</script>
</body>
</html>