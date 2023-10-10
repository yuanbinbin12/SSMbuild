<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ainizuofurong
  Date: 2022/7/1
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>

    <title>书籍展示页面</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript">
       function cilck(){
           var s=document.getElementById("msg").getAttribute("value");
           if (s!=""){
               alert(s);
           }
       }
    </script>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表----------显示所有书籍</small>
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/addBook">新增书籍</a>
            </div>
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">显示全部书籍</a>
                <label style="font-weight: bold;color:red;" id="msg" value="${msg}"></label>
            </div>
            <div class="col-md-4 column">
                <%--查询数据--%>
                <form method="get"style="float: right;" action="${pageContext.request.contextPath}/book/selectByAll">
                      <input type="text" class="form-control" name="queryBookName" style="float: left;position:relative; left:-80px;" placeholder="请输入要查询的数据名称">
                        <input type="submit" class="btn btn-primary" style="position: relative;left: 190px;top: -35px;" value="查询">
                    <input type="button" id="ybb" value="ss" style="display: none" onclick="cilck()">
                </form>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                 <thead>
                 <tr>
                     <th>书籍标号</th>
                     <th>书籍名称</th>
                     <th>书籍数量</th>
                     <th>书籍详情</th>
                     <th>操作</th>
                 </tr>
                 </thead>
                <tbody>
                <c:forEach var="book" items="${allBooks}" begin="0">
                    <tr>
                        <td>${book.bookID}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookCounts}</td>
                        <td>${book.detail}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/book/toUpdateBook/${book.bookID}">修改</a>&nbsp; | &nbsp;
                            <a href="${pageContext.request.contextPath}/book/deleteBook/${book.bookID}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    var cil1=document.getElementById("ybb");
    cil1.click(function (){

    });
</script>
</html>
