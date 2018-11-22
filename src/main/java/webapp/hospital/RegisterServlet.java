package webapp.hospital;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.hospital.HospitalService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HospitalService hospitalservices = new HospitalService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
		try {
			request.setAttribute("hospitalType", hospitalservices.hospitalTypeList());
			// System.out.println("vfdb");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hospitalName = request.getParameter("txthospitalname");
		String hospitalAddress = request.getParameter("txtaddress");
		String hospitalRegistrationNo = request.getParameter("txtregistrationno");
		String hospitalContactNo = request.getParameter("txtcontactno");
		String hospitalEmailId = request.getParameter("txtemailid");
		String hospitalLocationURL = request.getParameter("txtlocationurl");
		String hospitalWebsiteURL = request.getParameter("txtebsiteurl");
		String hospitalOpeningTime = request.getParameter("txtopeningtime");
		String hospitalClosingTime = request.getParameter("txtclosingtime");
		int hospitalTypeID = Integer.parseInt(request.getParameter("dropdownhospitaltype"));
		
		
		try {
			hospitalservices.addHospital(hospitalName, hospitalAddress, hospitalRegistrationNo, hospitalContactNo, hospitalEmailId, hospitalTypeID, hospitalWebsiteURL, hospitalLocationURL, hospitalOpeningTime, hospitalClosingTime);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("message", "Invalid Credentials!");
		request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
	}

}
