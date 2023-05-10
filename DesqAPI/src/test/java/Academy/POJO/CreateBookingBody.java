package Academy.POJO;

import java.util.List;

public class CreateBookingBody {

	
	private String arrivalTime;
	private String teamId;
	private String userCreatedId;
	private List<DatesByDesk> datesByDesk;
	
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getUserCreatedId() {
		return userCreatedId;
	}
	public void setUserCreatedId(String userCreatedId) {
		this.userCreatedId = userCreatedId;
	}
	public List<DatesByDesk> getDatesByDesk() {
		return datesByDesk;
	}
	public void setDatesByDesk(List<DatesByDesk> datesByDesk) {
		this.datesByDesk = datesByDesk;
	}
	
	
	
}
