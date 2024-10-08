package entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the operator database table.
 * 
 */
@Entity
@NamedQuery(name="White.findAll", query="SELECT o FROM White o")
public class White implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String password;

	public White() {
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
		return "White [username=" + username + ", password=" + password
				+ "]";
	}

}