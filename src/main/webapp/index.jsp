<%@ page import="com.khai.voroshylov.connection.ConnectionDataBase" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 02.10.2022
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List of Customers</h1>

<%

    List<String> customers = ConnectionDataBase.createConnection();
    for (String customer : customers) {
        out.println(customer.replaceAll("\\s", "") + " ");
    }

%>
</body>
</html>
