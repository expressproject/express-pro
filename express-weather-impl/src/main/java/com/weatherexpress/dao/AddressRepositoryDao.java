package com.weatherexpress.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weatherexpress.entity.Address;

public interface AddressRepositoryDao extends JpaRepository<Address, Integer> {
	public Address findAddressByAdd_id(String userId);
}
