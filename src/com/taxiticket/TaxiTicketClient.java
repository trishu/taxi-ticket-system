package com.taxiticket;

import com.taxiticket.dao.TaxiTicketDao;
import com.taxiticket.handler.TaxiTicketHandler;
import com.taxiticket.service.TaxiTicketService;
import com.taxiticket.service.TaxiTicketServiceImpl;
import com.taxiticket.vo.TaxiTicketRequestVo;
import com.taxiticket.vo.TaxiTicketResponseVo;

public class TaxiTicketClient {
	
	static TaxiTicketHandler handler;
	
	//Manual Dependency Injection
	static {
		TaxiTicketDao taxiTicketDao = new TaxiTicketDao();
		TaxiTicketService taxiTicketService = new TaxiTicketServiceImpl(taxiTicketDao);
		handler = new TaxiTicketHandler(taxiTicketService);
	}
	
	public static void main(String[] args) throws Exception {
		
		TaxiTicketRequestVo request = new TaxiTicketRequestVo("PUNE", "NASIK", 2);
		TaxiTicketResponseVo response = handler.generateTicket(request);
		
		System.out.println(response);
	}

}
