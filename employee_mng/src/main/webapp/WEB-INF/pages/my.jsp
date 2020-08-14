<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/30
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="float: left;">

    <form class="form-inline" action="/employee/findAndpaging" method="get">
        <div class="form-group">
            <label for="exampleInputName2">姓名</label>
            <input type="text" name="name"  class="form-control" id="exampleInputName2"  value="${map.get('name')}">
        </div>
        <div class="form-group">
            <label for="exampleInputName3">部门</label>
            <input type="text" name="department"  class="form-control" id="exampleInputName3"  value="${map.get('department')}">
        </div>

        <div class="form-group">
            <label for="exampleInputEmail2">工资</label>
            <input type="text" name="salary"  class="form-control" id="exampleInputEmail2"  value="${map.get('salary')}" >
        </div>
        <button type="submit" class="btn btn-default" id="employee_query" style="float: right">查询</button>
    </form>

</div>

<div style="float: right;margin: 5px;">

    <a class="btn btn-primary" href="/forward/forwardTo/add">添加联系人</a>
    <a  href="/employee/findAndpaging" id="hidde_btn" hidden="hidden" ></a>
    <button  class="btn btn-default" id="delSelected" >批量删除</button>
    <form action="/employee/excelImport" id="fileu_pload_form" method="post" enctype="multipart/form-data">
        <a href="javascript:;" class="a-upload">
            <input type="file" name="upload" id="upload1">选择文件
        </a>
        <button type="button" class="btn btn-primary" id="file_upload_btn" style="margin:8px  0 0 25px;">导入</button>
    </form>

</div>
<form id="form" action="" method="post">
    <table border="1" class="table table-bordered table-hover" id="employee_table">
        <tr class="success">
            <th><input type="checkbox" id="firstCb"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>部门</th>
            <th>工资</th>
            <th>效绩考核</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${pm.records}" var="employee" varStatus="s">
            <tr>
                <td><input type="checkbox" name="uid" value=""></td>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.gender}</td>
                <td>${employee.age}</td>
                <td>${employee.department}</td>
                <td>${employee.salary}</td>
                <td>${employee.grade}</td>
                <td><a class="btn btn-default btn-sm" href="/employee/forwordUpdateJSP/${employee.id}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="/employee/deleteById/${employee.id}">删除</a></td>

            </tr>

        </c:forEach>


    </table>
</form>
<%--导航栏--%>
<div style="text-align: center">
    <nav aria-label="Page navigation"  >
        <ul class="pagination" >
            <c:if test="${pm.currentPageNum == 1}">
            <li class="disabled" >
                <a href="javascript:void(0)" aria-label="Previous">
                    </c:if>

                    <c:if test="${pm.currentPageNum != 1}">
            <li>
                <a href="/employee/findAndpaging?curNum=${pm.currentPageNum-1}&rows=5&name=${map.get('name')}&department=${map.get('department')}&salary=${map.get('salary')}" aria-label="Previous">
                    </c:if>
                    <span aria-hidden="true" id="pre-button">&laquo;</span>
                </a>
            </li>

            <c:forEach begin="1" end="${pm.totalPageNum}" var="i" >
                <c:if test="${pm.currentPageNum==i}">
                    <li class="active"><a href="/employee/findAndpaging?curNum=${i}&rows=5&name=${map.get('name')}&department=${map.get('department')}&salary=${map.get('salary')}">${i}</a></li>
                </c:if>
                <c:if test="${pm.currentPageNum != i}">
                    <li><a href="/employee/findAndpaging?curNum=${i}&rows=5&name=${map.get('name')}&department=${map.get('department')}&salary=${map.get('salary')}">${i}</a></li>
                </c:if>
            </c:forEach>

            <c:if test="${pm.currentPageNum != pm.totalPageNum}">
            <li>
                <a href="/employee/findAndpaging?curNum=${pm.currentPageNum+1}&rows=5&name=${map.get('name')}&department=${map.get('department')}&salary=${map.get('salary')}" aria-label="Next">
                    </c:if>

                    <c:if test="${pm.currentPageNum == pm.totalPageNum}" >
            <li class="disabled" ;>
                <a href="javascript:void(0)" aria-label="Next">
                    </c:if>
                    <span aria-hidden="true" id ="rig-button">&raquo;</span>
                </a>
            </li>                   <span style="font-size: 25px;margin-left: 5px;">
                    共${pm.totalRecords}条记录，共${pm.totalPageNum}页
                </span>

        </ul>
    </nav>
</div>
</body>
</html>
