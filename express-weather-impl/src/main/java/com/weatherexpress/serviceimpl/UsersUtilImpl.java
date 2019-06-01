package com.weatherexpress.serviceimpl;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weatherexpress.dao.UserRepositoryDao;
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

	@Override
	public UserRegistrationDto saveUserProfile(UserRegistrationDto userProfile) {
		List<Address> addressList = new ArrayList<>();
		Address address = new Address();
		address.setAddressLine1(userProfile.getAddressLine1());
		address.setAddressLine2(userProfile.getAddressLine2());
		address.setCity(userProfile.getCity());
		address.setCountry(userProfile.getCountry());
		address.setState(userProfile.getState());
		addressList.add(address);

		List<InteractionChannel> interachList = new ArrayList<>();
		InteractionChannel intrach = new InteractionChannel();
		intrach.setEmail(userProfile.getEmail());
		intrach.setPhoneNumber(Long.parseLong(userProfile.getPhoneNumber()));
		intrach.setWebsite(userProfile.getWebsite());
		interachList.add(intrach);

		Users user = new Users();
		user.setFirstName(userProfile.getFirstName());
		user.setLastName(userProfile.getLastName());
		Calendar cd = Calendar.getInstance();
		System.out.println(cd.getTimeInMillis());
		Timestamp timestamp = new Timestamp(cd.getTimeInMillis());
		user.setEffectiveDate(timestamp);
		user.setUserName(userProfile.getUserName());
		user.setPassword(userProfile.getPassword());
		user.setAddress(addressList);
		user.setInteractionChannels(interachList);
		user.setExpiryDate(timestamp);
		user.setIsDeleted("Y");
		usersDAO.saveUser(user);
		return null;
	}

}
