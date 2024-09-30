package util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
//	 Password: jjrx iyji jukt hbis
	// TLS và SSL trong email
	static String from = "s.gintoki710@gmail.com";
	static String password = "jjrx iyji jukt hbis";

	public static void email(String to, String title, String content) {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
		props.put("mail.smtp.port", "587"); // TLS 587, SSL 465
		props.put("mail.smtp.auth", "true"); // enable authentication
		props.put("mail.smtp.starttls.enable", "true"); // enable starttls

		// create authenticator
		Authenticator auth = new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, password);
			}
		};

		// Session
		Session session = Session.getInstance(props, auth);

		try {
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");

			msg.setFrom(from);

			// Recipient
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			// Title
			msg.setSubject(title);
			msg.setSentDate(new Date());
			// set reply

			// Content
			msg.setContent(content, "text/HTML; charset=UTF-8");

			Transport.send(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		String content = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<style>\r\n" + "table, th, td {\r\n"
				+ "  border: 1px solid black;\r\n" + "}\r\n" + "</style>\r\n" + "</head>\r\n" + "<body>\r\n" + "\r\n"
				+ "<h1>The tr element</h1>\r\n" + "\r\n" + "<p>The tr element defines a row in a table:</p>\r\n"
				+ "\r\n" + "<table>\r\n" + "  <tr>\r\n" + "    <th>Month</th>\r\n" + "    <th>Savings</th>\r\n"
				+ "  </tr>\r\n" + "  <tr>\r\n" + "    <td>January</td>\r\n" + "    <td>$100</td>\r\n" + "  </tr>\r\n"
				+ "  <tr>\r\n" + "    <td>February</td>\r\n" + "    <td>$80</td>\r\n" + "  </tr>\r\n" + "</table>\r\n"
				+ "\r\n" + "</body>\r\n" + "</html>";
		int i = 0;
		while(i < 10) {
			Email.email("duclan0710@gmail.com", "time: " + System.currentTimeMillis() , content);
			i++;
		}
	}
}
