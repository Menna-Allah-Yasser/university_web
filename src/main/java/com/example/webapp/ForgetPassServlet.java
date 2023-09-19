package com.example.webapp;

import MailServices.Mail;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="ForgetPassServlet", value="/ForgetPass-Servlet")
public class ForgetPassServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String email=req.getParameter("email");
        try {
            new Mail().sendEmail(email);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
