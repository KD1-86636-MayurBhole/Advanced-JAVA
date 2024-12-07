package com.sunbeam.beans;

import java.sql.Date;

import javax.servlet.ServletException;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class RegisterBean {
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String date;
	public RegisterBean() {
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void registerUser() throws ServletException
	{
		Date sqlDate =Date.valueOf(date);
		try (UserDao userDao = new UserDaoImpl()) {
            User user = new User(1, firstname, lastname, email, password, sqlDate, 0, "voter");
            int result = userDao.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
