package com.pleshak.contact.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pleshak.contact.utils.ConnectionDB;

public class UploadFile extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// String fileName = request.getParameter("filePath");
		// System.out.println(fileName);

		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = ConnectionDB.getConnection();
			String fileName = "c:/In.csv";
			String tableName = "contacts";
			String esquel = " LOAD DATA LOCAL INFILE '" + fileName + "' INTO TABLE " + tableName + " " + " FIELDS TERMINATED BY \',\' ENCLOSED BY \'\"'" + " LINES TERMINATED BY \'\\n\'";

			pstmt = conn.prepareStatement(esquel);
			pstmt.executeUpdate();
			System.out.println("Загрузка произошла успешно.");

			request.getRequestDispatcher("/WEB-INF/views/uploadFileOk.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/views/errorUploadFile.jsp").forward(request, response);

		} finally {
			ConnectionDB.closeDbResources(conn, pstmt);
		}

	}

}
