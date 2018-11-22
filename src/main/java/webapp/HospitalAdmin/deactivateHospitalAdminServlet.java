package webapp.HospitalAdmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deactivatehospitaladmin
 */
@WebServlet(urlPatterns = "/deactiveadmin")
public class deactivateHospitalAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HospitalAdminService has = new HospitalAdminService();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deactivateHospitalAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("vjgn");
		String str = request.getQueryString();
		if (str != null) {
			String[] stringArray = str.split("=");
			String id = stringArray[1];
			// System.out.println(id);
			has.deactivateadmin(Integer.parseInt(id));
			response.sendRedirect("/hospital/admins");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
