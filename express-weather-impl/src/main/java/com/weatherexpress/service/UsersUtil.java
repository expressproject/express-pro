package com.weatherexpress.service;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.weatherexpress.dto.UserProfileDto;
import com.weatherexpress.dto.UserRegistrationDto;
import com.weatherexpress.entity.Users;

@Component
public interface UsersUtil {

	public Set<UserProfileDto> getUsers();

	public UserRegistrationDto getUsersByUserName(String userName);

	public Users save(Users user);

	public UserRegistrationDto saveUserProfile(UserRegistrationDto userProfile);

	public UserRegistrationDto updateUserProfile(UserRegistrationDto userProfile);
}
