package com.weatherexpress.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weatherexpress.entity.Users;

public interface UserRepositoryDao extends JpaRepository<Users, Integer> {

	Users findByUserName(String userName);
}
