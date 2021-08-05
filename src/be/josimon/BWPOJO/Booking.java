package be.josimon.BWPOJO;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import be.josimon.BWDAO.BookingDAO;

public class Booking {
	// Variable
	private int id;
	private double deposite;
	private double balance;
	private double price;
	private String status;
	private List<Planning> planning;
	private Organizer orga;
	
	// Getter & Setter
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getDeposite() {
		return deposite;
	}
	public void setDeposite(double deposite) {
		this.deposite = deposite;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<Planning> getPlanning() {
		return planning;
	}
	public void setPlanning(List<Planning> planning) {
		this.planning = planning;
	}
	
	public Organizer getOrga() {
		return orga;
	}
	public void setOrga(Organizer orga) {
		this.orga = orga;
	}
	
	// Constructor
	public Booking(Organizer orga) {
		this.orga = orga;
	}
	
	public Booking(int id, double deposite, double balance, double price, String status, List<Planning> planning) {
		this.id = id;
		this.deposite = deposite;
		this.balance = balance;
		this.price = price;
		this.status = status;
		this.planning = planning;
	}
	public Booking(double deposite, double balance, double price, String status, List<Planning> planning) {
		this.deposite = deposite;
		this.balance = balance;
		this.price = price;
		this.status = status;
		this.planning = planning;
	}
	public Booking(double deposite, double balance, String status, double price, Organizer organizer) {
		this.deposite = deposite;
		this.balance = balance;
		this.price = price;
		this.status = status;
		this.orga = organizer;
	}
	
	public Booking() {}
	
	// dao
	public boolean CreateReservation(Connection conn) {
		BookingDAO dao = new BookingDAO(conn);
		return dao.create(this);
	}
	
	public void findId(Connection conn) {
		try {
			BookingDAO dao = new BookingDAO(conn);
			this.id = dao.find(this).getId();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean createPlanning(Date ddebut, Date dfin,Connection conn) {
		try {
			Planning plan = new Planning(ddebut, dfin,this);
			boolean test = plan.createPlanning(conn);
			return test;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
}
