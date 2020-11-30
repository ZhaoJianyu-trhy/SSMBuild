<%--
  Created by IntelliJ IDEA.
  User: zjy
  Date: 2020/11/30
  Time: 下午 3:29
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
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>


    <form action="${pageContext.request.contextPath}/book/update" method="post">
        <div class="form-group">
            <input type="hidden" class="form-control" name="bookID" value="${qBooks.bookID}" readonly required>
        </div>
        <div class="form-group">
            <label>书籍名称：</label>
            <input type="text" class="form-control" name="bookName" value="${qBooks.bookName}" required>
        </div>
        <div class="form-group">
            <label>书籍数量：</label>
            <input type="text" class="form-control" name="bookCounts" value="${qBooks.bookCounts}" required>
        </div>
        <div class="form-group">
            <label>书籍描述：</label>
            <input type="text" class="form-control" name="detail" value="${qBooks.detail}" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="修改">
        </div>
    </form>
</div>
</body>
</html>
