package com.wg.waimao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wg.waimao.dao.AdminMapper;
import com.wg.waimao.entity.Admin;

@Service("adminService")
public class AdminService {
	
	@Autowired
	private AdminMapper dao;

	public List<Admin> selectAll(){
		
		return dao.selectAll();
	}
	
	public Admin selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}
   
	public int insert(Admin record) {
		return dao.insert(record);
	}
	
	 public int deleteByPrimaryKey(String id) {
		 return dao.deleteByPrimaryKey(id);
	 } 
	 
	 public int updateByPrimaryKey(Admin record) {
		 return dao.updateByPrimaryKey(record);
	 }
	 
	 public Admin selectByUserName(String userName) {
		 return dao.selectByUserName(userName);
	 }

}