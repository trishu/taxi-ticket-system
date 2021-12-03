package com.taxiticket.handler;

import java.util.Map;
import java.util.Optional;

import com.taxiticket.service.TaxiTicketService;
import com.taxiticket.util.TaxiTicketUtil;
import com.taxiticket.vo.TaxiTicketRequestVo;
import com.taxiticket.vo.TaxiTicketResponseVo;

public class TaxiTicketHandler {
	
	private TaxiTicketService taxiTicketService;

	public TaxiTicketHandler(TaxiTicketService taxiTicketService) {
		super();
		this.taxiTicketService = taxiTicketService;
	}
	
	public TaxiTicketResponseVo generateTicket(TaxiTicketRequestVo request) throws Exception {
		
		String sourceDestinationKey = createSourceDestinationKey(request);
		
		Map<String, Integer> cityDistanceMap = taxiTicketService.getCityDistanceDetails();
		
		Integer distance = retrieveDistanceFromCities(cityDistanceMap, sourceDestinationKey);
		
		Integer totalFare = calculateTotalFare(distance, request.getNoOfTravellers());
		
		return buildTaxiTicketResponse(request, distance, totalFare);
	}
	
	private String createSourceDestinationKey(TaxiTicketRequestVo request) {
		return new StringBuilder().append(request.getSource()).append("-").append(request.getDestination()).toString();
	}
	

	private Integer retrieveDistanceFromCities(Map<String, Integer> cityDistanceMap, String fromToKey) throws Exception{
		return Optional.ofNullable(cityDistanceMap.get(fromToKey)).
				orElseThrow(() -> new Exception("Sorry!! We are not operating for the given routes"));
	}
	
	private Integer calculateTotalFare(Integer distance, Integer noOfTravellers) {
		Integer fare = TaxiTicketUtil.fareRule(distance);
		
		return fare * noOfTravellers;
		
	}
	
	private TaxiTicketResponseVo buildTaxiTicketResponse(TaxiTicketRequestVo request, Integer distance, Integer totalFare) {
		return new TaxiTicketResponseVo.TaxiTicketBuilder(
				request.getSource(), request.getDestination(), distance).setNoOfTravellers(request.getNoOfTravellers())
				.setTotalAmount(totalFare).build();
	}
	
}
