package com.globe.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.globe.model.Applicant;

public class ConnectionService {

	public void createConnection(Applicant applicant)

	{

		String connectionSerialNumber = 100 + applicant.getNationalId() + applicant.getName();

		Applicant applicantNew = new Applicant(connectionSerialNumber, applicant.getNationalId(), applicant.getAge(),
				applicant.getName());

		try {
			applicantNew.save(applicantNew);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public ArrayList<Applicant> getAllConnectionInfo()

	{
		Applicant applicant = new Applicant();
		ArrayList<Applicant> applicantList = new ArrayList<Applicant>();

		try {
			applicantList = applicant.fetchApplicantList();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return applicantList;
	}

}
