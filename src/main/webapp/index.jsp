<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 24.07.2023
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Home page</h1>
<form action="${request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="CUSTOMER_PAGE">
    <button type="submit">Customer page</button>
</form>
<form action="${request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="VENDOR_PAGE">
    <button type="submit">Vendor page</button>
</form>
</body>
</html>
