package co.segundoPrevio.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.segundoPrevio.model.Country;
import co.segundoPrevio.util.ConexionPostgreSQL;

public class CountryDaoPostgreSQL implements CountryDao{
	
	private ConexionPostgreSQL c;
	private static final String INSERT_COUNTRY_SQL = "INSERT INTO country (id,name) VALUES (?, ?);";
	private static final String DELETE_COUNTRY_SQL = "DELETE FROM country WHERE id = ?;";
	private static final String UPDATE_COUNTRY_SQL = "UPDATE country SET name = ? WHERE id = ?;";
	private static final String SELECT_COUNTRY_BY_SQL = "SELECT * FROM country WHERE id = ?;";
	private static final String SELECT_ALL_COUNTRYS = "SELECT * FROM country;";
	
	public CountryDaoPostgreSQL()
	{
		this.c = ConexionPostgreSQL.getConexion();
	}

	@Override
	public void insert(Country o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Country select(String id) {
		Country country = null;
		try {
			c.setPreparedStatement(SELECT_COUNTRY_BY_SQL);
			PreparedStatement pr = c.getPreparedStatement();
			pr.setString(1, id);
			ResultSet rs = c.query();
			if(rs.next())
			{
				String name = rs.getString("name");
				country = new Country (id,name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return country;
	}

	@Override
	public List<Country> selectAll() {
		List<Country> countrys = new ArrayList<>();
		try {
			c.setPreparedStatement(SELECT_ALL_COUNTRYS);
			PreparedStatement pr = c.getPreparedStatement();
			ResultSet rs = c.query();
			while(rs.next())
			{
				String id = rs.getString("id");
				String name = rs.getString("name");
				countrys.add(new Country (id,name));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countrys;
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Country o) throws SQLException {
		// TODO Auto-generated method stub
		
	}


}
