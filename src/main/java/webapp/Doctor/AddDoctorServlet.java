package webapp.Doctor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.hospital.Hospital;

/**
 * Servlet implementation class AddDoctorServlet
 */
@WebServlet(urlPatterns = "/adddoctor")
public class AddDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDoctorServlet() {
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
		String str = request.getQueryString();
		if (str != null) {
			String[] stringArray = str.split("=");
			String id = stringArray[1];
			System.out.println(id);
			request.setAttribute("doctorID", id);
			request.setAttribute("doctorData", doctorservices.getHospitalbyID(Integer.parseInt(id)));

		} else {
			request.setAttribute("doctorID", "new");
		}
		request.getRequestDispatcher("/WEB-INF/views/adddoctor.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String doctorName = request.getParameter("txtdoctorname");
		String doctorUsername = request.getParameter("txtusername");
		String doctorPassword = request.getParameter("txtpassword");
		String doctorDesignation = request.getParameter("txtdesignation");
		String doctorSpecialixation = request.getParameter("txtspecialization");
		String doctorContactNo = request.getParameter("txtcontactno");
		String doctorAddress = request.getParameter("txtaddress");
		int status = 1;
		String doctorID = request.getParameter("doctorID");
		Hospital h = (Hospital) request.getSession().getAttribute("sessionHospitalId");
		int hospitalID = h.getHospitalID();
		try {
			if(doctorID.equals("new")) {
				Doctor temp = new Doctor(doctorName, doctorUsername, doctorPassword, doctorDesignation, doctorSpecialixation,
						doctorContactNo, doctorAddress, status);
				doctorservices.addDoctor(temp, hospitalID);
			}else {
				int id =  Integer.parseInt(request.getParameter("doctorID"));
				Doctor temp = new Doctor(id,doctorName, doctorUsername, doctorPassword, doctorDesignation, doctorSpecialixation,
						doctorContactNo, doctorAddress, status);
				doctorservices.updateDoctor(temp);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		response.sendRedirect("/hospital/doctor");
	}

	private DoctorService doctorservices = new DoctorService();

}
