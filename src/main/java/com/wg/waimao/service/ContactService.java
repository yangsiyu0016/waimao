package com.wg.waimao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wg.waimao.dao.ContactMapper;
import com.wg.waimao.entity.Contact;

@Service("contactService")
public class ContactService {
	
	@Autowired
	private ContactMapper dao;

	public List<Contact> selectAll(){
		
		return dao.selectAll();
	}
	
	public Contact selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}
   
	public int insert(Contact record) {
		return dao.insert(record);
	}
	
	 public int deleteByPrimaryKey(String id) {
		 return dao.deleteByPrimaryKey(id);
	 } 
	 
	 public int updateByPrimaryKey(Contact record) {
		 return dao.updateByPrimaryKey(record);
	 }
	 public Contact selectByTitle(String title) {
			return dao.selectByTitle(title);
		}
}