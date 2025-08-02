<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Truong
  Date: 8/1/2025
  Time: 10:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Products</title>
</head>
<body>
<h3>List Products</h3>
<form action="${pageContext.request.contextPath}/productController/searchProductByName" method="get">
    <input type="search" name="keyword"/>
    <button type="submit">Search</button>
</form>

<table border="1">
    <thead>
    <tr>
        <th>No</th>
        <th>Product Id</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Category Name</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.price}</td>
            <td>${product.catalog.categoryName}</td>
            <td>${product.status?"Active":"Inactive"}</td>
            <td>
                <a href="${pageContext.request.contextPath}/productController/initUpdate?productId=${product.productId}">Update</a>
                <a href="${pageContext.request.contextPath}/productController/delete?productId=${product.productId}">Delete</a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/productController/initCreate">Create new Product...</a>
</body>
</html>
