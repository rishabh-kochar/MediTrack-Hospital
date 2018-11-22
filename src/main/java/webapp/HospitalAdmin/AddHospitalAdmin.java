package webapp.HospitalAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.hospital.Hospital;

/**
 * Servlet implementation class AddHospitalAdmin
 */
@WebServlet(urlPatterns = "/addadmin")
public class AddHospitalAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHospitalAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/views/addhospitalAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("bfrhre");
		Integer id = (Integer) request.getSession().getAttribute("sessionId");
		
		String adminName = request.getParameter("txthospitaladminanme");
		String username = request.getParameter("txtusername");
		String password = request.getParameter("txtpassword");
		String contactno = request.getParameter("txtcontactno");
		String email = request.getParameter("txtemail");
		Hospital h = (Hospital) request.getSession().getAttribute("sessionHospitalId");
		HospitalAdmin temp = new HospitalAdmin();
		HospitalAdmin temp2 = new HospitalAdmin();
		temp2.setHospitalAdminId(id);
		temp.setHospitalId(h);
		temp.setHospitalAdminName(adminName);
		temp.setHospitalAdminUsername(username);
		temp.setHospitalAdminPassword(password);
		temp.setHospitalAdminContactNo(contactno);
		temp.setHospitalAdminEmail(email);
		temp.setApprovedBy(temp2);
		temp.setStatus(1);
		System.out.println("Inserting");
		has.addAdmin(temp);
		response.sendRedirect("/hospital/admins");
		
	}
	
	HospitalAdminService has = new HospitalAdminService();

}
