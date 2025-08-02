<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Truong
  Date: 8/1/2025
  Time: 11:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/productController/createProduct" method="post">
    <lable for="productId">Product ID(Pxxx):
        <input type="text" name="productId">
    </lable>
    <br>
    <lable for="productName">Product Name:
        <input type="text" name="productName">
    </lable>
    <br>
    <lable for="price">Price:
        <input type="text" name="price">
    </lable>
    <br>
    <lable for="catalogId">Category Name:</lable>
    <select name="catalog.categoryId">
        <c:forEach items="${categoryList}" var="cat">
            <option value="${cat.categoryId}">
                    ${cat.categoryName}
            </option>
        </c:forEach>
    </select>
    <br>

    <lable for="status">Product Status:
        <input type="radio" name="status" value="true" checked>
        <lable for="active">Active</lable>
        <input type="radio" name="status" value="fale">
        <lable for="inactive">InActive</lable>
    </lable>
    <br>
    <input type="submit" value="Submit">

</form>
</body>
</html>
