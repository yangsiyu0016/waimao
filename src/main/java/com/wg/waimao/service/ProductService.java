package com.wg.waimao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wg.waimao.dao.ProductMapper;
import com.wg.waimao.entity.Product;

@Service("productService")
public class ProductService {
	
	@Autowired
	private ProductMapper dao;

	public List<Product> selectAll(){
		
		return dao.selectAll();
	}
	
	public Product selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}
   
	public int insert(Product record) {
		return dao.insert(record);
	}
	
	 public int deleteByPrimaryKey(String id) {
		 return dao.deleteByPrimaryKey(id);
	 } 
	 
	 public int updateByPrimaryKey(Product record) {
		 return dao.updateByPrimaryKey(record);
	 }
	 
	 public List<Product> selectByType(String type) {
			return dao.selectByType(type);
		}

}