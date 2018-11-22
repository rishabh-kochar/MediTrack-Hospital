package webapp.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.Doctor.Doctor;
import webapp.HospitalAdmin.HospitalAdmin;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet(urlPatterns = "/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService userValidationService = new LoginService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		String option = request.getParameter("optionsradio");

		if (option.equals("0")) {
			System.out.println("Admin");
			boolean isUserValid = userValidationService.isUserValid(name, password);
			HospitalAdmin admin = userValidationService.getSingleData(name, password);
			if (isUserValid) {
				request.getSession().setAttribute("sessionName", name);
				request.getSession().setAttribute("sessionId", admin.getHospitalAdminId());
				request.getSession().setAttribute("sessionHospitalId", admin.getHospitalId());
				response.sendRedirect("/hospital/adminhome");

			} else {
				request.setAttribute("errorMessage", "Invalid Credentials!");
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			}
		} else if (option.equals("1")) {
			System.out.println("Doctor");
			boolean isUserValid = userValidationService.isDoctorValid(name, password);
			Doctor doctor = userValidationService.getSingleDoctor(name, password);
			if (isUserValid) {
				request.getSession().setAttribute("sessionDoctorName", name);
				request.getSession().setAttribute("sessionDoctorId", doctor.getdoctorID());
				System.out.println(doctor.getdoctorID());
				response.sendRedirect("/hospital/select");

			} else {
				request.setAttribute("errorMessage", "Invalid Credentials!");
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			}

		} else {
			request.setAttribute("errorMessage", "Select a Radio Button..!!");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}

	}

}
