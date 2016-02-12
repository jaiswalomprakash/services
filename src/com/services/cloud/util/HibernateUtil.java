package com.services.cloud.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.services.cloud.model.MyServcie;
import com.services.cloud.model.ServiceCategory;
import com.services.cloud.model.ServiceCategoryMapping;
import com.services.cloud.model.ServiceCategoryMappingId;
import com.services.cloud.model.ServiceImageMapping;
import com.services.cloud.model.ServiceImageMappingId;
import com.services.cloud.model.Services;
import com.services.cloud.model.UserAccesstoken;
import com.services.cloud.model.UserRoleMapping;
import com.services.cloud.model.UserRoleMappingId;
import com.services.cloud.model.UserRoles;
import com.services.cloud.model.UserServiceMapping;
import com.services.cloud.model.UserServiceMappingId;
import com.services.cloud.model.Users;

public class HibernateUtil
{
	private static SessionFactory sessionFactory;
	private static Logger logger = Logger.getLogger("AppARequestHandlerHelperccessTokenHome");
	static
	{
		try
		{
			Configuration config = new Configuration().addPackage("com.seniorcare.cloud.model").addAnnotatedClass(UserAccesstoken.class)
					.addAnnotatedClass(UserRoles.class).addAnnotatedClass(Users.class).addAnnotatedClass(UserServiceMappingId.class).
					addAnnotatedClass(UserServiceMapping.class).addAnnotatedClass(Services.class).addAnnotatedClass(UserRoleMapping.class)
					.addAnnotatedClass(UserRoleMappingId.class).addAnnotatedClass(MyServcie.class).addAnnotatedClass(ServiceCategory.class)
					.addAnnotatedClass(ServiceImageMapping.class).addAnnotatedClass(ServiceImageMappingId.class)
					.addAnnotatedClass(ServiceCategoryMapping.class).addAnnotatedClass(ServiceCategoryMappingId.class);
			config.configure();
			sessionFactory = config.buildSessionFactory();
		}
		catch (RuntimeException ex)
		{
			System.out.println(ex.getMessage());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public static Session openHibernateSession()
	{
		Session session =null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();		
			session.beginTransaction();			
		} catch (Exception ex) {			
			 logger.log(Level.ALL,ex.getMessage());
			   throw new HibernateException(ex.getMessage());
		}
		return session;
	}

	public static void commitAndCloseHibernateSession(Session session)
	{
		if (session != null)
		{
			if (session.getTransaction() != null)
			{
				try
				{
					session.getTransaction().commit();
				}
				catch (HibernateException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			session.close();
		}
	}

	public static void rollbackAndCloseHibernateSession(Session session)
	{
		if (session != null)
		{
			if (session.getTransaction() != null)
			{
				session.getTransaction().rollback();
			}
			session.close();
		}
	}
	public static void main(String[] args) {
	 System.out.println("HibernateUtil.main()"+getSessionFactory());	
	}
}
