<%--
  Created by IntelliJ IDEA.
  User: Truong
  Date: 7/31/2025
  Time: 10:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>List Category</h3>
<table border="1">
    <thead>
    <tr>
        <th>No</th>
        <th>Catalog Id</th>
        <th>Catalog Name</th>
        <th>Description</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCategory}" var="catalog" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${catalog.categoryId}</td>
            <td>${catalog.categoryName}</td>
            <td>${catalog.description}</td>
            <td>${catalog.status?"Active":"Inactive"}</td>
            <td>
                <a href="${pageContext.request.contextPath}/categoryController/initUpdate?catalogId=${catalog.categoryId}">Update</a>
                <a href="${pageContext.request.contextPath}/categoryController/delete?catalogId=${catalog.categoryId}">Delete</a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/categoryController/initAdd">Create new catalog...</a>
</body>
</html>
