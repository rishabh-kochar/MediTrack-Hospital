package webapp.filter;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/*")
public class LoginRequiredFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		String path = ((HttpServletRequest) servletRequest).getRequestURI();
		boolean resourceRequest = request.getRequestURI()
				.startsWith(request.getContextPath() + "/faces" + ResourceHandler.RESOURCE_IDENTIFIER);

		if (path.startsWith("/hospital/login") || path.startsWith("/hospital/register")) {
			chain.doFilter(servletRequest, servletResponse);
		} else {

			if (request.getSession().getAttribute("sessionName") != null || request.getSession().getAttribute("sessionDoctorName") != null) {
				chain.doFilter(servletRequest, servletResponse);
			} else {

				request.getRequestDispatcher("/login").forward(servletRequest, servletResponse);
			}
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
