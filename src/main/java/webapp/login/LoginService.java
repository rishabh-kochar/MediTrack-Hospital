package webapp.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import webapp.DBConnection.DBConnection;
import webapp.Doctor.Doctor;
import webapp.HospitalAdmin.HospitalAdmin;

public class LoginService {

	private Connection con;

	public LoginService() {
		try {
			con = DBConnection.getInstance().getConnection();
		} catch (Exception e) {
			con = null;
			System.out.println(e);
		}

	}

	public HospitalAdmin getSingleData(String user, String password) {

		try {
			String sql;
			sql = "SELECT * FROM tblhospitaladmin WHERE Username=? and Password=? and Status = 1";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, user);
			pst.setString(2, password);
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

	public boolean isUserValid(String user, String password) {
		try {

			String sql;
			sql = "SELECT * FROM tblhospitaladmin WHERE Username=? and Password=? and Status=1";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, user);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return false;

	}

	public boolean isDoctorValid(String user, String password) {
		try {

			String sql;
			sql = "SELECT * FROM tbldoctor WHERE username=? and password=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, user);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return false;

	}

	public Doctor getSingleDoctor(String user, String password) {

		try {
			String sql;
			sql = "SELECT * FROM tbldoctor WHERE Username=? and Password=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, user);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Doctor temp = new Doctor(rs.getInt("DoctorID"), rs.getString("DoctorName"), rs.getString("username"),
						rs.getString("password"), rs.getString("DoctorDesignation"),
						rs.getString("DoctorSpecialization"), rs.getString("DoctorContact"),
						rs.getString("DoctorAddress"), rs.getInt("Status"));
				return temp;
			}

		} catch (Exception e) {

		}
		return null;
	}

}
