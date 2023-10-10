<%--
  Created by IntelliJ IDEA.
  User: ainizuofurong
  Date: 2022/7/4
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <small>新增书籍</small>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/toAddBook" method="get">
        <div class="form-group">
            <label for="bkName">新增书籍名称:</label>
            <input type="text" name="bookName" class="form-control" id="bkName" required>
        </div>
        <div class="form-group">
            <label for="bkCount">书籍数量:</label>
            <input type="text" class="form-control" name="bookCounts" id="bkCount" required>
        </div>
        <div class="form-group">
            <label for="bkDetail">书籍描述:</label>
            <input type="text" class="form-control" name="detail" id="bkDetail" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="添加">
        </div>
    </form>
</div>
</body>
</html>
