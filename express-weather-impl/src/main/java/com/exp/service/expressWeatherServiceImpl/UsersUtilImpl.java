package com.exp.service.expressWeatherServiceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exp.dao.expressWeatherDao.UsersDAO;
import com.exp.entity.expressWeatherEntity.Users;
import com.exp.service.expressWeatherService.UsersUtil;





@Service
public class UsersUtilImpl implements UsersUtil{

	@Autowired
	private UsersDAO usersDAO; 
	
	@Override
	@Transactional
	public Set<Users> getUsers() {
		
		Set<Users> users =  usersDAO.getUsers();
		
		//logic : don't display the inactivated users
		
		return users;
	}

	@Override
	@Transactional
	public Users save(Users user) {
		
		Users savedUser = usersDAO.saveUser(user);
		
		return savedUser;
	}

}
