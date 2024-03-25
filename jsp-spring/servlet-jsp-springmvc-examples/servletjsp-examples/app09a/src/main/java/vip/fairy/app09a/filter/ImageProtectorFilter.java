package vip.fairy.app09a.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "ImageProtetorFilter", urlPatterns = { "*.png", "*.jpg", "*.gif" })
public class ImageProtectorFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("ImageProtectorFilter");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String referrer = httpServletRequest.getHeader("referer");
		System.out.println("referrer:" + referrer);
		if (referrer != null) {
			filterChain.doFilter(request, response);
		} else {
			throw new ServletException("Image not available");
		}
	}
}