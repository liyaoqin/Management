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
            ,url: '${ pageContext.request.contextPath }/project/adminviewfproject' //数据接口
            ,width:3000
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'snumber', title: '项目编号', width:150, sort: true, fixed: 'left'}
                ,{field: 'scategory', title: '课题类别', width:300}
                ,{field: 'dcategory', title: '学科类别', width:200}
                ,{field: 'title', title: '课题名称', width:300}
                ,{field: 'head', title: '负责人', width:100}
                ,{field: 'participants', title: '参与人员1', width:300}
                ,{field: 'oparticipants', title: '其他项目参与人员', width:300}
                ,{field: 'grade', title: '年级', width:150}
                ,{field: 'budget', title: '经费预算', width:100}
                ,{field: 'pdeclaration', title: '申报书', width:150}
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
                    title: '此项目内容',
                    shadeClose: false, //点击遮罩关闭
                    area: ['500px', '500px'],
                    content: '${ pageContext.request.contextPath }/page/vlnproject/'+data.id

                });
                console.log(document.getElementsByClassName('lyq'));
            } else if(obj.event === 'del'){
                parent.layer.confirm('真的删除此条项目么', function(index){
                    obj.del();
                    parent.layer.close(index);
                    parent.layer.msg("删除成功", {icon: 6});
                    $.post("${ pageContext.request.contextPath }/project/delnproject/"+data.id,function(data){
                    });
                });
            } else if(obj.event === 'edit'){
                parent.layer.open({
                    type: 2,
                    title: '修改此申报通知',
                    shadeClose: false, //点击遮罩关闭
                    area: ['500px', '500px'],
                    content: '${ pageContext.request.contextPath }/page/veditnproject/'+data.id
                });
            }
        });
    });
</script>
</body>
</html>