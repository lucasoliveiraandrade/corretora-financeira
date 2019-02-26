package br.com.brq.prova.service;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.brq.prova.dto.EmailDTO;
import br.com.brq.prova.model.Usuario;
import br.com.brq.prova.util.EmailUtil;

@Service
public class EmailService {

	@Value("${email.from}")
	private String from;

	@Value("${email.user}")
	private String user;

	@Value("${email.password}")
	private String password;

	@Value("${email.smtp.host}")
	private String host;

	@Value("${email.ativado}")
	private boolean envioEmailAtivado;

	@Autowired
	private EmailUtil emailUtil;

	@Async
	public void enviar(Usuario usuario) throws AddressException, MessagingException {
		if (!envioEmailAtivado) {
			return;
		}

		Properties properties = getProperties();

		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		EmailDTO emailDTO = emailUtil.criaEmailDTO(usuario);

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(emailDTO.getPara()));
		message.setSubject(emailDTO.getTitulo());
		message.setText(emailDTO.getCorpo());
		Transport.send(message);
	}

	private Properties getProperties() {
		Properties prop = new Properties();
		prop.setProperty("mail.smtp.host", host);
		prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.setProperty("mail.smtp.socketFactory.fallback", "false");
		prop.setProperty("mail.smtp.port", "465");
		prop.setProperty("mail.smtp.socketFactory.port", "465");
		prop.setProperty("mail.pop3.socketFactory.fallback", "false");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.debug", "true");
		prop.put("mail.store.protocol", "pop3");
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.debug.auth", "true");
		return prop;
	}
}
