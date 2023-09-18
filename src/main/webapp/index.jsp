<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="bg-img">
  <form class="container1" method="post" action="/webapp_war_exploded/Login-Servlet">
    <img src="uniLogo.png" alt="" class="im">

    <input type="text" placeholder="Email , Phone number or username" name="email" required>

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
            <input class="form-check-input" type="radio" name="usertype" id="usertype_2" value="3">
            <label class="form-check-label" for="usertype_2">Doctor</label>
          </div>
        </td>
        <td>
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="usertype" id="usertype_1" value="2">
            <label class="form-check-label" for="usertype_1">Student</label>
          </div>
        </td>
      </tr>
      </tbody>
    </table>

    <button class="btn"
            onclick="home.jsp">Login</button>


    <a href="forgetPass.jsp" >
      <label class="forget">Forget password?</label>
    </a>
    <label class="noAccount">Don't have an account ?</label>
    <a href="signUp.jsp" class="up" target="_blank">Sign up</a>

  </form>

</div>
</body>
</html>