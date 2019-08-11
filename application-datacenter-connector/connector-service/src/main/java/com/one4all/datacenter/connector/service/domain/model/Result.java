package com.one4all.datacenter.connector.service.domain.model;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.one4all.datacenter.connector.service.domain.enums.ResponseEnum;

public class Result implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String code;
    
    private String message;
    
    private Object data;
    
    public Result() {
    	
    }
    
    public Result(String code, String message, Object data) {
    	this.code = code;
    	this.message = message;
    	this.data = data;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String toJSONString()
    {
    	JSONObject json = new JSONObject();
    	if(code != null ){
    		json.put("code", code);
    	}else{
    		code = "NULL";
    		json.put("code", "");
    	}
    	if(message != null && message.length() > 0){
    		json.put("message", message);
    	}else{
    		json.put("message", ResponseEnum.valueOfMessage(code));
    	}
    	if(data != null ){
    		json.put("data", data);
    	}else{
    		json.put("data", "");
    	}
        return json.toJSONString();
    }

}
