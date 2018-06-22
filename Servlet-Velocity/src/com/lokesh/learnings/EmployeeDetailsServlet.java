package com.lokesh.learnings;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

@WebServlet("/getEmployeeDetails")
public class EmployeeDetailsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InitializeVelocityEngine initializeVelocityEngine = new InitializeVelocityEngine();
		Map<String, Object> map = initializeVelocityEngine.InitializeVE();
		
		VelocityContext velocityContext = (VelocityContext) map.get("VelocityContext");
		VelocityEngine velocityEngine = (VelocityEngine) map.get("VelocityEngine");
		
		Template t = velocityEngine.getTemplate("templates/employeeDetails.vm");
		

		// JDBC driver name and database URL
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/test";
		int id = Integer.parseInt(request.getParameter("id"));

		// Database credentials
		final String USER = "root";
		final String PASS = "letmein88";

		Connection conn = null;
		Statement stmt = null;
		String sql;
		ResultSet rs = null;
		try {
			// Set response content type
			response.setContentType("text/html");
			PrintWriter wr = response.getWriter();

			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			sql = "SELECT * FROM employees where id = " + id;
			rs = stmt.executeQuery(sql);

			EmployeeDetailsView employeeDetailsView = null;
			List<EmployeeDetailsView> employeeDetailsViewList = new ArrayList<EmployeeDetailsView>();;
			// Extract data from result set
			while (rs.next()) {
				employeeDetailsView = new EmployeeDetailsView();
				
				employeeDetailsView.setId(rs.getInt("id"));
				employeeDetailsView.setFirst_name(rs.getString("first_name"));
				employeeDetailsView.setLast_name(rs.getString("last_name"));
				employeeDetailsView.setGender(rs.getString("gender"));
				employeeDetailsView.setAddress(rs.getString("address"));
				employeeDetailsView.setRole(rs.getString("role"));
				
				employeeDetailsViewList.add(employeeDetailsView);
			}
			velocityContext.put("resultList",employeeDetailsViewList);
			t.merge(velocityContext, wr);
			
			// Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
			wr.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	}
}
