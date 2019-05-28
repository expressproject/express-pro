package com.weatherexpress.serviceimpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.weatherexpress.dao.UsersDAO;
import com.weatherexpress.entity.Users;

@Component(value = "userDetailService")
public class UserAuthenticateAndAuthorizationImpl implements UserDetailsService {
	@Autowired
	private UsersDAO usersDAO;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Users user = usersDAO.getUserByUserName(userName);
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
	}

	private List getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

}
