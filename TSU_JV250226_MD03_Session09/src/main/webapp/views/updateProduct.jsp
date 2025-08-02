<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Truong
  Date: 8/1/2025
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/productController/updateProduct" method="post">
    <lable for="productId">ID:
        <input type="text" name="productId" value="${product.productId}" readonly><br>
    </lable>
    <br>
    <lable for="productName">Product Name:
        <input type="text" name="productName" value="${product.productName}"><br>
    </lable>
    <br>
    <lable for="price">Price:
        <input type="text" name="price" value="${product.price}"><br>
    </lable>
    <br>
    <lable for="catalogId">Category Name:</lable>
    <select name="catalog.categoryId">
        <c:forEach items="${categoryList}" var="cat">
            <option value="${cat.categoryId}"
                    <c:if test="${product.catalog.categoryId == cat.categoryId}">selected</c:if>>
                ${cat.categoryName}
            </option>
        </c:forEach>
    </select>
    <br>
    <lable for="status">Product Status:</lable>
    <br>
    <lable for="active">Active</lable>
    <input type="radio" name="status" value="true" ${product.status?"checked":""}><br>
    <lable for="inactive">InActive</lable>
    <input type="radio" name="status" value="false" ${product.status?"":"checked"}>
    <br>
    <input type="submit" value="Update">

</form>
</body>
</html>
