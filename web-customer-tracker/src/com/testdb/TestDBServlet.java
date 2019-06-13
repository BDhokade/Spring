package com.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TestDBServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:MAHESH";
		String user = "SCOTT";
		String pass = "tiger";
		
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database: " + jdbcURL);
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(jdbcURL, user, pass);
			
			out.println("Connection Successfull");
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
	}

}
