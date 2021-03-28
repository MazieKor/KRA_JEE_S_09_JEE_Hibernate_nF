<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LifeBook
  Date: 13.10.2020
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1> Autorzy: </h1>
<p> ${publishers.get(0).name} </p>

<h1> Autorzy w pętli: </h1>
<c:forEach items="${publishers}" var="publisher">
        <h2>
            <ol>
            <li>${publisher.id}
                    ${publisher.name}</li>
            </ol>
        </h2>
</c:forEach>

</body>
</html>
