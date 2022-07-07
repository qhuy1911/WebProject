package mail;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.Account;
import model.Item;
import model.Order;

public class SendMail {
	public static void send(String email, Order order, List<Item> list) {
		Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", MailConfig.HOST_NAME);
        props.put("mail.smtp.socketFactory.port", MailConfig.SSL_PORT);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.port", MailConfig.SSL_PORT);
 
        // get Session
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MailConfig.APP_EMAIL, MailConfig.APP_PASSWORD);
            }
        });
 
        // compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Shop Online Order");
            message.setHeader("Content-Type", "text/plain;charset=UTF-8");
            String content = "Dear " + order.getName() + "\n";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm dd/MM/yyyy");
            content += "You placed an order on Shop Online website at " + simpleDateFormat.format(order.getDate()) + ". Please check your order infomation: \n";
            for (Item item : list) {
            	content += "\t- " + item.getProduct().getName() + "\tx\t" + item.getQuantity() + "\n";            	
            }
            content += "The order total is " + order.getTotal() +"$. The order is delivering to you.\n\n";
            content += "Thank you,";
            message.setText(content);
 
            // send message
            Transport.send(message);
 
            System.out.println("Message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
	}
}
