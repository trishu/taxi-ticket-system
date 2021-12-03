package com.taxiticket.service;

import java.util.Map;

import com.taxiticket.dao.TaxiTicketDao;

public class TaxiTicketServiceImpl implements TaxiTicketService{

	private TaxiTicketDao taxiTicketDao;
	
	public TaxiTicketServiceImpl(TaxiTicketDao taxiTicketDao) {
		super();
		this.taxiTicketDao = taxiTicketDao;
	}

	@Override
	public Map<String, Integer> getCityDistanceDetails() {
		return taxiTicketDao.getCityDistanceDetails();
	}
	
	

}
