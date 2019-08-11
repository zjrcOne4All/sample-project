package com.one4all.datacenter.connector.service.domain.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.alibaba.fastjson.JSONObject;
import com.one4all.datacenter.connector.service.domain.entity.cm12580.UserInfo;

@ApiModel(value="用户信息",description="客户信息参数传输与映射模板")
public class UserInfoDTO {
	
	@ApiModelProperty(value="用户工号",name="employeeId",example="12345678")
	private String employeeId;
	
	@ApiModelProperty(value="用户昵称",name="nickName",example="小鱼儿")
	private String nickName;
	
	@ApiModelProperty(value="手机号",name="mobileNo",example="13757100001")
	private String mobileNo;
	
	@ApiModelProperty(value="用户真实姓名",name="userName",example="张三")
	private String userName;
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 将前端传入的复杂类型参数按需要映射到数据表实体类上
	 * @return UserInfo
	 */
	public UserInfo ObjectWrapping() throws Exception{
		UserInfo userInfo = new UserInfo();
		userInfo.setYhgh(employeeId);
		userInfo.setYhxm(nickName);
		userInfo.setYhsjh(mobileNo);
		userInfo.setYhzsxm(userName);
		return userInfo;
	}
	
	public String toJSONString()
    {
    	JSONObject json = new JSONObject();
    	if(employeeId != null ){
    		json.put("employeeId", employeeId);
    	}else{
    		json.put("employeeId", "");
    	}
    	if(nickName != null ){
    		json.put("nickName", nickName);
    	}else{
    		json.put("nickName", "");
    	}
    	if(mobileNo != null ){
    		json.put("mobileNo", mobileNo);
    	}else{
    		json.put("mobileNo", "");
    	}
        return json.toJSONString();
    }

}
