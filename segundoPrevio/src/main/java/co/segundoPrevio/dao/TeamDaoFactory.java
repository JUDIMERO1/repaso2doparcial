package co.segundoPrevio.dao;

public class TeamDaoFactory {

	public static TeamDao getTeamDao(String type)
	{
		switch(type) {
		case "postgresql":
			return new TeamDaoPostgreSQL();
		case "mysql":
			return new TeamDaoMySQL();
		default:
			return new TeamDaoPostgreSQL();
		}
	}
}
