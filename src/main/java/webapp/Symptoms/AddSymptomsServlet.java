package webapp.Symptoms;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.Doctor.Doctor;
import webapp.Doctor.DoctorService;
import webapp.appointments.Appointment;
import webapp.appointments.AppointmentService;

/**
 * Servlet implementation class AddSymptoms
 */
@WebServlet(urlPatterns = "/handleapp")
public class AddSymptomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SymptomService ss = new SymptomService();
	AppointmentService as = new AppointmentService();
	DoctorService ds = new DoctorService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddSymptomsServlet() {
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
			// System.out.println(id);
			request.setAttribute("appointmentID", id);
		}
		request.getRequestDispatcher("/WEB-INF/views/handleapp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer appointmentID = Integer.parseInt(request.getParameter("txtappointmentid"));
		String symptoms = request.getParameter("txtsymptoms");
		String notes = request.getParameter("txtnotes");
		String abstainFrom = request.getParameter("txtabstain");
		String recommended = request.getParameter("txtrecommened");
		Integer doctorID = (Integer) request.getSession().getAttribute("sessionDoctorId");
		Appointment atemp = as.getAppointmentbyID(appointmentID);
		Doctor dtemp = ds.getDoctorByID(doctorID);
		Symptoms temp = new Symptoms(atemp, symptoms, notes, abstainFrom, recommended, dtemp);
		ss.addSymptom(temp);
		response.sendRedirect("/hospital/doctorhome");
	}

}
