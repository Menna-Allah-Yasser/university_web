package com.example.webapp;

import MailServices.Email;
import Model.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="ForgetPassServlet", value="/ForgetPass-Servlet")
public class ForgetPassServlet extends HttpServlet {
    private String host;
    private String port;
    private String user;
    private String pass;

    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recipient = request.getParameter("email");
        String subject = "Your temporary password details";
        String content = "Hello! I am sending this message from a servlet cuz " +
                "You have requested for a new password from our application ! .";


        String resultMessage = "";

        try {
            Email.sendEmail(host, port, user, pass, recipient, subject, content);
            resultMessage = "The email was sent successfully";
        } catch (Exception e) {
            e.printStackTrace();
            resultMessage = "There is an error\t" + e.getMessage();
        } finally {
            request.setAttribute("Message", resultMessage);
            getServletContext().getRequestDispatcher("/Result.jsp").forward(request, response);
        }
    }
}
