<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/27
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
<%--    <script src="../../js/jquery-2.1.0.min.js"></script>

    <script src="../../js/bootstrap.js"></script>
    <link href="../../css/bootstrap.css" rel="stylesheet">--%>


</head>
<body>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand active"   href="#">首页</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li  v-for="(item,index) in navs" :class="{active:currentActive==index}"><a :href="item.url" @click="changColor(index)">{{item.name}}</a></li>

                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">退出登录</a></li>
                </ul>
            </div>
        </div>
    </nav>
</body>
<%--<script src="../../js/vue.min.js"></script>
<script src="../../js/list.js"></script>--%>
</html>

