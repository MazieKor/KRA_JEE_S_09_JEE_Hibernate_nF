<%--
  Created by IntelliJ IDEA.
  User: LifeBook
  Date: 14.10.2020
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>
        Book ${book.id == null ? "add" : "edit"} form
    </h1>
<%--    Wersja pierwsza--%>
<%--    <c:if test="${not empty errors}">--%>
<%--        <h4>--%>
<%--            Errors--%>
<%--        </h4>--%>
<%--        <c:forEach items="${errors}" var="error">--%>
<%--            <p>${error.propertyPath}: ${error.message}</p>--%>
<%--        </c:forEach>--%>
<%--    </c:if>--%>

    <form:form method="post" action="${pageContext.request.contextPath}/book/save" modelAttribute="book">
        <form:hidden path="id"/>
        <section>
            <form:input path="title" placeholder="Title"/>
            <form:errors path="title"/>
        </section>
        <section>
            <form:input path="rating" placeholder="Rating"/>
            <form:errors path="rating"/>
        </section>
        <section>
            <form:textarea path="description" placeholder="Description"/>
            <form:errors path="description"/>
        </section>
        <section>
            <form:input path="pages" placeholder="Page count"/>
            <form:errors path="pages"/>
        </section>
        <section>
            <form:select path="publisher">
                <form:option value="-">Select publisher</form:option>
                <form:options items="${publishers}" itemLabel="name" itemValue="id"/>
            </form:select>
            <form:errors path="publisher"/>
        </section>
        <section>

            <form:select path="authors" multiple="true">
                <from:options items="${authors}" itemLabel="fullName" itemValue="id"/>
            </form:select>
            <form:errors path="authors"/>
        </section>

<%--            Starsza wersja zadania--%>
<%--        <section>--%>
<%--            <form:input  path="title" placeholder="Title" />--%>
<%--            <form:input  path="rating" placeholder="Rating" />--%>
<%--            <form:textarea  path="description" placeholder="Description" />--%>

<%--            <form:select  path="publisher.id">    &lt;%&ndash; .id dodane później&ndash;%&gt;--%>
<%--                <form:option value="-"> Select publisher</form:option>--%>
<%--                <form:options items="${publishers}" itemLabel="name" itemValue="id" />--%>
<%--            </form:select>--%>

<%--            <form:select path="authors" multiple="true">--%>
<%--                <form:options items="${authors}" itemLabel=""--%>

<%--            </form:select>--%>

        <section>
            <button type="submit">wyślij</button>
        </section>


    </form:form>

<%--    <c:if></c:if>  mozna też zrobić c:ifem--%>


</body>
</html>
