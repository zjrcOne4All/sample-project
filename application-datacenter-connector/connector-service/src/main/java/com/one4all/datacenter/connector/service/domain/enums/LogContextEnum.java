/**
 * <p>Title: LogInfoEnum.java</p>
 * <p>Description:</p>
 * <p>Company: www.sunyard.com</p>
 * @author Liuxq
 * @date 2018年10月13日
 * @version 1.0
 */
package com.one4all.datacenter.connector.service.domain.enums;

/**
 * @author Will Liu
 * 无状态变化的统一定义为读操作，有状态变化的统一定义为写操作
 *
 */
public enum LogContextEnum {
	
	ACTION_UNKNOWN("未知操作"),
	
	ACTION_READ("读操作"),
	
	ACTION_READ_QUERY("查询操作"),
	
	ACTION_READ_DOWNLOAD("下载操作"),
	
	ACTION_WRITE("写操作"),
	
	ACTION_WRITE_UPLOAD("上传操作"),
	
	ACTION_WRITE_CREATE("创建操作"),
	
	ACTION_WRITE_MODIFY("修改操作"),
	
	ACTION_WRITE_SAVE("保存操作"),
	
	ACTION_WRITE_DELETE("删除操作"),
	
	ACTION_WRITE_TRIGGER("触发操作"),
	
	ACTION_WRITE_CALLBACK("回调操作"),
	
	ACTION_WRITE_INVOKING("调用操作"),
	
	ACTION_WRITE_TRANSFER("传递操作"),
	
	ACTION_WRITE_EXCUTION("执行操作"),
	
	STAGE_BEFORE("前置处理阶段"),
	
	STAGE_ARROUND("环绕处理阶段"),
	
	STAGE_AFTER("后置处理阶段"),
	
	STAGE_RETURN("返回处理阶段"),
	
	STAGE_EXCEPTION("异常处理阶段"),
	
	STATE_READY("就绪"),
	
	STATE_PROCESSING("执行中"),
	
	STATE_SUSPEND("挂起"),
	
	STATE_TIMEOUT("超时"),
	
	STATE_CANCEL("取消"),
	
	STATE_COMPLETE("完成"),
	
	STATE_ERROR("异常"),
	
	TAG_DB("数据库"),
	
	TAG_PAGED("分页"),
	
	TAG_CACHED("缓存"),
	
	TAG_THREAD("线程"),
	
	TAG_UNSYNC("异步"),
	
	TAG_REMOTE("远程"),
	
	TAG_ANALISE("解析"),
	
	TAG_MQ("消息队列");
	
	private final String value;
	
	public String getValue() {
		return value;
	}
	
	LogContextEnum(String value) {
		this.value = value;
	}

}
