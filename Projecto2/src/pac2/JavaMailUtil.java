package pac2;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;


public class JavaMailUtil {
	
	

	public static void sendMail(String idReserva, String correo) throws AddressException, MessagingException {
		// TODO Auto-generated method stub
		System.out.println("Enviando email");
		
		
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		//prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		Session session = Session.getInstance(prop, new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		        String username = "jorgetomasmarco24@gmail.com";
				String pass= "jqoeecuucwwlejmm";
				String pass2= "Tormenta24";
				return new PasswordAuthentication(username, pass);
		    }
		});
		Message message = new MimeMessage(session);	
		message.setFrom(new InternetAddress("jorgetomasmarco24@gmail.com"));
		//message.setRecipients(
		  //Message.RecipientType.TO, InternetAddress.parse(correo));
		message.setRecipients(
				  Message.RecipientType.TO, InternetAddress.parse("jorgetomasmarco@hotmail.com"));
		message.setSubject("Mail Subject");

		String msg = "El id reserva es "+ idReserva + " ve a la pagina web y confirma la reserva el usuario es tu telefono y la contraseña el correo";

		MimeBodyPart mime= new MimeBodyPart();
		
		mime.setContent(msg, "text/html; charset=utf-8");

		Multipart multi = new MimeMultipart();
		multi.addBodyPart(mime);
		message.setContent(multi);
		
		Transport.send(message);
		
	}

}
