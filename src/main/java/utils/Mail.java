package utils;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class Mail {

    /**
     * @param args
     * @param msg
     * @param to
     * @return Boolean true or false
     * @throws Exception
     * @author : NISHANT PAUL || 9th JAN 2019
     */


    public static Boolean sendmailAttachment(String args, String msg, String to) throws Exception {

        String fileAttachment = args;

        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");

        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("******@gmail.com", "Password of your email"); // Enter your Gmail id and Password
            }
        });

        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress("******@gmail.com"));  // Enter your email id
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Demo_0109_1704.html");   // Enter the automation file name with .html extension
            message.setText(msg);

            MimeBodyPart messageBodyPart = new MimeBodyPart();

            // TODO Write the body of the email
            messageBodyPart.setText("BODY OF THE EMAIL"); // Enter the body of the email
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(fileAttachment);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(msg);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Message sent");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("exception in Send Mail");
            return false;
        }
        return true;
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {


        //  Enter the report name with " . "  extension
        sendmailAttachment(System.getProperty("user.dir") + "/test-output/Demo_0109_1704.html", "Demo_0109_1704.html", "****@gmail.com,*****@gmail.com");


    }
}

