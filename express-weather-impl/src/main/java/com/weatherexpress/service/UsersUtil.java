package com.weatherexpress.service;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.weatherexpress.entity.Users;



@Component
public interface UsersUtil {

	public Set<Users> getUsers();
	public Users save(Users user);
}