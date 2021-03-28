<%--
  Created by IntelliJ IDEA.
  User: LifeBook
  Date: 13.10.2020
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<ul>
    <c:forEach items="${books}" var="book">
        <li>
            <h4>${book.title}</h4>
            <p>publisher: ${book.publisher.name}</p>
            <p>rating: ${book.rating}</p>
            <ul>Authors:
                <c:forEach items="${book.authors}" var="author">
                    <li>${author.firstName} ${author.lastName}</li>
                </c:forEach>
            </ul>
            <a href ="/book/edit/${book.id}">Edit</a>
            <a href ="/book/delete/${book.id}">Delete</a>
        </li>
    </c:forEach>
</ul>


<%--<h1>  Pierwotna wersja --%>
<%--    Book List--%>
<%--</h1>--%>

<%--<ul>--%>
<%--    <c:forEach items="${books}" var="book" >--%>
<%--        <li>--%>
<%--            <h4>--%>
<%--                ${boook.title}--%>
<%--                <p>publisher = ${book.publisher.name}</p>--%>
<%--            </h4>--%>
<%--        </li>--%>

<%--    </c:forEach>--%>

<%--    <a href ="/book/edit/${book.id}">Edit</a>--%>

<%--</ul>--%>

</body>
</html>
