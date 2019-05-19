package com.exp.dao.expressWeatherDao;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.exp.entity.expressWeatherEntity.Users;



/**
 * @author abhilashpanigrahi
 *
 */

@Component
public interface UsersDAO {
	
	public Set<Users> getUsers();
	public Users saveUser(Users user);

}
