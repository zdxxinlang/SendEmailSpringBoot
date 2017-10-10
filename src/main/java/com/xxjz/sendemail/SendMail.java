package com.xxjz.sendemail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;



public class SendMail {

	private static volatile SendMail singleton = null;
	private MailBox mailBox = new MailBox();
	private Mail mail = new Mail();


	private SendMail() {
	}

	public static SendMail getSingleton() {
		if (singleton == null) {
			synchronized (SendMail.class) {
				if (singleton == null) {
					singleton = new SendMail();
				}
			}
		}
		return singleton;
	}

	public void setProperties(MailBox b) {
		this.mailBox = b;
	}
	
	public void setMail(Mail b) {
		this.mail = b;
	}

	public void sendQQSmtpEmail() throws Exception {
		// 创建Properties 类用于记录邮箱的一些属性
		final Properties props = new Properties();
		// 表示SMTP发送邮件，必须进行身份验证
		props.put("mail.smtp.auth", mailBox.getMailSmtpAuth());
		// 此处填写SMTP服务器
		props.put("mail.smtp.host", mailBox.getMailSmtpHost());
		// 端口号，QQ邮箱给出了两个端口
		props.put("mail.smtp.port", mailBox.getMailSmtpPort());
		// 此处填写你的账号
		props.put("mail.user", mailBox.getMailUser());
		// 此处的密码就是前面说的16位STMP口令
		props.put("mail.password", mailBox.getMailPassword());

		// 构建授权信息，用于进行SMTP进行身份验证
		Authenticator authenticator = new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				// 用户名、密码
				String userName = props.getProperty("mail.user");
				String password = props.getProperty("mail.password");
				return new PasswordAuthentication(userName, password);
			}
		};
		// 使用环境属性和授权信息，创建邮件会话
		Session mailSession = Session.getInstance(props, authenticator);
		// 创建邮件消息
		MimeMessage message = new MimeMessage(mailSession);
		// 设置发件人
		InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
		message.setFrom(form);

		// 设置收件人的邮箱
		InternetAddress to = new InternetAddress(mail.getSendTo());
		message.setRecipient(RecipientType.TO, to);

		// 设置邮件标题
		message.setSubject(mail.getSubject());

		// 设置邮件的内容体
		message.setContent(mail.getText(), "text/html;charset=UTF-8");

		// 最后当然就是发送邮件啦
		Transport.send(message);
	}

}
