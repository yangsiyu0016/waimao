package com.wg.waimao.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.wg.waimao.entity.Product;
import com.wg.waimao.service.ProductService;

/**
 * 
 *
 * @author chenshun
 * @email 18600409059@163.com
 * @date 2020-12-08 22:43:17
 */
@RestController
@RequestMapping("product")
public class ProductController {
	
	 protected static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService service;

	/**
	 * 列表
	 */
//	@UserLoginToken
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public List<Product> selectAll(@RequestParam Map<String, Object> params) {
		return service.selectAll();
	}
	
//	@UserLoginToken
	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	public Product selectByPrimaryKey(@RequestParam Map<String, Object> params) {
		return service.selectByPrimaryKey((String)params.get("id"));
	}
	
//	@UserLoginToken
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public int insert(@RequestBody Product product) {
		logger.info(product.toString());
//		?Product product = JSON.parseObject(JSON.toJSONString(params), Product.class);
		product.setId(UUID.randomUUID().toString());
//		logger.info(product.getCname());
		return service.insert(product);
	}
	
//	@UserLoginToken
	@RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.GET)
	 public int deleteByPrimaryKey(@RequestParam String id) {
		 return service.deleteByPrimaryKey(id);
	 } 
	 
//	@UserLoginToken
	@RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
	 public int updateByPrimaryKey(@RequestBody Product product) {
//		Product product = JSON.parseObject(JSON.toJSONString(params), Product.class);
		 return service.updateByPrimaryKey(product);
	 }
	
	
//	@UserLoginToken
	@RequestMapping(value = "/selectByType", method = RequestMethod.GET)
	public List<Product> selectByType(@RequestParam Map<String, Object> params) {
		return service.selectByType((String)params.get("type"));
	}
	
}
