package SDP.Ass5;

import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class EmailSender {
    public static void sendReceipt(String toEmail, String customerName, double amount) {
        final String fromEmail = "erkowok2006@gmail.com";
        final String password = "dsgm pemf ovgs ucjg";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail, "Brxlq Checkout System"));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            msg.setSubject("Your Order Receipt");
            msg.setText("Hello " + customerName + ",\n\n"
                    + "Thank you for your purchase!\n"
                    + "Your order total: $" + amount + "\n\n"
                    + "Best regards,\nBrxlq Team");

            Transport.send(msg);
            System.out.println(" Email successfully sent to " + toEmail);
        } catch (Exception e) {
            System.out.println(" Failed to send email: " + e.getMessage());
        }
    }
}
