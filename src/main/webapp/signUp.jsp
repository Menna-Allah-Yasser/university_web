<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 13/09/2023
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <link href="signUp.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="bg-img">
    <form class="container2" action="/webapp_war_exploded/SignUp-Servlet" method="post">
        <img src="uniLogo.avif" alt="" class="im">


        <input type="text" placeholder="First Name" name="fn" required>
        <input type="text" placeholder="Last Name" name="ln" required>
        <input type="email" placeholder="Email " name="email" required>
        <input type="text" placeholder="Phone Number " name="ph" required>
        <input type="password" placeholder="Password" name="psw" required>

        <table class="table">
            <tbody>
            <tr>
                <td>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="usertype" id="usertype_0" value="1"
                               checked="checked">
                        <label class="form-check-label" for="usertype_0">Admin</label>
                    </div>
                </td>
                <td>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="usertype" id="usertype_1" value="3">
                        <label class="form-check-label" for="usertype_1">Doctor</label>
                    </div>
                </td>
                <td>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="usertype" id="usertype_2" value="2">
                        <label class="form-check-label" for="usertype_2">Student</label>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>

        <button type="submit" class="btn">Sign up</button>


    </form>

</div>

</body>
</html>
