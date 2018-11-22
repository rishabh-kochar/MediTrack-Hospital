
package webapp.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import webapp.DBConnection.DBConnection;
import webapp.hospital.Hospital;
import webapp.hospital.HospitalService;

public class DoctorService {

	private Connection con;
	private HospitalService hs = new HospitalService();

	public DoctorService() {
		try {
			con = DBConnection.getInstance().getConnection();
		} catch (Exception e) {
			con = null;
			System.out.println(e);
		}

	}

	public ArrayList<Doctor> doctorList(int hospitalID) throws ClassNotFoundException, SQLException {

		ArrayList<Doctor> doctorls = new ArrayList<Doctor>();
		try {

			String sql = "SELECT * FROM `tbldoctor` WHERE doctorID NOT IN (SELECT d.`DoctorID` FROM tbldoctor d, tbldoctorhospital dt where d.DoctorID = dt.DoctorID and dt.HospitalID = "
					+ hospitalID + ");";

			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Doctor tempdoctor = new Doctor(rs.getInt("DoctorID"), rs.getString("DoctorName"),
						rs.getString("username"), rs.getString("password"), rs.getString("DoctorDesignation"),
						rs.getString("DoctorSpecialization"), rs.getString("DoctorContact"),
						rs.getString("DoctorAddress"), rs.getInt("Status"));

				doctorls.add(tempdoctor);

				System.out.println(tempdoctor.toString());

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return doctorls;

	}

	public void activedoctor(int id) {
		// TODO Auto-generated method stub
		try {
			String sql = "UPDATE tbldoctor SET Status=1 WHERE DoctorID=" + id;
			PreparedStatement pst = con.prepareStatement(sql);
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void deactivedoctor(int id) {
		// TODO Auto-generated method stub
		try {
			String sql = "UPDATE tbldoctor SET Status=0 WHERE DoctorID=" + id;
			PreparedStatement pst = con.prepareStatement(sql);
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void addDoctor(Doctor temp, int hospitalID) {
		// { TODO Auto-generated method stub
		try {

			String sql = "INSERT INTO tbldoctor(DoctorName, username, password, "
					+ "DoctorDesignation, DoctorSpecialization, DoctorContact, " + "DoctorAddress, Status) "
					+ "VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, temp.getDoctorName());
			pst.setString(2, temp.getDoctorUsername());
			pst.setString(3, temp.getDoctorPassword());
			pst.setString(4, temp.getDoctorDesignation());
			pst.setString(5, temp.getDoctorSpecialization());
			pst.setString(6, temp.getDoctorContact());
			pst.setString(7, temp.getDoctorAddress());
			pst.setInt(8, temp.getStatus());
			pst.executeUpdate();

			java.sql.Statement stmt = null;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
			int doctorID = 0;
			if (rs.next()) {
				doctorID = rs.getInt(1);
			}

			Date date = new Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			sql = "INSERT INTO tbldoctorhospital(DoctorID, HospitalID, DateOfJoining) " + "Values (?,?,?)";
			pst = con.prepareStatement(sql);

			pst.setInt(1, doctorID);
			pst.setInt(2, hospitalID);
			pst.setDate(3, sqlDate);
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Doctor getHospitalbyID(int id) {
		// TODO Auto-generated method stub
		try {

			String sql = "Select * FROM tbldoctor WHERE DoctorID = " + id;
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Doctor tempdoctor = new Doctor(rs.getInt("DoctorID"), rs.getString("DoctorName"),
						rs.getString("username"), rs.getString("password"), rs.getString("DoctorDesignation"),
						rs.getString("DoctorSpecialization"), rs.getString("DoctorContact"),
						rs.getString("DoctorAddress"), rs.getInt("Status"));
				return tempdoctor;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public void updateDoctor(Doctor temp) {
		// TODO Auto-generated method stub
		try {
			String sql = "UPDATE tbldoctor SET DoctorName=?,username=?,password=?,"
					+ "DoctorDesignation=?,DoctorSpecialization=?,DoctorContact=?,"
					+ "DoctorAddress=? WHERE DoctorID=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, temp.getDoctorName());
			pst.setString(2, temp.getDoctorUsername());
			pst.setString(3, temp.getDoctorPassword());
			pst.setString(4, temp.getDoctorDesignation());
			pst.setString(5, temp.getDoctorSpecialization());
			pst.setString(6, temp.getDoctorContact());
			pst.setString(7, temp.getDoctorAddress());
			pst.setInt(8, temp.getdoctorID());
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Doctor> doctorListHospital(int hospitalID) throws ClassNotFoundException, SQLException {

		ArrayList<Doctor> doctorls = new ArrayList<Doctor>();
		try {

			String sql = "SELECT d.* FROM tbldoctor d, tbldoctorhospital dt where d.DoctorID = dt.DoctorID and dt.HospitalID = "
					+ hospitalID;

			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Doctor tempdoctor = new Doctor(rs.getInt("DoctorID"), rs.getString("DoctorName"),
						rs.getString("username"), rs.getString("password"), rs.getString("DoctorDesignation"),
						rs.getString("DoctorSpecialization"), rs.getString("DoctorContact"),
						rs.getString("DoctorAddress"), rs.getInt("Status"));

				doctorls.add(tempdoctor);

				System.out.println(tempdoctor.toString());

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return doctorls;

	}

	public void registerdoctor(int id, int hospitalID) {
		// TODO Auto-generated method stub
		try {
			Date date = new Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			String sql = "INSERT INTO tbldoctorhospital(DoctorID, HospitalID, DateOfJoining) " + "Values (?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1, id);
			pst.setInt(2, hospitalID);
			pst.setDate(3, sqlDate);
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<Hospital> getHospitals(int id) {

		ArrayList<Hospital> hl = new ArrayList<Hospital>();
		try {
			String sql = "Select HospitalID from tbldoctorhospital WHERE DoctorID = " + id;
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("HospitalID"));
				hl.add(hs.getHospitalbyID(rs.getInt("HospitalID")));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return hl;
	}

	public Doctor getDoctorByID(int id) {
		Doctor temp = null;
		try {

			String sql = "SELECT * FROM tbldoctor WHERE DoctorID = " + id;
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getString("DoctorName"));
				temp = new Doctor(rs.getInt("DoctorID"), rs.getString("DoctorName"), rs.getString("username"),
						rs.getString("password"), rs.getString("DoctorDesignation"),
						rs.getString("DoctorSpecialization"), rs.getString("DoctorContact"),
						rs.getString("DoctorAddress"), rs.getInt("Status"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return temp;
	}
}
