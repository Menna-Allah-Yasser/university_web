package MailServices;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class Mail {
  public void sendEmail(String receiver) throws Exception , ClassNotFoundException{

      Properties pro=new Properties();
      pro.put("mail.smtp.auth" , true);
      pro.put("mail.smtp.host" , "smtp.gmail.com");
      pro.put("mail.smtp.port" ,587);
      pro.put("mail.smtp.starttls.enable",true);
      pro.put("mail.transport.protocol","smtp");

      Session session = Session.getInstance(pro, new Authenticator() {
          @Override
          protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication("yassermna51@gmail.com", "menna100100");
          }
      });
      Message message=new MimeMessage(session);
      message.setSubject("Reset Password");

      Address addressTo = new InternetAddress(receiver);
      message.setRecipient(Message.RecipientType.TO ,addressTo);

      MimeMultipart multi=new MimeMultipart();

     // MimeBodyPart attachment=new MimeBodyPart();
     // attachment.attachFile(new File(src/main/webapp/mailbody.html));

      MimeBodyPart attachment2=new MimeBodyPart();
      attachment2.setContent("<h1>you forget your password!!</h1>" , "text/html");

      //multi.addBodyPart(attachment);
      multi.addBodyPart(attachment2);
      message.setContent(multi);

      Transport.send(message);



  }
}
