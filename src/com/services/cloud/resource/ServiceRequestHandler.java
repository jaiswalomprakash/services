/*
*
* Copyright (c) 2015-2016 Tangerine. All Rights Reserved.
* This software is the confidential and proprietary information of Tangerine.
* ("Confidential Information"). 
* You shall not disclose such Confidential Information and shall use it only in
* accordance with the terms of the license agreement you entered into
* with Tangerine.
 */
package com.services.cloud.resource;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.services.cloud.model.GeneralResponse;
@Singleton
@Path("/Console")
public class ServiceRequestHandler {
	 
	//@Context ServletContext context;
	
	



	@GET
	@Path("AuthHub/")
	@Produces(MediaType.APPLICATION_JSON)		
	public GeneralResponse authHub( @QueryParam("email") String email,@QueryParam("password") String password)
	{
		System.out.println("IoTDeviceRequestHandler.authHub()---");		
			return ServiceRequestHandlerC1.login(email, password);
		
	}
	

	
}
