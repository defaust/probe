<%--
  Created by IntelliJ IDEA.
  User: devT
  Date: 08.01.2017
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All products</title>
</head>
<body>
<h1>User list</h1>

<table style="margin-left: auto;margin-right: auto" cellspacing="30px">
    <c:forEach items="${products}" var="product" varStatus="counter">
        <tr style="vertical-align: top">
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.category}</td>
            <td><a href="/products/del/${product.id}">* DEL </a> </td>
            <td><a href="/products/edit/${product.id}">* EDIT *</a> </td>
        </tr>
    </c:forEach>
    <a href="/products/form"> *** Add product *** </a>
</table>
</body>
</html>
