package com.services.cloud.impl;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.services.cloud.model.UserAccesstoken;



public class UserAccessTokenImpl {
	private static Logger logger = Logger.getLogger("UserAccessTokenImpl");

	/**
	 * returns accesstoken for token
	 * 
	 * @param token 
	 * @return
	 */
	public static UserAccesstoken getAccessTokenBytoken(Session session, String token)
	{
		UserAccesstoken result = null;
		result = (UserAccesstoken) session.createCriteria(UserAccesstoken.class).add(Restrictions.eq("token", token)).uniqueResult();
		return result;

	}

	/**
	 * set token
	 * 
	 * @param token
	 * @return
	 */
	public static UserAccesstoken storeToken(Session session, UserAccesstoken token)
	{
		session.saveOrUpdate(token);
		return token;
	}

}
