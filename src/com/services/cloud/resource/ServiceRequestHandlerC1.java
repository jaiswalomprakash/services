package com.services.cloud.resource;

import java.util.Date;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jasypt.util.password.StrongPasswordEncryptor;

import com.services.cloud.impl.UserAccessTokenImpl;
import com.services.cloud.impl.UsersImpl;
import com.services.cloud.model.GeneralResponse;
import com.services.cloud.model.Status;
import com.services.cloud.model.UserAccesstoken;
import com.services.cloud.model.Users;
import com.services.cloud.util.HibernateUtil;

public class ServiceRequestHandlerC1 {
	
	private static final Logger logger = Logger.getLogger("ServiceRequestHandlerC1");
	public static GeneralResponse login(String email, String password)
	{
		GeneralResponse response = new GeneralResponse();
		Session session = null;
		try
		{
			session = HibernateUtil.openHibernateSession();
			//check if user account exists
			Users user = UsersImpl.getUserByEmail(session, email);
			
			if (user == null)
			{
				HibernateUtil.rollbackAndCloseHibernateSession(session);
				Status status = new Status(Status.NO_USER);
				response.setStatusObject(status);
				logger.log(Level.INFO, status.toString());
				return response;
			}
			//check if user account is activated
			if (!user.getActive().equals("Y"))
			{
				HibernateUtil.rollbackAndCloseHibernateSession(session);
				Status status = new Status(Status.ACCOUNT_NOT_ACTIVATED);
				response.setStatusObject(status);
				logger.log(Level.INFO, status.toString());
				return response;
			}
			//check if passwords match
			StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			if (!passwordEncryptor.checkPassword(password, user.getPassword()))
			{
				HibernateUtil.rollbackAndCloseHibernateSession(session);
				Status status = new Status(Status.NO_PASSWORD_MATCH);
				response.setStatusObject(status);
				logger.log(Level.INFO, status.toString());
				return response;
			}
			//generate accesstoken
			UUID accessToken = UUID.randomUUID();
			//store accesstoken
			UserAccesstoken userAccessToken = new UserAccesstoken();
			userAccessToken.setToken(accessToken.toString());
			userAccessToken.setUsers(user);
			int ttl = 24 * 60 * 60 * 1000;
			try
			{
				Integer ttlInteger = new Integer(String.valueOf(ttl));
				ttl = ttlInteger.intValue();
			}
			catch (NumberFormatException e)
			{
				logger.log(Level.SEVERE, e.getLocalizedMessage());
			}
			Date validUntil = new Date(System.currentTimeMillis() + ttl);
			userAccessToken.setValidUntil(validUntil);
			userAccessToken = UserAccessTokenImpl.storeToken(session, userAccessToken);
			if (userAccessToken != null)
			{
				/*LoginResponse loginResponse = new LoginResponse();
				loginResponse.setAccessToken(accessToken.toString());
				loginResponse.setAccessTokenttl(ttl);*/
				response.setData(user);
				HibernateUtil.commitAndCloseHibernateSession(session);
				logger.log(Level.INFO, response.toString());
				return response;
			}
			else
			{
				HibernateUtil.rollbackAndCloseHibernateSession(session);
			//logger.log(Level.INFO, Response.Status.INTERNAL_SERVER_ERROR.toString());
				return response;
			}
		}
		catch (HibernateException e)
		{
			logger.severe(e.getLocalizedMessage());
			if (session != null)
			{
				HibernateUtil.rollbackAndCloseHibernateSession(session);
			}
			Status status = new Status(Status.DATABASE_ERROR);
			response.setStatusObject(status);
			logger.log(Level.INFO, status.toString());
			return response;
		}
	}

}
