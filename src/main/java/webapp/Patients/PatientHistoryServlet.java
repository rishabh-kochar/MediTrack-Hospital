package webapp.Patients;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PatientHistoryServlet
 */
@WebServlet(urlPatterns = "/patienthistory")
public class PatientHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PatientService ps = new PatientService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientHistoryServlet() {
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
			
			request.setAttribute("patientData", ps.getPatientbyID(Integer.parseInt(id)));
			request.setAttribute("symptomsData", ps.patientHistory(Integer.parseInt(id)));
			request.setAttribute("flag", false);

		} else {
			request.setAttribute("flag", true);
		}
		
		
		request.getRequestDispatcher("WEB-INF/views/medicalHistory.jsp").forward(request, response);
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
