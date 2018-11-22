package webapp.Prescription;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.Doctor.Doctor;
import webapp.Doctor.DoctorService;
import webapp.Medicine.Medicine;
import webapp.Medicine.MedicineService;
import webapp.appointments.Appointment;
import webapp.appointments.AppointmentService;

/**
 * Servlet implementation class AddPrescription
 */
@WebServlet(urlPatterns = "/addprescription")
public class AddPrescription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPrescription() {
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
		MedicineService ms = new MedicineService();
		request.setAttribute("medicineData", ms.medicineList());
		request.getRequestDispatcher("WEB-INF/views/addPrescription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrescriptionService ps = new PrescriptionService();
		DoctorService ds = new DoctorService();
		AppointmentService as = new AppointmentService();
		MedicineService ms = new MedicineService();

		Integer doctorID = (Integer) request.getSession().getAttribute("sessionDoctorId");
		Doctor dtemp = ds.getDoctorByID(doctorID);
		int appointmentID = Integer.parseInt(request.getParameter("txtappointmentid"));
		Appointment atemp = as.getAppointmentbyID(appointmentID);

		int medicineID = Integer.parseInt(request.getParameter("drpMedicine"));
		Medicine mtemp = ms.getMedicineByID(medicineID);

		float quantity = Float.parseFloat(request.getParameter("txtqty"));
		String morning = request.getParameter("txtmorning");
		String evening = request.getParameter("txtevening");
		String afternoon = request.getParameter("txtafternoon");
		int frequency = Integer.parseInt(request.getParameter("txtfrequency"));

		String sdate = request.getParameter("txtstartdate");
		String edate = request.getParameter("txtenddate");

		

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date startdate = null;
		java.util.Date enddate = null;
		try {
			startdate = sdf1.parse(sdate);
			enddate = sdf1.parse(edate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date sqlStartDate = new java.sql.Date(startdate.getTime());
		java.sql.Date sqlendDate = new java.sql.Date(enddate.getTime());

		Prescription temp = new Prescription(atemp, mtemp, morning, afternoon, evening, sqlStartDate, sqlendDate,
				frequency, dtemp, quantity);
		
		if (atemp == null) {
			System.out.println("Failed");
			request.setAttribute("medicineData", ms.medicineList());
			request.setAttribute("PrescriptionData", temp);
			request.setAttribute("errorMessage", "Appoitment Not Scheduled...!!");
			request.getRequestDispatcher("/WEB-INF/views/addPrescription.jsp").forward(request, response);
		}else {
			ps.addPrescription(temp);
			response.sendRedirect("/hospital/addprescription");
		}
		

	}

}
