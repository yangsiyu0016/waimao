package com.wg.waimao.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.wg.waimao.config.UserLoginToken;
import com.wg.waimao.entity.Product;
import com.wg.waimao.entity.ProductType;
import com.wg.waimao.service.ProductTypeService;

/**
 * 
 *
 * @author chenshun
 * @email 18600409059@163.com
 * @date 2020-12-08 22:43:17
 */
@RestController
@RequestMapping("productType")
public class ProductTypeController {
	@Autowired
	private ProductTypeService service;

	/**
	 * 列表
	 */
	@UserLoginToken
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public List<ProductType> selectAll(@RequestParam Map<String, Object> params) {
		return service.selectAll();
	}
	
	
	
}
