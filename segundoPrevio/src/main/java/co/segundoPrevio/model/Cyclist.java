package co.segundoPrevio.model;

import java.io.Serializable;
import java.sql.Date;

public class Cyclist implements Serializable {

	private int id; 
	private String name;
	private String email;
	private Date birthdate;
	private Country c;
	private Team t;
	
	public Cyclist(int id, String name, String email, Date birthdate, Country c, Team t) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthdate = birthdate;
		this.c = c;
		this.t = t;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Country getC() {
		return c;
	}
	public void setC(Country c) {
		this.c = c;
	}
	public Team getT() {
		return t;
	}
	public void setT(Team t) {
		this.t = t;
	}
	
	
	
}
