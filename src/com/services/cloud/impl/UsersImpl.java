package com.services.cloud.impl;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.services.cloud.model.Users;

public class UsersImpl {

	private static Logger logger = Logger.getLogger("UsersImpl");

	/**
	 * returns user object for email address
	 * 
	 * @param email address
	 * @return
	 */
	public static Users getUserByEmail(Session session, String email)
	{
		Users result = null;
		result = (Users) session.createCriteria(Users.class).add(Restrictions.eq("email", email)).uniqueResult();
		return result;

	}

	/**
	 * set user
	 * 
	 * @param user
	 * @return
	 */
	public static Users storeUser(Session session, Users user)
	{
		session.saveOrUpdate(user);
		return user;
	}

	public static Users getUserById(Session session, int userAccount_id)
	{
		Users user = (Users) session.createCriteria(Users.class).add(Restrictions.eq("userId", userAccount_id)).uniqueResult();
		return user;
	}

	public static void deleteUser(Session session, Users user)
	{
		session.delete(user);
	}

	public static List<Users> getUserByParentUserId(Session session, Integer userId)
	{
		List<Users> users = (List<Users>) session.createCriteria(Users.class).add(Restrictions.eq("parentUser.userId", userId)).list();
		return users;
	}


}
