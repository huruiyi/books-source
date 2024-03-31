package vip.fairy.initializer.initializer;

import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;

import vip.fairy.initializer.servlet.UsefulServlet;

@HandlesTypes({ UsefulServlet.class })
public class MyServletContainerInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> classes, ServletContext servletContext) {
		System.out.println("onStartup");
		ServletRegistration registration = servletContext.addServlet("usefulServlet", "vip.fairy.initializer.servlet.UsefulServlet");
		registration.addMapping("/useful");
		System.out.println("leaving onStartup");
	}
}
