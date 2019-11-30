package com.stationary.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorReponse {

	private String code;

	private String message;

	private String stacktrace;

	public ErrorReponse() {
	}

	public ErrorReponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ErrorReponse(String code, String message, String stacktrace) {
		this(code,message);
		this.stacktrace = stacktrace;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStacktrace() {
		return stacktrace;
	}

	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}

	
}
