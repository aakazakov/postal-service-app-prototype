package dev.fun.app.exceptions;

/**
 * Thrown to indicate that the required entity credentials are null or invalid.
 */
public class IncorrectlyFilledCredentialsException extends Exception {

	private static final long serialVersionUID = 1L;

	public IncorrectlyFilledCredentialsException() {
		super();
	}
	
	public IncorrectlyFilledCredentialsException(String msg) {
		super(msg);
	}
	
}
