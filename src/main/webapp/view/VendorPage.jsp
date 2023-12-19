<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 03.08.2023
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vendor page</title>
</head>
<body>
    Vendor page

    <form action="${request.contextPath}/controller" method="post">
        <input type="hidden" name="command" value="HOME_PAGE">
        <button type="submit">Home page</button>
    </form>
</body>
</html>
