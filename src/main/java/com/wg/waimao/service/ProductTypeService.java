package com.wg.waimao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wg.waimao.dao.ProductTypeMapper;
import com.wg.waimao.entity.ProductType;

@Service("productTypeService")
public class ProductTypeService {
	
	@Autowired
	private ProductTypeMapper dao;

	public List<ProductType> selectAll(){
		
		return dao.selectAll();
	}
	
}