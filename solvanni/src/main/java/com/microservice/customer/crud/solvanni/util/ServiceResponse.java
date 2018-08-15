package com.microservice.customer.crud.solvanni.util;

import java.io.Serializable;

public class ServiceResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4772273860608515215L;
	private Object resObject;
	private String responseMessage;
	private String status;
	private Integer count;

	public Object getResObject() {
		return resObject;
	}

	public void setResObject(Object resObject) {
		this.resObject = resObject;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
