<%@ page import="com.khai.voroshylov.model.WebConnection" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 02.04.2023
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

    for(String name: WebConnection.getCustomers()){
        System.out.print(name + "<br/>");
    }

%>
</body>
</html>
