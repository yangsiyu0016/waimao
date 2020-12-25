package com.wg.waimao.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.wg.waimao.config.UserLoginToken;
import com.wg.waimao.entity.UserMessage;
import com.wg.waimao.service.UserMessageService;

/**
 * 
 *
 * @author chenshun
 * @email 18600409059@163.com
 * @date 2020-12-08 22:43:17
 */
@RestController
@RequestMapping("userMessage")
public class UserMessageController {
	@Autowired
	private UserMessageService service;

	/**
	 * 列表
	 */
	@UserLoginToken
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public List<UserMessage> selectAll(@RequestParam Map<String, Object> params) {
		return service.selectAll();
	}
	@UserLoginToken
	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public UserMessage selectByPrimaryKey(@RequestParam Map<String, Object> params) {
		return service.selectByPrimaryKey((String)params.get("id"));
	}
	@UserLoginToken
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public int insert(@RequestBody UserMessage UserMessage) {
//		UserMessage UserMessage = JSON.parseObject(JSON.toJSONString(params), UserMessage.class);
		UserMessage.setId(UUID.randomUUID().toString());
		return service.insert(UserMessage);
	}
	@UserLoginToken
	@RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.GET)
	 public int deleteByPrimaryKey(@RequestParam String id) {
		 return service.deleteByPrimaryKey(id);
	 } 
	@UserLoginToken
	@RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
	 public int updateByPrimaryKey(@RequestBody UserMessage UserMessage) {
//		UserMessage UserMessage = JSON.parseObject(JSON.toJSONString(params), UserMessage.class);
		 return service.updateByPrimaryKey(UserMessage);
	 }
	
	
}
