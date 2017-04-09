package br.com.alura.listavip.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Value("${email.host.name}")
	private String emailHostName;
	
	@Value("${email.smtp.port}")
	private String emailSmtpPort;
	
	@Value("${email.user}")
	private String emailUser;
	
	@Value("${email.password}")
	private String emailPassword;
	
	@Value("${email.from}")
	private String emailFrom;
	
	public void enviar(String nome, String enderecoEmail) {
		try {
            Email email = new SimpleEmail();
            email.setHostName(emailHostName);
            email.setSmtpPort(Integer.valueOf(emailSmtpPort));
            email.setAuthenticator(new DefaultAuthenticator(emailUser, emailPassword));
            email.setSSLOnConnect(true);

            email.setFrom(emailFrom);
            email.setSubject("Você foi convidado pelo ListaVIP");
            email.setMsg("Olá " + nome + ". Você acaba de ser convidado pelo ListaVIP.");
            email.addTo(enderecoEmail);
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
        }
	}
	
}

