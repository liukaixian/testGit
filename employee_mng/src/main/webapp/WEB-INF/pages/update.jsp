<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改用户</title>

        <link href="../../css/bootstrap.min.css" rel="stylesheet">
        <script src="../../js/jquery-2.1.0.min.js"></script>
        <script src="../../js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改联系人</h3>
        <form action="/employee/updateEmployee" method="post">
            <!--  隐藏域 提交id-->
            <input type="hidden" name="id" value="${employee.id}">

          <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name"  value="${employee.name}"<%-- readonly="readonly"--%> placeholder="请输入姓名" />
          </div>

          <div class="form-group">
            <label>性别：</label>
              <c:if test="${employee.gender == '男'}">
                  <input type="radio" name="gender" value="男" checked />男
                  <input type="radio" name="gender" value="女"  />女
              </c:if>

              <c:if test="${employee.gender == '女'}">
                  <input type="radio" name="gender" value="男"  />男
                  <input type="radio" name="gender" value="女" checked  />女
              </c:if>

          </div>

          <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" value="${employee.age}" id="age"  name="age" placeholder="请输入年龄" />
          </div>

          <div class="form-group">
            <label for="department">部门：</label>
             <select name="department" id="department" class="form-control" >
                 <c:if test="${employee.department == '研发部'}">
                    <option value="研发部" selected>研发部</option>
                    <option value="企宣部">企宣部</option>
                    <option value="测试部">测试部</option>
                 </c:if>

                 <c:if test="${employee.department == '企宣部'}">
                     <option value="研发部" >研发部</option>
                     <option value="企宣部" selected>企宣部</option>
                     <option value="测试部">测试部</option>
                 </c:if>

                 <c:if test="${employee.department == '测试部'}">
                     <option value="研发部" >研发部</option>
                     <option value="企宣部">企宣部</option>
                     <option value="测试部" selected>测试部</option>
                 </c:if>
            </select>
          </div>

          <div class="form-group">
            <label for="salary">工资：</label>
            <input type="text" id="salary" class="form-control" value="${employee.salary}" name="salary" placeholder="请输入工资"/>
          </div>

          <div class="form-group">
            <label for="grade">效绩考核：</label>
            <input type="text" id="grade" class="form-control" value="${employee.grade}" name="grade" placeholder="请输入业绩考核"/>
          </div>

             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
                <input class="btn btn-default" type="reset" value="重置" />
                <input class="btn btn-default" type="button" value="返回"/>
             </div>
        </form>
        </div>
    </body>
</html>