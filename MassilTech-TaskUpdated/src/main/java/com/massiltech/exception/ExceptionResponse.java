
package com.massiltech.exception;

import org.springframework.stereotype.Component;

@Component
public class ExceptionResponse {

	private int statusCode;
	private String msg;
	private String path;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ExceptionResponse() {
	}

	public ExceptionResponse(int statusCode, String msg, String path) {
		super();
		this.statusCode = statusCode;
		this.msg = msg;
		this.path = path;
	}

}
