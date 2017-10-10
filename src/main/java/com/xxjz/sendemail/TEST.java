package com.xxjz.sendemail;

 
public class TEST {
	public static void main(String[] args) throws Exception {
		SendMail sendMail = SendMail.getSingleton();
		MailBox mailBox = new MailBox();
		Mail mail = new Mail();
		mailBox.setMailSmtpAuth("true");
		mailBox.setMailSmtpHost("smtp.qq.com");
		mailBox.setMailSmtpPort("587");
		mailBox.setMailUser("1393565334@qq.com");
		mailBox.setMailPassword("gpbutnthtrvrbabe");
		mail.setSendTo("zdxxinlang@qq.com");
		mail.setText("� � * hello world\n");
		mail.setSubject("����test");
		sendMail.setProperties(mailBox);
		sendMail.setMail(mail);
		sendMail.sendQQSmtpEmail();
	}
}
