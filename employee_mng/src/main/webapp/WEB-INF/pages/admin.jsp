<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <%--<link href="../../css/my.css rel=" rel="stylesheet">--%>
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="../../js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="../../js/bootstrap.min.js"></script>

    <style type="text/css">
        td, th {
            text-align: center;
        }
        .a-upload {
            float: left;
            margin-top: 10px;
            padding: 0px 10px;
            height: 30px;
            line-height: 20px;
            position: relative;
            cursor: pointer;
            color: #888;
            background: #fafafa;
            border: 1px solid #ddd;
            border-radius: 5px;
            overflow: hidden;
            display: inline-block;
            *display: inline;
            *zoom: 1;

        }

        .a-upload  input {

            height: 30px;
            position: absolute;
            font-size: 30px;
            right: 0;
            top: 0;
            opacity: 0;
            filter: alpha(opacity=0);
            cursor: pointer
        }

        .a-upload:hover {
            color: #444;
            background: #eee;
            border-color: #ccc;
            text-decoration: none
        }
        button{
            margin-left: 10px;
            float: left;
        }
        a {
            float: left;
        }

    </style>


</head>
<body>
<div class="container">
    <%@include file="header.jsp"%>


    <div style="float: left;">

        <form class="form-inline" action="/account/findByParams" method="get">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name"  class="form-control" id="exampleInputName2"  value="${map.get('name')}">
            </div>
            <button type="submit" class="btn btn-default" id="employee_query" style="float: right">查询</button>
        </form>

    </div>


    <form id="form" action="" method="post">
        <table border="1" class="table table-bordered table-hover" id="employee_table">
            <tr class="success">
                <th>编号</th>
                <th>姓名</th>
                <th>权限</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${accounts}" var="account" varStatus="s">
                <tr>
                    <td>${account.employee_id}</td>
                    <td>${account.name}</td>
                    <td><c:if test="${account.permission==0}">超级管理员</c:if>
                        <c:if test="${account.permission==1}">普通管理员</c:if>
                    </td>
                    <td><a class="btn btn-default btn-sm" href="#">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="#">删除</a></td>

                </tr>

            </c:forEach>


        </table>
    </form>
</div>
</body>
<script src="../../js/vue.min.js"></script>
<script src="../../js/list.js"></script>

</html>
