package com.taxiticket.dao;

import java.util.HashMap;
import java.util.Map;

public class TaxiTicketDao {
	
	
	public static Map<String, Integer> cityDistanceMap = new HashMap<String, Integer>();
	
	static {
		cityDistanceMap.put("PUNE-MUMBAI", 120);
		cityDistanceMap.put("PUNE-NASIK", 200);
		cityDistanceMap.put("MUMBAI-GOA", 350);
		cityDistanceMap.put("MUMBAI-NASIK", 180);
	}
	
	public Map<String, Integer> getCityDistanceDetails(){
		return cityDistanceMap;
	}

}
