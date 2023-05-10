package Academy.POJO;

import java.util.List;

public class ReservationDatesByDeskList {

	
	private int locationId;
	private String locationName;
	private int officeId;
	private String officeName;
	private int officeFloor;
	private int deskId;
	private String deskNo;
	private List<String> teamMembers;
	private List<String> reservationDates;
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public int getOfficeId() {
		return officeId;
	}
	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public int getOfficeFloor() {
		return officeFloor;
	}
	public void setOfficeFloor(int officeFloor) {
		this.officeFloor = officeFloor;
	}
	public int getDeskId() {
		return deskId;
	}
	public void setDeskId(int deskId) {
		this.deskId = deskId;
	}
	public String getDeskNo() {
		return deskNo;
	}
	public void setDeskNo(String deskNo) {
		this.deskNo = deskNo;
	}
	public List<String> getTeamMembers() {
		return teamMembers;
	}
	public void setTeamMembers(List<String> teamMembers) {
		this.teamMembers = teamMembers;
	}
	public List<String> getReservationDates() {
		return reservationDates;
	}
	public void setReservationDates(List<String> reservationDates) {
		this.reservationDates = reservationDates;
	}
	
	
}
