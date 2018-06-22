package com.lokesh.learnings;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/submitForm")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Into the get Method");
		InitializeVelocityEngine initializeVelocityEngine = new InitializeVelocityEngine();
		Map<String, Object> map = initializeVelocityEngine.InitializeVE();
		
		VelocityContext velocityContext = (VelocityContext) map.get("VelocityContext");
		VelocityEngine velocityEngine = (VelocityEngine) map.get("VelocityEngine");
		
		Template t = velocityEngine.getTemplate("templates/htmlForm.vm");
		
		velocityContext.put("title","Read Form Data");
		velocityContext.put("first_name",request.getParameter("first_name"));
		velocityContext.put("last_name",request.getParameter("last_name"));
		velocityContext.put("maths",request.getParameter("maths"));
		velocityContext.put("physics",request.getParameter("physics"));
		velocityContext.put("chemistry",request.getParameter("chemistry"));
		
		PrintWriter wr = response.getWriter();
		t.merge( velocityContext, wr );
		wr.close();
	}

}
