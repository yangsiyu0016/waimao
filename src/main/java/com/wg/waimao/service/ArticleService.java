package com.wg.waimao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wg.waimao.dao.ArticleMapper;
import com.wg.waimao.entity.Article;

@Service("articleService")
public class ArticleService {
	
	@Autowired
	private ArticleMapper dao;

	public List<Article> selectAll(){
		
		return dao.selectAll();
	}
	
	public Article selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}
   
	public int insert(Article record) {
		return dao.insert(record);
	}
	
	 public int deleteByPrimaryKey(String id) {
		 return dao.deleteByPrimaryKey(id);
	 } 
	 
	 public int updateByPrimaryKey(Article record) {
		 return dao.updateByPrimaryKey(record);
	 }

}