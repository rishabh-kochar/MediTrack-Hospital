package webapp.Patients;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import webapp.DBConnection.DBConnection;
import webapp.Doctor.Doctor;
import webapp.Doctor.DoctorService;
import webapp.Symptoms.Symptoms;
import webapp.appointments.Appointment;
import webapp.appointments.AppointmentService;

public class PatientService {

	private Connection con;
	private AppointmentService as = new AppointmentService(); 
	private DoctorService ds = new DoctorService();

	public PatientService() {
		try {
			con = DBConnection.getInstance().getConnection();
		} catch (Exception e) {
			con = null;
			System.out.println(e);
		}

	}

	public Patient getPatientbyID(int id) {

		try {

			// System.out.println("vsgsgsghrh");
			System.out.println("dvdseg");
			String sql = "select * from tblpatient where patientid=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			System.out.println("dvdseg");
			while (rs.next()) {

				Patient temppatient = new Patient(rs.getInt("PatientID"), rs.getString("PatientName"),
						rs.getString("username"), rs.getString("password"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getDate("date_of_birth"),
						rs.getString("contact"), rs.getDate("joining"));
				return temppatient;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public ArrayList<Patient> PatientList() throws ClassNotFoundException, SQLException {

		ArrayList<Patient> patientls = new ArrayList<Patient>();
		try {

			// System.out.println("vsgsgsghrh");
			String sql = "Select * from tblpatient where Status = 1";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Patient temppatient = new Patient(rs.getInt("PatientID"), rs.getString("PatientName"),
						rs.getString("username"), rs.getString("password"), rs.getString("address"),
						rs.getString("gender"), rs.getString("email"), rs.getDate("date_of_birth"),
						rs.getString("contact"), rs.getDate("joining"));
				patientls.add(temppatient);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return patientls;

	}

	public void addPatient(String PatientName, String username, String password, String address, String gender,
			String email, Date date_of_birth, String contact)

			throws ClassNotFoundException, SQLException {

		System.out.println(date_of_birth);
		try {

			String sql = "insert into tblpatient(PatientName,username,password,address,gender,email,date_of_birth,contact,joining,Status) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, PatientName);
			pst.setString(2, username);
			pst.setString(3, password);
			pst.setString(4, address);
			pst.setString(5, gender);
			pst.setString(6, email);
			pst.setDate(7, (java.sql.Date) date_of_birth);
			pst.setString(8, contact);
			Date date = new Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			pst.setDate(9, sqlDate);
			pst.setInt(10, 1);

			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updatePatient(String PatientName, String username, String password, String address, String gender,
			String email, Date date_of_birth, String contact, Date joining) {

		try {

			String sql = "UPDATE tblpatient SET PatientName=?,uername=?,password=?,address=?,gender=?,email=?,date_of_birth=?,contact=?,joining=? WHERE "
					+ "PatientID=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, PatientName);
			pst.setString(2, username);
			pst.setString(3, password);
			pst.setString(4, address);
			pst.setString(5, gender);
			pst.setString(6, email);
			pst.setDate(7, (java.sql.Date) date_of_birth);
			pst.setString(8, contact);
			pst.setDate(9, (java.sql.Date) joining);
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deletepatient(int id) {
		// TODO Auto-generated method stub

		try {

			String sql = "UPDATE tblpatient SET Status = 0 WHERE PatientID=" + id;
			PreparedStatement pst = con.prepareStatement(sql);
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<Symptoms> patientHistory(int id){
		ArrayList<Symptoms> sl = new ArrayList<Symptoms>();
		try {
			
			String sql = "SELECT *,s.AppointmentID appID FROM tblappointment a, tblsymptoms s WHERE a.AppointmentID = s.AppointmentID AND a.PatientID = " + id;
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				
				Appointment atemp = as.getAppointmentbyID(rs.getInt("appID"));
				Doctor dtemp = ds.getDoctorByID(rs.getInt("AddedBy"));
				Symptoms stemp =  new Symptoms(atemp, rs.getString("Symptons"), rs.getString("Notes"), rs.getString("AbstainFrom"), rs.getString("Recommeneded"), dtemp);
				sl.add(stemp);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return sl;
	}
}
