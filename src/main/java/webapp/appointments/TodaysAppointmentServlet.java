package webapp.appointments;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.hospital.Hospital;

/**
 * Servlet implementation class TodaysAppointmentServlet
 */
@WebServlet(urlPatterns = "/todayapp")
public class TodaysAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AppointmentService as = new AppointmentService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TodaysAppointmentServlet() {
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
		Integer doctorID = (Integer) request.getSession().getAttribute("sessionDoctorId");
		Hospital ID = (Hospital) request.getSession().getAttribute("sessionHospitalId");
		try {
			request.setAttribute("appointmentData", as.AppointmentListForDoctor(ID.getHospitalID(), doctorID));
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		request.getRequestDispatcher("WEB-INF/views/todaysAppointment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
