package com.stronghearttarot.tsutils.utils;

import java.net.UnknownHostException;
import java.util.logging.Logger;

import org.bukkit.Bukkit;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoConnector
{
	private MongoClient mongoClient;
	private DB serverDatabase;
	private Logger log = Bukkit.getLogger();
	
	public MongoConnector()
	{
		try
		{
			mongoClient = new MongoClient("localhost", 27017);
			serverDatabase = mongoClient.getDB("mc_server");
		} catch (UnknownHostException e)
	/	{
			log.info("Error: " + e.getLocalizedMessage());
		}
	}
	
	public void playerHomes(String playerUuid, double loc_x, double loc_y, double loc_z)
	{
		DBCollection playerHomes = serverDatabase.getCollection("player_homes");
		BasicDBObject playerHomeInfo =  
	}
	
}
