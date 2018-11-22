package webapp.Doctor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoctorHome
 */
@WebServlet(urlPatterns = "/doctorhome")
public class DoctorHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DoctorService ds = new DoctorService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Integer id = (Integer) request.getSession().getAttribute("sessionDoctorId");
		System.out.println(id);
		request.setAttribute("doctorData", ds.getDoctorByID(id));
		request.getRequestDispatcher("/WEB-INF/views/DoctorHome.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		String doctorName = request.getParameter("txtdoctorname");
		String doctorPassword = request.getParameter("txtpassword");
		String doctorDesignation = request.getParameter("txtdesignation");
		String doctorSpecialization = request.getParameter("txtspecialization");
		String doctorContact = request.getParameter("txtcontact");
		String doctorAddress = request.getParameter("txtaddress");
		String doctorUserName = (String) request.getSession().getAttribute("sessionDoctorName");
		System.out.println(doctorUserName);
		Integer doctorID = (Integer) request.getSession().getAttribute("sessionDoctorId");
		
		Doctor temp = new Doctor(doctorID, doctorName, doctorUserName, doctorPassword, doctorDesignation, doctorSpecialization, doctorContact, doctorAddress, 1);
		ds.updateDoctor(temp);
		response.sendRedirect("/hospital/doctorhome");
	}

}
