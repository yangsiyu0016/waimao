package com.wg.waimao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wg.waimao.dao.TeamMapper;
import com.wg.waimao.entity.Team;

@Service("teamService")
public class TeamService {
	
	@Autowired
	private TeamMapper dao;

	public List<Team> selectAll(){
		
		return dao.selectAll();
	}
	
	public Team selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}
   
	public int insert(Team record) {
		return dao.insert(record);
	}
	
	 public int deleteByPrimaryKey(String id) {
		 return dao.deleteByPrimaryKey(id);
	 } 
	 
	 public int updateByPrimaryKey(Team record) {
		 return dao.updateByPrimaryKey(record);
	 }

}