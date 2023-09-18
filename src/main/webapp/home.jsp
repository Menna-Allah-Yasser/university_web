<%@ page import="java.sql.*" %><%--
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
<div>
    <table>

        <th>Email</th>
        <th>UserName</th>
        <th>Phone</th>

        <tr>
            <td>Menna</td>
            <td>Menna</td>
            <td>Menna</td>

        </tr>


<%!
    private final  String user = "root";
    private final  String uni = "university";
    private final  String password = "password";
    private final String url="jdbc:mysql://localhost:"+3306+"/"+uni;
    public  Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);

    }
%>
<%

        Connection connection;
        String query;
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;
        try {

            connection = connect();
            query = "select * from signup ";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {  %>
               <tr>
                   <td> <%= resultSet.getString("email")%></td>
                    <td><%=resultSet.getString("FirstName") %></td>
                    <td><%= resultSet.getString("Phone")%></td>

              </tr>
           <% }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } %>






    </table>
</div>
</body>

</html>