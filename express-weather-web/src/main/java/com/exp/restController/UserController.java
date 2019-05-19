package com.exp.restController;

import java.util.Calendar;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exp.entity.expressWeatherEntity.Address;
import com.exp.entity.expressWeatherEntity.InteractionChannel;
import com.exp.entity.expressWeatherEntity.Users;
import com.exp.service.expressWeatherService.UsersUtil;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UsersUtil usersUtil;
	
	@GetMapping("/getUsers")
	public Set<Users> getAllUsers()
	{
		//calling service method
		
		Set<Users> users = usersUtil.getUsers();
		
		return users;
	}
	@GetMapping("/saveUsers")
	public Users saveUsersInfo()
	{
		InteractionChannel interactionChannel = new InteractionChannel();
		interactionChannel.setEmail("archi@archi.com");
		interactionChannel.setPhoneNumber(123456);
		//interactionChannel.setUserInteractionChannelId(2005);
		interactionChannel.setWebsite("www.maggi.com");
		
		//ArrayList<InteractionChannel> iclist = new ArrayList<InteractionChannel>();
		//iclist.add(interactionChannel);
		
		
		Address address = new Address();
		//address.setAddressId(105);
		address.setAddressLine1("8th block,Nayapalli");
		address.setAddressLine2("Jaydev Vihar");
		address.setCity("B");
		address.setState("Odisha");
		address.setCountry("India");
		//ArrayList<Address> add_list = new ArrayList<Address>();
		//add_list.add(address);
		
		
		
		Users user = new Users();
		//user.setId(127);
		user.setFirstName("Maggi");
		user.setLastName("Sahoo");
		user.setUserName("archi");
		user.setPassword("maggi123");
		user.setIsDeleted("n");
		user.setEffectiveDate(Calendar.getInstance().getTime());
		user.setExpiryDate(null);
		//user.setInteractionChannels(iclist);
		//user.setAddress(add_list);
		user.getInteractionChannels().add(interactionChannel);
		user.getAddress().add(address);
		
		
		address.setUsers(user);
		interactionChannel.setUsers(user);
		
		Users savedUser = usersUtil.save(user);
		
		
		return savedUser;
	}

}
