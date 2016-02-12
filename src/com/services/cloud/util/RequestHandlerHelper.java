package com.services.cloud.util;

import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.Response;

import org.hibernate.Session;

import com.services.cloud.impl.UserAccessTokenImpl;
import com.services.cloud.model.GeneralResponse;
import com.services.cloud.model.Status;
import com.services.cloud.model.UserAccesstoken;


public class RequestHandlerHelper
{
	private static Logger logger = Logger.getLogger("AppARequestHandlerHelperccessTokenHome");
	public static Response doHubAccesstokenChecks(Session session, String accesstoken)
	{
		GeneralResponse response = new GeneralResponse();
		//check if accesstoken is valid
		UserAccesstoken accessToken = UserAccessTokenImpl.getAccessTokenBytoken(session, accesstoken);
		if (accessToken == null || accessToken.getValidUntil().before(new Date(System.currentTimeMillis())))
		{
			Status status = new Status(Status.ACCESSTOKEN_INVALID);
			response.setStatusObject(status);
			logger.log(Level.INFO, status.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
		}
		return Response.ok().build();
	}
}
