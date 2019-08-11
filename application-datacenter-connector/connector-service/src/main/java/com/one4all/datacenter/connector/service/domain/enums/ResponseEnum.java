package com.one4all.datacenter.connector.service.domain.enums;

/**
 * type(key,value)
 * @author xiaoqing.liu
 *
 */
public enum ResponseEnum {
	
    /** 成功 */  
    SUCCESS("0", "操作成功！"),
    
    /** 失败 */  
    FAIL("1", "操作失败！"),
      
    /** 没有登录 */  
    NOT_LOGIN("10", "用户未登录！"),
    
    /** AuthCode错误 */  
    INVALID_AUTHCODE("11", "认证凭据错误！"),
    
    /** 发生异常 */  
    EXCEPTION("12", "系统异常！"),
      
    /** 系统错误 */  
    SYS_ERROR("13", "系统错误！"),
      
    /** 参数错误 */  
    PARAMS_ERROR("14", "传入参数错误！"),
      
    /** 不支持或已经废弃 */  
    NOT_SUPPORTED("20", "接口不支持或已经废弃！"),
  
    /** 太频繁的调用 */  
    TOO_FREQUENT("21", "调用过于频繁！"),
    
    /** 数据库操作失败 */  
    DATABASE_ERROR("31", "数据库操作失败！"),
      
    /** 未知的错误 */  
    UNKNOWN_ERROR("99", "未知错误！"),

    /** 无意义的一个值，仅用于设置默认值*/
    NULL("-1", "");
	
    private String code;
    
    private String message;

    public String getCode() {
        return code;
    }
    
    public String getMessage() {
    	return message;
    }

    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String valueOfMessage(String code) {
        for (ResponseEnum response : ResponseEnum.values()) {
            if (response.getCode().equalsIgnoreCase(code)) {
                return response.getMessage();
            }
        }
        return null;
    }
    
    public static String valueOfCode(String message) {
        for (ResponseEnum response : ResponseEnum.values()) {
            if (response.getMessage().equalsIgnoreCase(message)) {
                return response.getCode();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "{code:"+this.code + ",message:" + this.message+"}";
    }
}
