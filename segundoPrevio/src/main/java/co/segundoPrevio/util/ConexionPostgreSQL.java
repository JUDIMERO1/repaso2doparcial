package co.segundoPrevio.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionPostgreSQL {

	private static ConexionPostgreSQL db;
	private Connection c = null;
	private PreparedStatement pr; //sentencia sql para interactuar con la DB
	
	/*private static final String host = "queenie.db.elephantsql.com";
	private static final String dbName = "mnjgxshj";
	private static final String driver = "org.postgresql.Driver";
	private static final String userName = "mnjgxshj";
	private static final String password = "Uzjqo00sxV0W9OzPEB1q3wpoVvGMbbUV";
	private static final String url = "jdbc:postgresql://" + host + ":5432/" + dbName;*/
	
	private static final String host = "database-2.cr5kiddvokid.us-east-2.rds.amazonaws.com";
	private static final String dbName = "giro";
	private static final String driver = "org.postgresql.Driver";
	private static final String userName = "test";
	private static final String password = "Test2021";
	private static final String url = "jdbc:postgresql://" + host + ":5432/" + dbName;
	
	private ConexionPostgreSQL() {
		
		try {
			Class.forName(driver).newInstance();
			c = (Connection)DriverManager.getConnection(url,userName,password);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void cerrarConexion()
	{
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//M�todo para realizar consultas a la DB
	public ResultSet query() throws SQLException
	{
		ResultSet res = pr.executeQuery();
		return res;
	}
	
	//M�todo para actualizaciones a la DB (inserciones, borrados, actualizaciones)
	public int execute() throws SQLException
	{
		int result = pr.executeUpdate();
		return result;
	}
	
	public Connection getCon()
	{
		return this.c;
	}
	
	//m�todo para crear el statement dada una sentencia sql
	public void setPreparedStatement(String sql) throws SQLException
	{
		this.pr = c.prepareStatement(sql);
	}
	
	public PreparedStatement getPreparedStatement()
	{
		return this.pr;
	}
	
	public static ConexionPostgreSQL getConexion()
	{
		if(db==null)
			db = new ConexionPostgreSQL();
		return db;
	}
	
}
