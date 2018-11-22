package webapp.HospitalAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import webapp.DBConnection.DBConnection;

public class HospitalAdminService {

	private Connection con;

	public HospitalAdminService() {
		try {
			con = DBConnection.getInstance().getConnection();
		} catch (Exception e) {
			con = null;
			System.out.println(e);
		}

	}
	
	public void activateadmin(int id) {
		System.out.println("dvnesjngi");
		String sql = "UPDATE tblhospitaladmin SET Status=1 WHERE HospitalAdminID = " + id;
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deactivateadmin(int id) {
		System.out.println("dvnesjngi");
		String sql = "UPDATE tblhospitaladmin SET Status=0 WHERE HospitalAdminID = " + id;
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void addAdmin(HospitalAdmin temp) {

		try {

			String sql = "INSERT INTO tblhospitaladmin(HospitalID, HospitalAdminName, Username, Password, "
					+ "  Email, ContactNo, ApprovedBy,Status) " + "VALUES (?,?,?,?,?,?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, temp.hospitalId.getHospitalID());
			pst.setString(2, temp.getHospitalAdminName());
			pst.setString(3, temp.getHospitalAdminUsername());
			pst.setString(4, temp.getHospitalAdminPassword());
			pst.setString(5, temp.getHospitalAdminEmail());
			pst.setString(6, temp.getHospitalAdminContactNo());
			pst.setInt(7, temp.getApprovedBy().getHospitalAdminId());
			pst.setInt(8, temp.getStatus());
			pst.executeUpdate();

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Inserted");
	}

	public HospitalAdmin getSingleData(Integer id) {

		try {
			String sql;
			sql = "SELECT * FROM tblhospitaladmin WHERE HospitalAdminID = " + id;
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				HospitalAdmin temp = new HospitalAdmin(rs.getInt("HospitalAdminID"), rs.getInt("HospitalID"),
						rs.getString("HospitalAdminNAme"), rs.getString("Username"), rs.getString("Password"),
						rs.getString("Email"), rs.getString("ContactNo"), rs.getInt("Status"));
				return temp;
			}

		} catch (Exception e) {

		}
		return null;
	}

	public void updateadmin(Integer id, String hospitalAdminName, String hospitalAdminUsername,
			String hospitalAdminPassword, String hospitalContactNo, String hospitalEmail) {
		// TODO Auto-generated method stub
		try {

			String sql = "UPDATE tblhospitaladmin SET HospitalAdminName=?,Username=?,"
					+ "Password=?,Email=?,ContactNo=? WHERE HospitalAdminID=?";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, hospitalAdminName);
			pst.setString(2, hospitalAdminUsername);
			pst.setString(3, hospitalAdminPassword);
			pst.setString(4, hospitalEmail);
			pst.setString(5, hospitalContactNo);
			pst.setInt(6, id);
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public ArrayList<HospitalAdmin> adminListByHospital(int id) {

		ArrayList<HospitalAdmin> hospitalAdmins = new ArrayList<HospitalAdmin>();
		try {
			String sql = "Select * FROM tblhospitaladmin where HospitalID = " + id;
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				HospitalAdmin temp = new HospitalAdmin(rs.getInt("HospitalAdminID"), rs.getInt("HospitalID"),
						rs.getString("HospitalAdminName"), rs.getString("Username"), rs.getString("Password"),
						rs.getString("Email"), rs.getString("ContactNo"), rs.getInt("Status"));
				hospitalAdmins.add(temp);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return hospitalAdmins;
	}

}
