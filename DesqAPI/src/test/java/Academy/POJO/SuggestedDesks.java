package Academy.POJO;

import java.util.List;

public class SuggestedDesks {
	
	private int locationId;
	private String arrivalTime;
	private int teamId;
	private List<String> reservationDates;
	
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public List<String> getReservationDates() {
		return reservationDates;
	}
	public void setReservationDates(List<String> reservationDates) {
		this.reservationDates = reservationDates;
	}
	
	

}
