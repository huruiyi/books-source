package vip.fairy.app14a.listener;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

import vip.fairy.app14a.servlet.FirstServlet;

@WebListener
public class DynRegListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	// use createServlet to obtain a Servlet instance that can be configured prior to being added to ServletContext
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();

		Servlet firstServlet = null;
		try {
			firstServlet = servletContext.createServlet(FirstServlet.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (firstServlet != null && firstServlet instanceof FirstServlet) {
			((FirstServlet) firstServlet).setName("Dynamically registered servlet");
		}

		// http://localhost:8090/app14a/dynamic
		ServletRegistration.Dynamic dynamic = servletContext.addServlet("firstServlet", firstServlet);
		dynamic.addMapping("/dynamic");
	}
}