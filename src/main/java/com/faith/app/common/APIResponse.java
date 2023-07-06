package com.faith.app.common;

public class APIResponse {

	private Integer status = 200;
	private String message;
	private Object data;
	private Object error;// to store error messages
	private boolean hasData;

	public APIResponse() {
		super();
	}

	public APIResponse(boolean hasData, String message) {
		super();
		this.setHasData(hasData);
		this.message = message;
	}

	public APIResponse(boolean hasData, String message, Object data) {
		super();
		this.setHasData(hasData);
		this.message = message;
		this.data = data;
	}

	public APIResponse(boolean hasData, String message, Object data, Object error) {
		super();
		this.setHasData(hasData);
		this.message = message;
		this.data = data;
		this.error = error;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isHasData() {
		return hasData;
	}

	public void setHasData(boolean hasData) {
		this.hasData = hasData;
	}

}
