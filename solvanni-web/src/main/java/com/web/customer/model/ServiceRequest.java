package com.web.customer.model;

import java.io.Serializable;

public class ServiceRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2331307404151448988L;
	private String status = "FAILURE";
	private String responseMessage;
	private Integer count;
	private Object resObject;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the responseMessage
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * @param responseMessage
	 *            the responseMessage to set
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	/**
	 * @return the resObject
	 */
	public Object getResObject() {
		return resObject;
	}

	/**
	 * @param resObject
	 *            the resObject to set
	 */
	public void setResObject(Object resObject) {
		this.resObject = resObject;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ServiceRequest [status=" + status + ", responseMessage=" + responseMessage + ", count="
				+ count + ", resObject=" + resObject + "]";
	}

}
