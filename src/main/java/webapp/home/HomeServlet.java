package webapp.home;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.hospital.Hospital;
import webapp.hospital.HospitalService;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/adminhome")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Hospital id = (Hospital) request.getSession().getAttribute("sessionHospitalId");
		request.setAttribute("HospitalData", hs.getHospitalbyID(id.getHospitalID()));
		request.getRequestDispatcher("/WEB-INF/views/Adminhome.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hospitalContactNo = request.getParameter("txtcontactno");
		String hospitalEmailId = request.getParameter("txtemailid");
		String hospitalLocationURL = request.getParameter("txtlocationurl");
		String hospitalWebsiteURL = request.getParameter("txtebsiteurl");
		String hospitalOpeningTime = request.getParameter("txtopeningtime");
		String hospitalClosingTime = request.getParameter("txtclosingtime");
		String hospitalID = request.getParameter("txthospitalID");
		
		hs.updateProfile(hospitalID,hospitalContactNo,hospitalEmailId,hospitalLocationURL,hospitalWebsiteURL,hospitalOpeningTime,hospitalClosingTime);
		doGet(request,response);
	}
	
	HospitalService hs = new HospitalService();

}
