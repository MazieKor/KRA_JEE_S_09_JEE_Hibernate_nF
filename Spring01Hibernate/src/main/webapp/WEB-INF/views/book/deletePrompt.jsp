<%--
  Created by IntelliJ IDEA.
  User: LifeBook
  Date: 14.10.2020
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>
    Do you want to delete book: ${book.title}
</p>
<a href="book">No</a>
<a href="/book/delete/${book.id}?accept=true">Yes</a>


</body>
</html>
