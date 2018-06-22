package com.lokesh.learnings;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InitializeVelocityEngine initializeVelocityEngine = new InitializeVelocityEngine();
		Map<String, Object> map = initializeVelocityEngine.InitializeVE();
		
		VelocityContext velocityContext = (VelocityContext) map.get("VelocityContext");
		VelocityEngine velocityEngine = (VelocityEngine) map.get("VelocityEngine");

		velocityContext.put("name","Lokesh"); 
		
		Template t = velocityEngine.getTemplate("templates/hello.vm");
		
		PrintWriter wr = response.getWriter();
		t.merge( velocityContext, wr );
		wr.close();
	}

}
