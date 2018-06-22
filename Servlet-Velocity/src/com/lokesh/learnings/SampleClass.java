package com.lokesh.learnings;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class SampleClass {

	public static void main(String[] args) {
		VelocityEngine ve = new VelocityEngine();
		ve.init(); /* Initialises the Velocity engine */
		VelocityContext context = new VelocityContext();
		/* the user object will be available under the name "user" in the template*/
		context.put("name","Lokesh"); 
		Template t = ve.getTemplate("./WebContent/hello.vm");
		StringWriter writer = new StringWriter();
		t.merge( context, writer );
		System.out.println(writer);
	}

}
