package webapp.appointments;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.Doctor.DoctorService;
import webapp.DoctorHospital.DoctorHospital;
import webapp.DoctorHospital.DoctorHospitalService;
import webapp.HospitalAdmin.HospitalAdmin;
import webapp.HospitalAdmin.HospitalAdminService;
import webapp.Patients.Patient;
import webapp.Patients.PatientService;
import webapp.hospital.Hospital;

/**
 * Servlet implementation class AddAppointment
 */
@WebServlet(urlPatterns = "/addapp")
public class AddAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DoctorService ds = new DoctorService();
	AppointmentService as = new AppointmentService();
	PatientService ps = new PatientService();
	DoctorHospitalService dhs = new DoctorHospitalService();
	HospitalAdminService has = new HospitalAdminService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAppointment() {
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
			Hospital id = (Hospital) request.getSession().getAttribute("sessionHospitalId");
			request.setAttribute("doctorType", ds.doctorListHospital(id.getHospitalID()));
			// System.out.println("vfdb");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("WEB-INF/views/addappointment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int patienID =  Integer.parseInt(request.getParameter("txtpatientid"));
		int doctorID = Integer.parseInt(request.getParameter("drpdoctor"));
		String appointmentdate = request.getParameter("txtappointmentdate");
		String illness = request.getParameter("txtillness");
		Hospital id = (Hospital) request.getSession().getAttribute("sessionHospitalId");
		int hospitalID = id.getHospitalID();
		Integer adminID = (Integer) request.getSession().getAttribute("sessionId");
		
		Patient ptemp = ps.getPatientbyID(patienID);
		DoctorHospital dhtemp = dhs.getByID(hospitalID, doctorID);
		HospitalAdmin hatemp = has.getSingleData(adminID);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = sdf1.parse(appointmentdate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
		
		Appointment temp = new Appointment(0, ptemp, dhtemp, sqlStartDate, 1, hatemp, illness);
		as.addAppointment(temp);
		response.sendRedirect("/hospital/appointment");
	}

}
