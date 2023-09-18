package com.example.webapp;

import DB.UserDB;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value ="/Login-Servlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        User user=new User();
        String email=req.getParameter("email");
        String pass=req.getParameter("psw");
        user.setPass(pass);
        user.setEmail(email);
        UserDB userDB=new UserDB();
        boolean res=userDB.serarchUser(user);
        if(res) {
            System.out.println("user Name : " + user.getfName());
            resp.sendRedirect("home.jsp");
        }
        else
            out.println("wrong pass or Email");
        out.close();
    }
}
