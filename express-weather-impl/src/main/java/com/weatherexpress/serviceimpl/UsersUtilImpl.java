package com.weatherexpress.serviceimpl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weatherexpress.dao.UsersDAO;
import com.weatherexpress.dto.UserRegistrationDto;
import com.weatherexpress.entity.Address;
import com.weatherexpress.entity.InteractionChannel;
import com.weatherexpress.entity.Users;
import com.weatherexpress.service.UsersUtil;

@Service
public class UsersUtilImpl implements UsersUtil {

	@Autowired
	private UsersDAO usersDAO;

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
	public UserRegistrationDto getUsersByUserName(String userName) {
		Users user = usersDAO.getUserByUserName(userName);
		UserRegistrationDto userdto = new UserRegistrationDto();
		userdto.setFirstName(user.getFirstName());
		userdto.setLastName(user.getLastName());
		userdto.setUserName(user.getUserName());
		userdto.setAddressLine1(user.getAddress().get(0).getAddressLine1());
		userdto.setAddressLine2(user.getAddress().get(0).getAddressLine2());
		userdto.setPassword(user.getPassword());
		userdto.setCity(user.getAddress().get(0).getCity());
		userdto.setCountry(user.getAddress().get(0).getCountry());
		userdto.setEmail(user.getInteractionChannels().get(0).getEmail());
		userdto.setState(user.getAddress().get(0).getState());
		userdto.setWebsite(user.getInteractionChannels().get(0).getWebsite());
		userdto.setPhoneNumber(String.valueOf(user.getInteractionChannels().get(0).getPhoneNumber()));
		return userdto;
	}

	@Transactional
	@Override
	public UserRegistrationDto saveUserProfile(UserRegistrationDto userProfile) {

		Users user = new Users();
		user.setFirstName(userProfile.getFirstName());
		user.setLastName(userProfile.getLastName());
		Calendar cd = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(cd.getTimeInMillis());
		user.setEffectiveDate(timestamp);
		user.setUserName(userProfile.getUserName());
		user.setPassword(userProfile.getPassword());
		user.setExpiryDate(timestamp);
		user.setIsDeleted("Y");
		usersDAO.saveUser(user);

		Address address = new Address();
		address.setAddressLine1(userProfile.getAddressLine1());
		address.setAddressLine2(userProfile.getAddressLine2());
		address.setCity(userProfile.getCity());
		address.setCountry(userProfile.getCountry());
		address.setState(userProfile.getState());
		usersDAO.saveAddress(address);

		InteractionChannel intrach = new InteractionChannel();
		intrach.setEmail(userProfile.getEmail());
		intrach.setPhoneNumber(Long.parseLong(userProfile.getPhoneNumber()));
		intrach.setWebsite(userProfile.getWebsite());
		usersDAO.saveInteractionChannel(intrach);

		intrach.setUsers(user);
		address.setUsers(user);
		return null;
	}

	@Transactional
	@Override
	public UserRegistrationDto updateUserProfile(UserRegistrationDto userProfile) {

		Users user = usersDAO.getUserByUserName(userProfile.getUserName());
		user.setFirstName(userProfile.getFirstName());
		user.setLastName(userProfile.getLastName());
		Calendar cd = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(cd.getTimeInMillis());
		user.setEffectiveDate(timestamp);
		user.setUserName(userProfile.getUserName());
		user.setPassword(userProfile.getPassword());
		user.setExpiryDate(timestamp);
		user.setIsDeleted("Y");
		usersDAO.saveUser(user);

		Address address = usersDAO.getAddressByUserId(String.valueOf(user.getId()));
		address.setAddressId(user.getAddress().get(0).getAddressId());
		address.setAddressLine1(userProfile.getAddressLine1());
		address.setAddressLine2(userProfile.getAddressLine2());
		address.setCity(userProfile.getCity());
		address.setCountry(userProfile.getCountry());
		address.setState(userProfile.getState());
		usersDAO.saveAddress(address);

		InteractionChannel intrach = usersDAO.getInteractionChannelByUserId(String.valueOf(user.getId()));
		intrach.setUserInteractionChannelId(user.getInteractionChannels().get(0).getUserInteractionChannelId());
		intrach.setEmail(userProfile.getEmail());
		intrach.setPhoneNumber(Long.parseLong(userProfile.getPhoneNumber()));
		intrach.setWebsite(userProfile.getWebsite());
		usersDAO.saveInteractionChannel(intrach);

		return null;
	}

}
