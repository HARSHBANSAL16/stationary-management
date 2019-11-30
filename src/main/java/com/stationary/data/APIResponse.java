package com.stationary.data;

import org.apache.logging.log4j.message.Message;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@ResponseBody
@JsonIgnoreProperties(ignoreUnknown = true)
public class APIResponse {

	@JsonProperty("status")
	private Integer status;
	
	@JsonProperty("error")
	private ErrorReponse error;
	
	@JsonProperty("result_set")
	private Object resultSet;
	
	@JsonProperty("msg")
	private Message msg;
	
	public APIResponse() {
	}
	
	public APIResponse(ErrorReponse er) {
		this.error = er;
		this.status = API.STATUS.ERROR.value;
	}
	
	public APIResponse(Object rs) {
		this.resultSet = rs;
		this.status = API.STATUS.SUCCESS.value;
	}
	
	public APIResponse(Object rs, API.STATUS status, Message msg) {
		this.resultSet = rs;
		this.status = status.value;
		this.msg =  msg;
	}

	public APIResponse(Object rs, Message msg) {
		this.resultSet = rs;
		this.status = API.STATUS.SUCCESS.value;
		this.msg =  msg;
	}


	@Override
	public String toString() {
		return "APIResponse [status=" + status + ", error=" + error + ", resultSet=" + resultSet + ", msg=" + msg
				+ ", getStatus()=" + getStatus() + ", getError()=" + getError() + ", getResultSet()=" + getResultSet()
				+ ", getMsg()=" + getMsg() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public ErrorReponse getError() {
		return error;
	}

	public void setError(ErrorReponse error) {
		this.error = error;
	}

	public Object getResultSet() {
		return resultSet;
	}

	public void setResultSet(Object resultSet) {
		this.resultSet = resultSet;
	}

	public Message getMsg() {
		return msg;
	}

	public void setMsg(Message msg) {
		this.msg = msg;
	}
}
