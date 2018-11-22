package webapp.Prescription;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import webapp.DBConnection.DBConnection;

public class PrescriptionService {

	private Connection con;

	public PrescriptionService() {
		try {
			con = DBConnection.getInstance().getConnection();
		} catch (Exception e) {
			con = null;
			System.out.println(e);
		}

	}
	
	public void addPrescription(Prescription temp) {
		try {
			
			String sql = "INSERT INTO tblappointment_prescription( AppointmentID, MedicineID, Quantity, "
					+ "Morning, Afternoon, Evening, Frequency, StartDate, EndDate, AddedBy) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, temp.getAppointmentId().getAppointmentId());
			pst.setInt(2, temp.getMedicineId().getMedicineId());
			pst.setFloat(3,temp.getQuantity());
			pst.setString(4, temp.getMorning());
			pst.setString(5, temp.getAfternoon());
			pst.setString(6, temp.getEvening());
			pst.setInt(7, temp.getFrequency());
			pst.setDate(8, (Date) temp.getStartDate());
			pst.setDate(9, (Date) temp.getEndDate());
			pst.setInt(10, temp.getAddedId().getdoctorID());
			pst.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
