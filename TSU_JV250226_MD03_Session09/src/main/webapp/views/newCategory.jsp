<%--
  Created by IntelliJ IDEA.
  User: Truong
  Date: 7/31/2025
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add newCatalog</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/categoryController/create" method="post">
    <lable for="categoryName">Name:
        <input type="text" name="categoryName">
    </lable>
    <br>
    <lable for="description">Description:
        <input type="text" name="description">
    </lable>
    <br>

    <lable for="status">Status:
        <input type="radio" name="status" value="true" checked><lable for="active">Active</lable>
        <input type="radio" name="status" value="fale" ><lable for="inactive">InActive</lable>
    </lable>
    <br>
    <input type="submit" value="Submit">

</form>
</body>
</html>
