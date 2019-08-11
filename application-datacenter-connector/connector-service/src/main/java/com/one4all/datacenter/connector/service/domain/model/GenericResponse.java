package com.one4all.datacenter.connector.service.domain.model;

import com.one4all.datacenter.connector.service.domain.enums.ResponseEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用响应
 * @param <T>
 */
public class GenericResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    //
    private String code;

    private String message;

    // 错误类型，如果是BUSI_ERROR，则为业务异常，业务异常不打印异常日志。
    private Enum errorType;

    private T result;


    public GenericResponse() {
        this.code = "-1";
        this.message = ResponseEnum.valueOfMessage(code);
        this.errorType = ResponseEnum.NULL;
    }

    public GenericResponse(String code, String message, Enum errorType, T result) {
        this.code = code;
        this.message = message;
        this.errorType = errorType;
        this.result = result;
    }

    public String getCode() {
        if(code != null ){
            return code;
        }
        return "";
    }

    public void setCode(String code) {
        if(code != null ){
            this.code = code;
        }else {
            this.code = "-1";
        }
    }

    public String getMessage() {
        if(message != null && message.length() > 0){
            return message;
        }
        return ResponseEnum.valueOfMessage(code);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Enum getErrorType() {
        return errorType;
    }

    public void setErrorType(Enum errorType) {
        this.errorType = errorType;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}