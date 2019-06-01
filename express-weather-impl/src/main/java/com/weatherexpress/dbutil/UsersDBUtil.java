package com.weatherexpress.dbutil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.weatherexpress.dao.UserRepositoryDao;
import com.weatherexpress.dao.UsersDAO;
import com.weatherexpress.entity.Users;

@Repository
public class UsersDBUtil implements UsersDAO {
	@Autowired
	private UserRepositoryDao userRepositoryDao;
	private EntityManager entityManager;

	@Autowired
	public UsersDBUtil(EntityManager entityManager) {

		this.entityManager = entityManager;
	}

	@Override
	public Set<Users> getUsers() {

		// write db logic
		/*
		 * Session session = entityManager.unwrap(Session.class);
		 * System.out.println(session.isConnected()); Query<Users> resultSet =
		 * session.createQuery("from Users",Users.class); List<Users> users =
		 * resultSet.getResultList(); HashSet<Users> allUsers = new
		 * HashSet<Users>(users);
		 */

		// entityManager.createquery
		// using JPQL
		TypedQuery<Users> queryResult = entityManager.createQuery("from Users", Users.class);
		List<Users> allUsers = queryResult.getResultList();
		HashSet<Users> allUserCollection = new HashSet<Users>(allUsers);
		return allUserCollection;
	}

	@Override
	public Users saveUser(Users user) {
		userRepositoryDao.save(user);
		
		/*  Session session = entityManager.unwrap(Session.class);
		  session.saveOrUpdate(user);*/
		 
		return user;
	}

	@Override
	public Users deleteUser(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users updateUser(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getUserByUserName(String userName) {
		Users singleUser = userRepositoryDao.findByUserName(userName);
		return singleUser;
	}

}
