package com.raistudies.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raistudies.domain.Aid;
import com.raistudies.domain.User;
import com.raistudies.domain.UserRoles;
import com.raistudies.persistence.FindApp;
import com.raistudies.persistence.UserMapper;


@Service
public class UserService {
	@Autowired	
	private UserMapper userMapper; //This is to demonstrate injecting SqlSession object

	@Autowired
	private FindApp findApp;
	
	public List<User> getCompleteUser() {
		List<UserRoles> userRoles=userMapper.getUserRole();
		Map<String,List<UserRoles>> newUserRoles=new HashMap<>();
		for (UserRoles userRole : userRoles) {
			List<UserRoles> tempUserRoles=newUserRoles.get(userRole.getId());
			if(tempUserRoles==null){
				tempUserRoles=new ArrayList<>();
			}
			tempUserRoles.add(userRole);
			newUserRoles.put(userRole.getId(), tempUserRoles);
		}
		List<User> users=userMapper.getAllUser();
		for (User user : users) {
			user.setUserRoles(newUserRoles.get(user.getId()));
		}
		return users;
	}
	public List<Aid> getAid() {
		return findApp.getAid();
	}
	
	public List<User> getUser() {
		return userMapper.getAllUser();
	}

	public Map<String, Object> getCombined() {
		Map<String,Object> map=new HashMap<>();
		map.put("user",userMapper.getAllUser());
		map.put("aid", findApp.getAid());
		return map;
	}
}
