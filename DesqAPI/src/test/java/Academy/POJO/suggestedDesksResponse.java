package Academy.POJO;

import java.util.List;

public class suggestedDesksResponse {
 
	
	private Users user;
	private List<ReservationDatesByDeskList> reservationDatesByDeskList;
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public List<ReservationDatesByDeskList> getReservationDatesByDeskList() {
		return reservationDatesByDeskList;
	}
	public void setReservationDatesByDeskList(List<ReservationDatesByDeskList> reservationDatesByDeskList) {
		this.reservationDatesByDeskList = reservationDatesByDeskList;
	}
	
	
	
	
	
}
