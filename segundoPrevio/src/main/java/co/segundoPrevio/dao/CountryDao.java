package co.segundoPrevio.dao;

import java.sql.SQLException;
import java.util.List;

import co.segundoPrevio.model.Country;

public interface CountryDao {

	public void insert(Country o) throws SQLException;

	public Country select(String id);

	public List<Country> selectAll();

	public void delete(int id) throws SQLException;

	public void update(Country o) throws SQLException;
}
