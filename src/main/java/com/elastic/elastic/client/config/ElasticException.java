package com.elastic.elastic.client.config;

public class ElasticException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int errorCode = ErrorCode.UNKNOWN;

	public ElasticException(int errorCode) {
		super();

		setErrorCode(errorCode);
	}

	public ElasticException(String message) {
		super(message);
	}

	public ElasticException(int errorCode, String message) {
		super(message);

		setErrorCode(errorCode);
	}

	public ElasticException(String message, Throwable cause) {
		super(message, cause);
	}

	public ElasticException(int errorCode, String message, Throwable cause) {
		super(message, cause);

		setErrorCode(errorCode);
	}

	public ElasticException(Throwable cause) {
		super(cause);
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
