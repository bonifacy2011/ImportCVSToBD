package com.pleshak.contact.general;

import com.pleshak.contact.action.ContactList;

public class TestStart {

	public static void main(String[] args) {

		// UploadFile uf = new UploadFile();
		// uf.setContacts("c:/In.csv");

		ContactList cl = new ContactList();
		cl.getAllContacts(1, 2);
		// cl.getOrderByNameContactsAZ();
		// cl.getOrderByNameContactsZA();
	}
}