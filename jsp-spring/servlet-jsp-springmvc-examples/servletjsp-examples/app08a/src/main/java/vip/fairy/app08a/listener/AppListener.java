package vip.fairy.app08a.listener;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();

		Map<String, String> countries = new HashMap<String, String>();
		countries.put("ca", "Canada");
		countries.put("us", "United States");
		servletContext.setAttribute("countries", countries);
	}
}