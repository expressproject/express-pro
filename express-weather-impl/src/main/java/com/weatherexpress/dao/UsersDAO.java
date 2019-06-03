package com.weatherexpress.dao;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.weatherexpress.entity.Address;
import com.weatherexpress.entity.InteractionChannel;
import com.weatherexpress.entity.Users;

/**
 * @author abhilashpanigrahi
 *
 */

@Component
public interface UsersDAO {
	public Users getUserByUserName(String userName);

	public Set<Users> getUsers();

	public Users saveUser(Users user);

	public Address saveAddress(Address address);

	public Address getAddressByUserId(String userId);

	public InteractionChannel saveInteractionChannel(InteractionChannel interactionChannel);

	public InteractionChannel getInteractionChannelByUserId(String userId);

	public Users deleteUser(Users user);

	public Users updateUser(Users user);

}
