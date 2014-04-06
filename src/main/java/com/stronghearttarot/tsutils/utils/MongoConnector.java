package com.stronghearttarot.tsutils.utils;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.bukkit.Bukkit;

import java.net.UnknownHostException;
import java.util.logging.Logger;

public class MongoConnector {
    double loc_x;
    double loc_y;
    double loc_z;
    private MongoClient mongoClient;
    private DB serverDatabase;
    private Logger log = Bukkit.getLogger();

    public MongoConnector() {
        try {
            mongoClient = new MongoClient("localhost", 27017);
            serverDatabase = mongoClient.getDB("mc_server");
        } catch (UnknownHostException e) {
            log.info("Error: " + e.getLocalizedMessage());
        }
    }

    public String madMethod(String joke) {
        String question = "Why did the chicken cross the road?";
        return joke;
    }

    public void setPlayerHomes(String playerName, double loc_x, double loc_y, double loc_z) {
        DBCollection playerHomes = serverDatabase.getCollection("player_homes");
        BasicDBObject playerHomeInfo = new BasicDBObject("player_name", playerName).append("location", new BasicDBObject("x", loc_x).append("y", loc_y).append("z", loc_z));
        playerHomes.insert(playerHomeInfo);
    }

    public void getPlayerHomes(String playerName) {
        DBCollection playerHomes = serverDatabase.getCollection("player_homes");
    }

}
