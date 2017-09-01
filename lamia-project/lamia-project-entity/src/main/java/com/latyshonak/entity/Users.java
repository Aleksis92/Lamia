package com.latyshonak.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "login", unique = true, nullable = false, length = 20 )
	private String login;
	
	@Column(name = "password", nullable = false, length = 20)
	private String password;
	
	@Column( name = "role", length = 1)
	private int role;
	
	@Column( name = "del_status", length = 1)
	private int del_status;
	
	
	@Column( name = "e_mail", length = 50)
	private String e_mail;

	
	
	public Users() {

	}



	public Users(String login, String password, String e_mail, int role, int del_status) {
		this.login = login;
		this.password = password;
		this.role = role;
		this.del_status = del_status;
		this.e_mail = e_mail;
	}
	
	public Users(String login, String password, String e_mail) {
		this.login = login;
		this.password = password;
		this.e_mail = e_mail;
	}



	@Override
	public String toString() {
		return "Users [id=" + id + ", login=" + login + ", password=" + password + ", role=" + role + ", del_status="
				+ del_status + ", e_mail=" + e_mail + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + del_status;
		result = prime * result + ((e_mail == null) ? 0 : e_mail.hashCode());
		result = prime * result + id;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + role;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (del_status != other.del_status)
			return false;
		if (e_mail == null) {
			if (other.e_mail != null)
				return false;
		} else if (!e_mail.equals(other.e_mail))
			return false;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role != other.role)
			return false;
		return true;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getRole() {
		return role;
	}



	public void setRole(int role) {
		this.role = role;
	}



	public int getDel_status() {
		return del_status;
	}



	public void setDel_status(int del_status) {
		this.del_status = del_status;
	}



	public String getE_mail() {
		return e_mail;
	}



	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}






}
