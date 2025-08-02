<%--
  Created by IntelliJ IDEA.
  User: Truong
  Date: 7/31/2025
  Time: 11:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/categoryController/update" method="post">
    <lable for="categoryId">ID:
        <input type="text" name="categoryId" value="${catalog.categoryId}" readonly><br>
    </lable>
    <br>
    <lable for="categoryName">Name:
        <input type="text" name="categoryName" value="${catalog.categoryName}"><br>
    </lable>
    <br>
    <lable for="description">Description:
        <input type="text" name="description" value="${catalog.description}"><br>
    </lable>
    <br>
    <lable for="status">Status:</lable>
    <br>
    <lable for="active">Active</lable>
    <input type="radio" name="status" value="true" ${catalog.status?"checked":""}><br>
    <lable for="inactive">InActive</lable>
    <input type="radio" name="status" value="false" ${catalog.status?"":"checked"}>
    <br>
    <input type="submit" value="Update">

</form>
</body>
</html>
