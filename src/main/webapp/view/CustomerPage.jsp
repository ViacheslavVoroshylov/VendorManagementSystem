<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 05.09.2023
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CustomerPage</title>
</head>
<body>
    Customer page

    <form action="${request.contextPath}/controller" method="post">
        <input type="hidden" name="command" value="HOME_PAGE">
        <button type="submit">Home page</button>
    </form>
</body>
</html>
