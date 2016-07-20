package com.pleshak.contact.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pleshak.contact.domain.Contact;

public class ContactServlet extends HttpServlet {

	public ContactServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int page = 2;
		int recordsPerPage = 5;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			ContactList cl = new ContactList();
			ArrayList<Contact> list = cl.getAllContacts((page - 1) * recordsPerPage, recordsPerPage);
			int noOfRecords = cl.getNoOfRcords();
			int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			request.setAttribute("contactList", list);
			request.setAttribute("noOfPages", noOfPages);
			request.setAttribute("currentPage", page);
			RequestDispatcher view = request.getRequestDispatcher("view.jsp");
			view.forward(request, response);

		}

	}

}
