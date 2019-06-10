package com.yc.loginregister.myexception;

/**
 * @author LX
 * @date 2019/5/26 - 21:34
 */
public class LoginException extends Exception {

	private static final long serialVersionUID = 1L;

	public LoginException() {
    }

    public LoginException(String message) {
        super(message);
    }
}
