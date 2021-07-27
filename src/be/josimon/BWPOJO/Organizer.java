package be.josimon.BWPOJO;

import java.sql.Connection;
import java.util.List;

import be.josimon.BWDAO.OrganizerDAO;

public class Organizer extends Person {
	// Variable
	private String phoneNumber;
	
	private List<Booking> listBooking;

	// Getter & Setter
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Booking> getListBooking() {
		return listBooking;
	}

	public void setListBooking(List<Booking> listBooking) {
		this.listBooking = listBooking;
	}

	// Constructor
	
	public Organizer(int id, String firstname, String lastname, String address, String email, String password,
			String role, String phoneNumber, List<Booking> listBooking) {
		super(id, firstname, lastname, address, email, password, role);
		this.phoneNumber = phoneNumber;
		this.listBooking = listBooking;
	}

	public Organizer(String firstname, String lastname, String address, String email, String password, String role,
			String phoneNumber) {
		super(firstname, lastname, address, email, password, role);
		this.phoneNumber = phoneNumber;
	}
	
	// dao
	public boolean create(Connection conn) {
		OrganizerDAO dao = new OrganizerDAO(conn);
		return dao.create(this);
	}
	
}
