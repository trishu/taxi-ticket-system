package com.taxiticket.vo;

public class TaxiTicketResponseVo {
	
	private String source;
	private String destination;
	private Integer distance;
	private Integer noOfTravellers;
	private Integer totalAmount;
	
	public TaxiTicketResponseVo(TaxiTicketBuilder taxiTicketBuilder) {
		this.source = taxiTicketBuilder.source;
		this.destination = taxiTicketBuilder.destination;
		this.distance = taxiTicketBuilder.distance;
		this.noOfTravellers = taxiTicketBuilder.noOfTravellers;
		this.totalAmount = taxiTicketBuilder.totalAmount;
	}
	
	public String getSource() {
		return source;
	}
	public String getDestination() {
		return destination;
	}
	public Integer getDistance() {
		return distance;
	}
	public Integer getNoOfTravellers() {
		return noOfTravellers;
	}
	public Integer getTotalAmount() {
		return totalAmount;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("Taxi Ticket").append("\n").append("-----------"+"\n")
		.append("Source: ").append(source).append("\n").append("Destination: ").append(destination).append("\n")
		.append("Kms: ").append(distance).append("\n").append("No. of travellers = ").append(noOfTravellers).append("\n")
		.append("Total = ").append(totalAmount).append(" INR").toString();
	}
	
	public static class TaxiTicketBuilder{
		private String source;
		private String destination;
		private Integer distance;
		
		private Integer noOfTravellers;
		private Integer totalAmount;
		
		public TaxiTicketBuilder(String source, String destination, Integer distance){
			this.source = source;
			this.destination = destination;
			this.distance = distance;
		}
		
		public TaxiTicketBuilder setNoOfTravellers(Integer noOfTravellers) {
			this.noOfTravellers = noOfTravellers;
			return this;
		}
		
		public TaxiTicketBuilder setTotalAmount(Integer totalAmount) {
			this.totalAmount = totalAmount;
			return this;
		}
		
		public TaxiTicketResponseVo build(){
			return new TaxiTicketResponseVo(this);
		}
	}

}
