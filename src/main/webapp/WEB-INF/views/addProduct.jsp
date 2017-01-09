<%--
  Created by IntelliJ IDEA.
  User: devT
  Date: 08.01.2017
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AddProduct</title>
</head>
<body>
<div class="container">
    <table>
        <form action="<c:url value='/products/add'/>" method="post" >
            <tr>
                <td>
                    <input name="id" value="${product.id}" type="text" readonly>
                </td>
            </tr>
            <tr>
                <td>
                    <input name="name" value="${product.name}" type="text" placeholder="Product name "/>
                </td>
            </tr>
            <tr>
                <td>
                    <select name = "category.id">
                        <c:forEach var="cat" items="${categories}">
                            <option ${(product.category.id eq cat.id)? "selected": ""} value="${cat.id}" > ${cat.name} </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Save">
                </td>
            </tr>
        </form>
    </table>
</div>

</body>
</html>
