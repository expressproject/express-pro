package com.exp.service.expressWeatherService;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.exp.entity.expressWeatherEntity.Users;



@Component
public interface UsersUtil {

	public Set<Users> getUsers();
	public Users save(Users user);
}
