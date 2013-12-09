package com.practicaljava.lesson19;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyMailAuth extends Authenticator{
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("r.zhumagulov@yahoo.com", "!Q@W3e4r");
	}
}
