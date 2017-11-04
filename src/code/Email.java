package code;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JInternalFrame;

public class Email {

    public static void sendMail(String subj, String email, String[] mzg) {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("shihantyrecentre@gmail.com", "123456789#");
            }
        }
        );

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("shihantyrecentre@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subj);
            for (int i = 0; i < mzg.length; i++) {
                message.setText(mzg[i]);
                message.setText("--------------------------");
            }
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Email Sent");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

}
