package com.globe.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.tools.javac.util.List;

public class Applicant {

	private String name;

	private String nationalId;

	private Integer age;

	private String connectionId;

	public Applicant(String name, String nationalId, Integer age, String connectionId) {
		super();
		this.name = name;
		this.nationalId = nationalId;
		this.age = age;
		this.connectionId = connectionId;
	}

	public Applicant() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
	}

	public void save(Applicant applicant) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "root");
		// here sonoo is database name, root is username and password
		String sql = "insert into T_APPLICANT values('" + name + "'," + age + ",'" + nationalId
				+ "'+ connectionId + \"')";

		Statement stmt = con.createStatement();
		int m = stmt.executeUpdate(sql);

		if (m == 1)
			System.out.println("inserted successfully : " + sql);
		else
			System.out.println("insertion failed");

		// Closing the connections
		con.close();

	}

	public ArrayList<Applicant> fetchApplicantList() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "root");

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select name,age,nationalId,connectionId from T_APPLICANT");
		
		ArrayList<Applicant> applicantList = new ArrayList<Applicant>();
		
		while(rs.next())
		{
			Applicant applicant = new Applicant();
			applicant.setAge(rs.getInt("age"));
			applicant.setNationalId(rs.getString("nationalId"));
			applicant.setName(rs.getString("name"));
			applicant.setConnectionId(rs.getString("connectionId"));
			applicantList.add(applicant);
		}

		con.close();
		return applicantList;

	}

}
