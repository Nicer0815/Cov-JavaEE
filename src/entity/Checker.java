package entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the tester database table.
 * 
 */
@Entity
@NamedQuery(name="Checker.findAll", query="SELECT t FROM Checker t")
public class Checker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String password;

	public Checker() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Checker [username=" + username + ", password=" + password + "]";
	}

}