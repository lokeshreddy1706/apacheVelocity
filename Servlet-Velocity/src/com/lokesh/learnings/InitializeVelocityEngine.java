package com.lokesh.learnings;

import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class InitializeVelocityEngine {
	public Map<String, Object> InitializeVE() {
		Map<String, Object> map = new HashMap<>();
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		velocityEngine.init(); 
		VelocityContext velocityContext = new VelocityContext();

		map.put("VelocityContext", velocityContext);
		map.put("VelocityEngine", velocityEngine);
		return map;
	}
}
