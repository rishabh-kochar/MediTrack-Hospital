package webapp.Symptoms;

import java.sql.Connection;
import java.sql.PreparedStatement;

import webapp.DBConnection.DBConnection;

public class SymptomService {

	private Connection con;

	public SymptomService() {
		try {
			con = DBConnection.getInstance().getConnection();
		} catch (Exception e) {
			con = null;
			System.out.println(e);
		}

	}
	
	public void addSymptom(Symptoms temp) {
		try {
			
			String sql = "INSERT INTO tblsymptoms(AppointmentID, Symptons, Notes, AbstainFrom, Recommeneded, AddedBy) "
					+ "VALUES (?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, temp.getAppoitmentID().getAppointmentId());
			pst.setString(2, temp.getSymptoms());
			pst.setString(3, temp.getNotes());
			pst.setString(4, temp.getAbstainFrom());
			pst.setString(5, temp.getRecommended());
			pst.setInt(6, temp.getAddedBy().getdoctorID());
			pst.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
