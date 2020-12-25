package com.wg.waimao.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wg.waimao.config.UserLoginToken;
import com.wg.waimao.entity.Admin;
import com.wg.waimao.service.AdminService;
import com.wg.waimao.service.TokenService;
import com.wg.waimao.utils.TokenUtil;

/**
 * 
 *
 * @author chenshun
 * @email 18600409059@163.com
 * @date 2020-12-08 22:43:17
 */
@RestController
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private AdminService service;
	@Autowired
	private TokenService tokenService;
	
	

	/**
	 * 列表
	 */
	@UserLoginToken
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public List<Admin> selectAll(@RequestParam Map<String, Object> params) {
		return service.selectAll();
	}
	@UserLoginToken
	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public Admin selectByPrimaryKey(@RequestParam Map<String, Object> params) {
		return service.selectByPrimaryKey((String)params.get("id"));
	}
	@UserLoginToken
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public int insert(@RequestBody Admin Admin) {
//		Admin Admin = JSON.parseObject(JSON.toJSONString(params), Admin.class);
		Admin.setId(UUID.randomUUID().toString());
		return service.insert(Admin);
	}
	@UserLoginToken
	@RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.GET)
	 public int deleteByPrimaryKey(@RequestParam String id) {
		 return service.deleteByPrimaryKey(id);
	 } 
	@UserLoginToken
	@RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
	 public int updateByPrimaryKey(@RequestBody Admin Admin) {
//		Admin Admin = JSON.parseObject(JSON.toJSONString(params), Admin.class);
		 return service.updateByPrimaryKey(Admin);
	 }
	
	
	// 登录
		@RequestMapping(value = "/login" ,method = RequestMethod.POST)
		public Object login(@RequestBody Admin user, HttpServletResponse response) {
			JSONObject jsonObject = new JSONObject();
			Admin userForBase = service.selectByUserName(user.getUserName());
			if (!userForBase.getPassword().equals(user.getPassword())) {
				jsonObject.put("message", "登录失败,密码错误");
				return jsonObject;
			} else {
				String token = tokenService.getToken(userForBase);
				jsonObject.put("token", token);

				Cookie cookie = new Cookie("token", token);
				cookie.setPath("/");
				response.addCookie(cookie);

				return jsonObject;

			}
		}
		@UserLoginToken
		@RequestMapping(value = "/getMessage" ,method = RequestMethod.GET)
		public String getMessage() {

			// 取出token中带的用户id 进行操作
			System.out.println(TokenUtil.getTokenUserId());

			return "您已通过验证";
		}

}
