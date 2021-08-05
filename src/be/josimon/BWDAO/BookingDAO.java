package be.josimon.BWDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import be.josimon.BWPOJO.Booking;

public class BookingDAO extends DAO<Booking> {

	public BookingDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Booking obj) {
		try {
			String sql = "INSERT INTO Booking(deposite,balance,statut,price,idpPerson) VALUES(?,?,?,?,?)";
			PreparedStatement ps = this.connect.prepareStatement(sql);
			ps.setDouble(1, obj.getDeposite());
			ps.setDouble(2, obj.getBalance());
			ps.setString(3, obj.getStatus());
			ps.setDouble(4, obj.getPrice());
			ps.setInt(5, obj.getOrga().getId());
			
			int result = ps.executeUpdate();
			if(result == 1) {
				return true;
			} else {
				return false;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Booking obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Booking obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Booking find(Booking obj) {
		Booking book = new Booking();
		try {
			String sql = "SELECT * FROM Booking WHERE idPerson = ? AND statut = ? AND balance = ? AND deposite = ?";
			PreparedStatement ps = this.connect.prepareStatement(sql);
			ps.setInt(1, obj.getOrga().getId());
			ps.setString(2, obj.getStatus());
			ps.setDouble(3, obj.getBalance());
			ps.setDouble(4, obj.getDeposite());
			
			ResultSet result = ps.executeQuery();
			
			if(result.next()) {
				book.setId(result.getInt("idBooking"));
				book.setDeposite(result.getDouble("deposite"));
				book.setBalance(result.getDouble("balance"));
				book.setStatus(result.getString("statut"));
				book.setPrice(result.getDouble("price"));
			}
			return book;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Booking> getAll(Booking obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
