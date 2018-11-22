package webapp.HospitalAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.hospital.Hospital;

/**
 * Servlet implementation class HospitalAdminServlet
 */
@WebServlet(urlPatterns = "/admins")
public class HospitalAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HospitalAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    HospitalAdminService hs = new HospitalAdminService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Hospital id = (Hospital) request.getSession().getAttribute("sessionHospitalId");
		request.setAttribute("admins",hs.adminListByHospital(id.getHospitalID()));
		//System.out.println("vfdb");
		
		request.getRequestDispatcher("WEB-INF/views/hospitalAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
