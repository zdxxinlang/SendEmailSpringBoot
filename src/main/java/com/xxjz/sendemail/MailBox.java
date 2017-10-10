package com.xxjz.sendemail;


import java.io.Serializable;

public class MailBox implements Serializable {
	private static final long serialVersionUID = -543077416549260588L;
	private String mailSmtpAuth;          // SMTP��������֤
	private String mailSmtpHost;          //SMTP������
	private String mailSmtpPort;          //�˿ںţ�QQ���������� ��˿�
	private String mailUser;              //�˺�
	private String mailPassword;          //����
	public String getMailSmtpAuth() {
		return mailSmtpAuth;
	}
	public void setMailSmtpAuth(String mailSmtpAuth) {
		this.mailSmtpAuth = mailSmtpAuth;
	}
	public String getMailSmtpHost() {
		return mailSmtpHost;
	}
	public void setMailSmtpHost(String mailSmtpHost) {
		this.mailSmtpHost = mailSmtpHost;
	}
	public String getMailSmtpPort() {
		return mailSmtpPort;
	}
	public void setMailSmtpPort(String mailSmtpPort) {
		this.mailSmtpPort = mailSmtpPort;
	}
	public String getMailUser() {
		return mailUser;
	}
	public void setMailUser(String mailUser) {
		this.mailUser = mailUser;
	}
	public String getMailPassword() {
		return mailPassword;
	}
	public void setMailPassword(String mailPassword) {
		this.mailPassword = mailPassword;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
