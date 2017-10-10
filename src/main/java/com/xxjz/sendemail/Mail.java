package com.xxjz.sendemail;


import java.io.Serializable;

public class Mail implements Serializable {
	private static final long serialVersionUID = -543077416549260588L;
	private String sendTo;
	private String subject;
	private String text;

	public String getSendTo() {
		return sendTo;
	}
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Mail() {
		super();
	}
	
	
}
