package be.josimon.BWDAO;

import java.sql.Connection;
import java.util.List;

import be.josimon.BWPOJO.Person;

public class PersonDAO extends DAO<Person> {

	public PersonDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Person obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Person obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Person obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Person find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}