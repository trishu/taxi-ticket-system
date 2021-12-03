package com.taxiticket.util;

public class TaxiTicketUtil {
	
	private static final Integer BASE_FARE = 750;
	
	private static final Integer EXTRA_FARE_PER_KM = 5;
	
	public static Integer fareRule(Integer distance) {
		if(distance <= 100)
			return BASE_FARE;
		else{
			//int extraKm = distance - 100;
			int extraFare = EXTRA_FARE_PER_KM * (distance - 100);
			return BASE_FARE + extraFare;
		}
	}

}
