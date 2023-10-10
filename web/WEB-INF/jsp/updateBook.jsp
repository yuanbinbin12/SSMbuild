<%--
  Created by IntelliJ IDEA.
  User: ainizuofurong
  Date: 2022/7/7
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
  <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <div class="row clearfix">
    <div class="col-md-12 column">
      <div class="page-header">
        <small>修改书籍</small>
      </div>
    </div>
  </div>
  <form action="${pageContext.request.contextPath}/book/updateBook/${updateBook.bookID}" method="get">
    <input type="hidden" name="bookID" value="${updateBook.bookID}">//隐藏域
    <div class="form-group">
      <label for="bkName">书籍名称:</label>
      <input type="text" name="bookName" class="form-control" id="bkName" value="${updateBook.bookName}">
    </div>
    <div class="form-group">
      <label for="bkCount">书籍数量:</label>
      <input type="text" class="form-control" name="bookCounts" id="bkCount" value="${updateBook.bookCounts}">
    </div>
    <div class="form-group">
      <label for="bkDetail">书籍描述:</label>
      <input type="text" class="form-control" name="detail" id="bkDetail" value="${updateBook.detail}">
    </div>
    <div class="form-group">
      <input type="submit" class="form-control" value="添加">
    </div>
  </form>
</div>
</body>
</html>
