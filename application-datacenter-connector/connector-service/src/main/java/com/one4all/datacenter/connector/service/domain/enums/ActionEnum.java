/**
 * <p>Title: ActionType.java</p>
 * <p>Description:</p>
 * <p>Company: www.sunyard.com</p>
 * @author Liuxq
 * @date 2018年10月3日
 * @version 1.0
 */
package com.one4all.datacenter.connector.service.domain.enums;

/**
 * @author Will Liu
 *
 */
public enum ActionEnum {
	
	ACTION_UNKNOWN("未知操作"),
	/** 创建 */
	ACTION_CREATE("创建操作"),
	
	ACTION_MODIFY("修改操作"),
	
	ACTION_QUERY("查询操作"),
	
	ACTION_SAVE("保存操作"),
	
	ACTION_DELETE("删除操作"),
	
	ACTION_UPLOAD("上传操作"),
	
	ACTION_DOWNLOAD("下载操作"),
	
	ACTION_TRIGGER("触发操作"),
	
	ACTION_CALLBACK("回调操作"),
	
	ACTION_INVOKING("调用操作"),
	
	ACTION_TRANSFER("传递操作"),
	
	ACTION_EXCUTION("执行操作"),
	
	ACTION_CALL_ZJZWFW_POPINFO("调用浙江省人口信息查询接口"),
	
	ACTION_CALL_ZJZWFW_NATIONAL_POPINFO("调用国家人口基础信息查询接口"),
	
	ACTION_CALL_ZJZWFW_PHOTOINFO("调用浙江省人口照片路径信息查询"),
	
	ACTION_CALL_ZJZWFW_APPSECRET("调用浙江省政务服务获取密钥接口");
	
	private final String action;
	
	public String getAction() {
		return action;
	}
	
	ActionEnum(String action) {
		this.action = action;
	}

}
