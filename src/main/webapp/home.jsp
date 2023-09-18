<%@ page import="java.sql.*" %>
<%@ page import="Model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="DB.UserDB" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/09/2023
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link href="home.css" rel="stylesheet" type="text/css">
    <title>Table</title>
</head>

<body>
<h1>User List Page</h1>
<div>
    <table>
        <th>Email</th>
        <th>UserName</th>
        <th>Phone</th>

        <%List<User>list= new UserDB().getAllUsers();
            for(User item : list){  %>
            <tr>
            <td> <%= item.getEmail()%></td>
            <td><%=item.getfName() %></td>
            <td><%= item.getPhone()%></td>
            </tr>
           <% }%>

    </table>
</div>
</body>

</html>