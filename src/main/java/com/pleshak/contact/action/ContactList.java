package com.pleshak.contact.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pleshak.contact.domain.Contact;
import com.pleshak.contact.utils.ConnectionDB;




public class ContactList {

	private int noOfRecords;

	private ArrayList<Contact> getContacts(String sql) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		ArrayList<Contact> contactList = new ArrayList<Contact>();
		Contact contact = null;
		try {
			conn = ConnectionDB.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				contact = new Contact();
				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setSurname(rs.getString("surname"));
				contact.setLogin(rs.getString("login"));
				contact.setEmail(rs.getString("email"));
				contact.setPhoneNumber(rs.getInt("phone_number"));

				contactList.add(contact);
			}
			rs.close();
			rs = pstmt.executeQuery("SELECT FOUND_ROWS()");
			if (rs.next())
				this.noOfRecords = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionDB.closeDbResources(conn, pstmt, rs);
		}

		return contactList;

	}

	public ArrayList<Contact> getAllContacts(int ofset, int noOfRecords) {

		String SELECT_ALL_CONTACTS_SQL = "SELECT SQL_CALC_FOUND_ROWS * FROM contact.contcts LIMIT " + ofset + ", " + noOfRecords;

		return getContacts(SELECT_ALL_CONTACTS_SQL);

	}

	public int getNoOfRcords() {
		return noOfRecords;
	}
}
