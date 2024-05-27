package co.segundoPrevio.dao;

public class CountryDaoFactory {
	
	public static CountryDao getCountryDao(String type)
	{
		switch(type) {
		case "postgresql":
			return new CountryDaoPostgreSQL();
		case "mysql":
			return new CountryDaoMySQL();
		default:
			return new CountryDaoPostgreSQL();
		}
	}
}
