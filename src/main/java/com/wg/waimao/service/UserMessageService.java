package com.wg.waimao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wg.waimao.dao.UserMessageMapper;
import com.wg.waimao.entity.UserMessage;

@Service("userMessageService")
public class UserMessageService {
	
	@Autowired
	private UserMessageMapper dao;

	public List<UserMessage> selectAll(){
		
		return dao.selectAll();
	}
	
	public UserMessage selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}
   
	public int insert(UserMessage record) {
		return dao.insert(record);
	}
	
	 public int deleteByPrimaryKey(String id) {
		 return dao.deleteByPrimaryKey(id);
	 } 
	 
	 public int updateByPrimaryKey(UserMessage record) {
		 return dao.updateByPrimaryKey(record);
	 }

}