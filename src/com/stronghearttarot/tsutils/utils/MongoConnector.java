package com.stronghearttarot.tsutils.utils;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;

public class MongoConnector
{
	private MongoClient mongoClient;
	
	public MongoConnector()
	{
		try
		{
			mongoClient = new MongoClient();
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
