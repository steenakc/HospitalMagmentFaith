package com.faith.app.common;

public class AccessDeniedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;// userdefined exception

	public AccessDeniedException(String messge) {
		super(messge);

	}

}
