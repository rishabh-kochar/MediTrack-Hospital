package webapp.DoctorHospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import webapp.DBConnection.DBConnection;
import webapp.hospital.HospitalService;

public class DoctorHospitalService {
	
	private Connection con;
	webapp.Doctor.DoctorService ds = new webapp.Doctor.DoctorService();
	HospitalService hs = new HospitalService();

	public DoctorHospitalService() {
		try {
			con = DBConnection.getInstance().getConnection();
		} catch (Exception e) {
			con = null;
			System.out.println(e);
		}

	}
	
	public DoctorHospital getByID(int hospitalID, int DoctorID) {
		
		DoctorHospital temp = null;
		try {
			System.out.println(hospitalID + " " + DoctorID);
			String sql = "Select * FROM tbldoctorhospital WHERE HospitalID = ? AND DOctorID = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, hospitalID);
			pst.setInt(2, DoctorID);
			ResultSet rs = pst.executeQuery();
			System.out.println("dvdseg");
			if(rs.next()) {
				temp = new DoctorHospital(rs.getInt("DoctorHospitalID"), ds.getHospitalbyID(rs.getInt("DoctorID")) , hs.getHospitalbyID(rs.getInt("HospitalID")), rs.getDate("DateofJoining") );
			}
			
			System.out.println("dvdseg");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return temp;
	}

}
