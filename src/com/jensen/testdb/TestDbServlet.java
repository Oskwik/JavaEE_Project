package com.jensen.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 * Using for test DB-connection only
 * 
 * @author Shul, Oskwik
 * @version 2.0
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username="webuser";
		String password="webuser";
		String url="jdbc:mysql://localhost:3306/mydb?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		// get connection to DB
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to DB " + url);
			
			Class.forName(driver);
			Connection myCon = DriverManager.getConnection(url, username, password);
			out.println("<br><br>Connected to DB !!!");
			
			myCon.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
		
		
		
	}

}
