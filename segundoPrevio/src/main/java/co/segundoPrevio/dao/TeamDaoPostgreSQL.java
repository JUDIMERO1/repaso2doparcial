package co.segundoPrevio.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.segundoPrevio.model.Country;
import co.segundoPrevio.model.Team;
import co.segundoPrevio.util.ConexionPostgreSQL;

public class TeamDaoPostgreSQL implements TeamDao {

	private ConexionPostgreSQL c;
	private static final String INSERT_TEAM_SQL = "INSERT INTO team (id,name,country) VALUES (?,?,?);";
	private static final String DELETE_TEAM_SQL = "DELETE FROM team WHERE id = ?;";
	private static final String UPDATE_TEAM_SQL = "UPDATE team SET name = ?, country = ? WHERE id = ?;";
	private static final String SELECT_TEAM_BY_SQL = "SELECT * FROM team WHERE id = ?;";
	private static final String SELECT_ALL_TEAMS = "SELECT * FROM team;";

	public TeamDaoPostgreSQL() {
		this.c = ConexionPostgreSQL.getConexion();
	}

	@Override
	public void insert(Team o) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Team select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> selectAll() {
		List<Team> teams = new ArrayList<>();
		try {
			c.setPreparedStatement(SELECT_ALL_TEAMS);
			PreparedStatement pr = c.getPreparedStatement();
			ResultSet rs = c.query();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String country = rs.getString("country");
				CountryDao countDao = CountryDaoFactory.getCountryDao("postgresql");
				Country count = countDao.select(country);
				Team t = new Team(id,name,count);
				teams.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teams;
	}

	@Override
	public void delete(String id) throws SQLException 
	{
		try {
			c.setPreparedStatement(DELETE_TEAM_SQL);
			PreparedStatement pr = c.getPreparedStatement();
			pr.setString(1, id);
			c.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Team o) throws SQLException {
		// TODO Auto-generated method stub

	}
}
