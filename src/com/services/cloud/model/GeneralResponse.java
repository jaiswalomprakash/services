package com.services.cloud.model;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class GeneralResponse
{
	int status = Status.OK;
	String statusMessage = Status.getMessage(Status.OK);
	Object data =null;

	public GeneralResponse()
	{
		super();
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public String getStatusMessage()
	{
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage)
	{
		this.statusMessage = statusMessage;
	}

	public void setStatusObject(Status status)
	{
		this.setStatus(status.getCode());
		this.setStatusMessage(status.getMessage());
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	
	


	/*@Override
	public String toString()
	{
		//		Gson gson = new Gson();
		//		return gson.toJson(this);
		Genson genson = new Genson();
		try
		{
			return genson.serialize(this);
		}
		catch (TransformationException e)
		{
			return null;
		}
		catch (IOException e)
		{
			return null;
		}
	}*/

}
