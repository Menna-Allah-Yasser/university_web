package com.example.webapp;

import DB.UserDB;
import Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "SignUpServlet", value ="/SignUp-Servlet")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String regex="^[a-z][a-z0-9_.-]*@[a-z0-9_.-]*\\.[a-z]+$";
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String fn=req.getParameter("fn");
        String ln=req.getParameter("ln");
        String pass=req.getParameter("psw");
        String email=req.getParameter("email");
        String phone=req.getParameter("ph");
        String type=req.getParameter("usertype");

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if(matcher.matches()) {

            User user = new User();
            user.setEmail(email);
            user.setfName(fn);
            user.setlName(ln);
            user.setPhone(phone);
            user.setPass(pass);
            if (type.endsWith("usertype_1")) {
                user.setType("Doctor");
            }

            UserDB userDB = new UserDB();
            userDB.insertUser(user);

            out.println("Hello from post");
            resp.sendRedirect("home.jsp");
        }
        else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Invalid E-mail');");
            out.println("</script>");
            RequestDispatcher rd=req.getRequestDispatcher("userlogin.jsp");
            rd.include(req, resp);
        }
        out.close();
    }
}
