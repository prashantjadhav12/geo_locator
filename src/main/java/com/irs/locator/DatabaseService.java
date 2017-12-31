package com.irs.locator;

import java.net.UnknownHostException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class DatabaseService {

	private static DBCollection collection = null;
	private static DB db = null;

	public static DBCollection getDBCollection() {

		if (collection != null)
			return collection;

		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);

			db = mongoClient.getDB("locationdb");
			
			collection = db.getCollection("markers");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return collection;

	}

	public DBCursor executeQuery(BasicDBObject searchQuery) {
		
		DBCollection collection = getDBCollection();
		DBCursor cursor = collection.find(searchQuery);

		return cursor;
	}

	public DBCursor getMarkers(double lat, double lng, double rad) {

		final LinkedList circle = new LinkedList();

		circle.addLast(new double[] { lat, lng });

		// Set the radius
		circle.addLast(rad/111);

		BasicDBObject searchQuery = new BasicDBObject("location",
				new BasicDBObject("$within", new BasicDBObject("$center", circle)));

		return executeQuery(searchQuery);
	}

	public String getMarkersXml(double lat, double lng, double rad) {
		StringBuilder response = new StringBuilder();
		
		

		DBCursor cursor = getMarkers(lat, lng, rad);

		response.append("<markers>");
		while (cursor != null && cursor.hasNext()) {
			
			DBObject obj = cursor.next();

			response.append("<marker ");
			ObjectId id = (ObjectId) obj.get("_id");
			response.append("id=\"" + id.toString() + "\" ");

			String name = (String) obj.get("name");
			response.append("name=\"" + name + "\" ");

			String address = (String) obj.get("address");
			response.append("address=\"" + address + "\" ");

			BasicDBList location = (BasicDBList) obj.get("location");
			
			
			
			Double latitude = (Double) location.get(0);
			response.append("lat=\"" + latitude + "\" ");

			Double longitude = (Double) location.get(1);;
			response.append("lng=\"" + longitude + "\" ");

			String distance = (String) obj.get("distance");
			response.append("distance=\"" + distance + "\"");

			response.append("/>");
			response.append("\n");
		}
		response.append("</markers>");
		return response.toString();
	}

}
