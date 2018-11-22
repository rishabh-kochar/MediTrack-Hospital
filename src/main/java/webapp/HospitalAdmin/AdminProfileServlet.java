package webapp.HospitalAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminProfileServlet
 */
@WebServlet(urlPatterns = "/adminprofile")
public class AdminProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = (Integer) request.getSession().getAttribute("sessionId");
		request.setAttribute("ProfileData", adminProfileService.getSingleData(id));
		request.getRequestDispatcher("WEB-INF/views/adminprofile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = (Integer) request.getSession().getAttribute("sessionId");
		String hospitalAdminName = request.getParameter("txtadminname");
		String hospitalAdminUsername = request.getParameter("txtusername");
		String hospitalAdminPassword = request.getParameter("txtpassword");
		String hospitalEmail = request.getParameter("txtemail");
		String hospitalContactNo = request.getParameter("txtcontactno");
		
		adminProfileService.updateadmin(id,hospitalAdminName,hospitalAdminUsername,hospitalAdminPassword,hospitalContactNo,hospitalEmail);
		doGet(request,response);
	}
	
	HospitalAdminService adminProfileService = new HospitalAdminService();

}
