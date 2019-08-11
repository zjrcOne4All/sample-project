package com.one4all.datacenter.connector.service.controller;

import java.util.List;

import com.one4all.datacenter.connector.service.annotation.GenericResponseBody;
import com.one4all.datacenter.connector.service.domain.entity.bookplat.SysUser;
import com.one4all.datacenter.connector.service.domain.entity.h2.BiOrderTable;
import com.one4all.datacenter.connector.service.domain.entity.h2.SystemUser;
import com.one4all.datacenter.connector.service.domain.model.GenericResponse;
import com.one4all.datacenter.connector.service.domain.model.dto.FindOrderListResponse;
import com.one4all.datacenter.connector.service.domain.model.dto.UserInfoDTO;
import com.one4all.datacenter.connector.service.service.Impl.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.one4all.datacenter.connector.service.domain.model.Result;
import com.one4all.datacenter.connector.service.domain.enums.ResponseEnum;
import com.one4all.datacenter.connector.service.domain.entity.cm12580.UserInfo;

/**
 * Api调用样例代码
 * @author xiaoqing.liu
 *
 */
@Api(value = "样例服务接口",tags="测试")
@RestController
@RequestMapping(value="/sample")
public class SampleController {

	@Autowired
	private SampleService sampleService;

	@ApiOperation(value="查询所有系统用户信息", notes="使用传统url参数拼接方式传参->apiUrl+?currentPage=2&pageSize=5", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value="/getAllSysUsers")
	@ApiImplicitParams({
			@ApiImplicitParam(name="currentPage",value="当前页码",dataType="string", paramType = "query"),
			@ApiImplicitParam(name="pageSize",value="每页记录数",dataType="string", paramType = "query")})
	public String findSysUser(@RequestParam String currentPage, @RequestParam String pageSize) {
		Result result = new Result();
		try {
			PageInfo<SysUser> pageInfo = sampleService.getSysUserAll(currentPage, pageSize);
			//List<SysUser> list = sampleService.getSysUserAll(currentPage, pageSize);
			result.setCode(ResponseEnum.SUCCESS.getCode());
			result.setData(pageInfo);
		} catch (Exception e) {
			result.setCode(ResponseEnum.EXCEPTION.getCode());
			result.setData(null);
			e.printStackTrace();
		}
		return result.toJSONString();
	}

	@ApiOperation(value="查询系统用户信息", notes="使用传统url参数拼接方式传参->apiUrl+?name=李四", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value="/getSystemUser")
	@ApiImplicitParams({
			@ApiImplicitParam(name="userName",value="用户姓名",dataType="string", paramType = "query")})
	public String findSystemUser(@RequestParam String userName) {
		Result result = new Result();
		try {
			SystemUser user = sampleService.getSystemUser(userName);
			result.setCode(ResponseEnum.SUCCESS.getCode());
			result.setData(user);
		} catch (Exception e) {
			result.setCode(ResponseEnum.EXCEPTION.getCode());
			result.setData(null);
			e.printStackTrace();
		}
		return result.toJSONString();
	}

	@ApiOperation(value="查询所有用户信息", notes="使用url模板映射入参->apiUrl/{currentPage}/{pageSize}", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value="/getAllUsers/{currentPage}/{pageSize}")
	public GenericResponse<PageInfo<UserInfo>> findUser(
			@ApiParam(name = "currentPage",value = "当前页号",required = true)
			@PathVariable String currentPage,
			@ApiParam(name = "pageSize",value = "每页记录数",required = true)
			@PathVariable String pageSize) {
		GenericResponse<PageInfo<UserInfo>> response = new GenericResponse();
		try {
			PageInfo<UserInfo> pageInfo = sampleService.getUserAll(currentPage, pageSize);
			response.setCode(ResponseEnum.SUCCESS.getCode());
			response.setResult(pageInfo);
		} catch (Exception e) {
			response.setCode(ResponseEnum.EXCEPTION.getCode());
			e.printStackTrace();
		}
		return response;
	}

	@ApiOperation(value="查询所有订单信息", notes="没有传入参数，也不对查询结果使用分页", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value="/getAllOrders")
	@GenericResponseBody
	public FindOrderListResponse findOrder() {
		FindOrderListResponse response = new FindOrderListResponse();
		try {
			List<BiOrderTable> orderList = sampleService.getOrderAll();
			response.setOrderList(orderList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
