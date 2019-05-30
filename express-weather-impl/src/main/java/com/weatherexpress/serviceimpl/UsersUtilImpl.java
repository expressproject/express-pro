package com.weatherexpress.serviceimpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weatherexpress.dao.UserRepositoryDao;
import com.weatherexpress.dao.UsersDAO;
import com.weatherexpress.entity.Users;
import com.weatherexpress.service.UsersUtil;

@Service
public class UsersUtilImpl implements UsersUtil {

	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private UserRepositoryDao userRepositoryDao;

	@Override
	@Transactional
	public Set<Users> getUsers() {

		Set<Users> users = usersDAO.getUsers();

		// logic : don't display the inactivated users

		return users;
	}

	@Override
	@Transactional
	public Users save(Users user) {

		Users savedUser = usersDAO.saveUser(user);

		return savedUser;
	}

	@Override
	public Users getUsersByUserName(String userName) {
		Users user = userRepositoryDao.findByUserName(userName);
		return user;
	}

}
