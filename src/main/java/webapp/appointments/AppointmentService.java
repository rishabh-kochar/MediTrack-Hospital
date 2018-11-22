package webapp.appointments;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import webapp.DBConnection.DBConnection;
import webapp.DoctorHospital.DoctorHospital;
import webapp.DoctorHospital.DoctorHospitalService;
import webapp.HospitalAdmin.HospitalAdmin;
import webapp.HospitalAdmin.HospitalAdminService;
import webapp.Patients.Patient;
import webapp.Patients.PatientService;

public class AppointmentService {

	private Connection con;
	//private PatientService ps = new PatientService();
	private DoctorHospitalService dhs = new DoctorHospitalService();
	private HospitalAdminService has = new HospitalAdminService();

	public AppointmentService() {
		try {
			con = DBConnection.getInstance().getConnection();
		} catch (Exception e) {
			con = null;
			System.out.println(e);
		}

	}

	public void addAppointment(Appointment temp) {

		try {

			String sql = "INSERT INTO tblappointment(PatientID, DoctorHospitalID, AppointmentDateTime, AppointmentStatus, ApprovedBy, Illness) "
					+ "VALUES (?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, temp.getPatientId().getPatientID());
			pst.setInt(2, temp.getDoctorHospitalId().getDoctorHospitalID());
			pst.setDate(3, (Date) temp.getAppointmentDateTime());
			pst.setInt(4, temp.getAppointmentStatus());
			pst.setInt(5, temp.getAppprovedBy().getHospitalAdminId());
			pst.setString(6, temp.getIllness());
			pst.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Appointment> AppointmentList(int hospitalID) throws ClassNotFoundException, SQLException {
		System.out.println("Insert");
		PatientService ps = new PatientService();
		ArrayList<Appointment> appointmentls = new ArrayList<Appointment>();
		try {
			System.out.println(hospitalID);
			// String sql = "SELECT * FROm tblappointment";
			String sql = "SELECT * FROM tblappointment a, tbldoctorhospital dh WHERE a.DoctorHospitalID = dh.DoctorHospitalID AND dh.HospitalID = "
					+ hospitalID;
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Patient ptemp = ps.getPatientbyID(rs.getInt("PatientID"));
				DoctorHospital dhtemp = dhs.getByID(rs.getInt("HospitalID"), rs.getInt("DoctorID"));
				HospitalAdmin hstemp = has.getSingleData(rs.getInt("ApprovedBy"));
				Appointment temp = new Appointment(rs.getInt("AppointmentID"), ptemp, dhtemp,
						rs.getDate("AppointmentDateTime"), rs.getInt("AppointmentStatus"), hstemp,
						rs.getString("Illness"));

				appointmentls.add(temp);

				// System.out.println(tempdoctor.toString());

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return appointmentls;

	}

	public void deleteAppointment(int id) {
		// TODO Auto-generated method stub
		try {
			String sql = "DELETE FROM tblappointment WHERE AppointmentID = " + id;
			PreparedStatement pst = con.prepareStatement(sql);
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void approveAppointment(int id) {
		// TODO Auto-generated method stub
		try {
			String sql = "UPDATE tblappointment SET AppointmentStatus=1 WHERE AppointmentID = " + id;
			PreparedStatement pst = con.prepareStatement(sql);
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public Appointment getAppointmentbyID(int id) {
		System.out.println("Appointment Insertion");
		PatientService ps = new PatientService();
		Appointment temp = null;
		try {

			String sql = "Select * FROM tblappointment a, tbldoctorhospital dh WHERE a.DoctorHospitalID = dh.DoctorHospitalID AND AppointmentID = " + id;
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Patient ptemp = ps.getPatientbyID(rs.getInt("PatientID"));
				DoctorHospital dhtemp = dhs.getByID(rs.getInt("HospitalID"), rs.getInt("DoctorID"));
				HospitalAdmin hstemp = has.getSingleData(rs.getInt("ApprovedBy"));
				temp = new Appointment(rs.getInt("AppointmentID"), ptemp, dhtemp, rs.getDate("AppointmentDateTime"),
						rs.getInt("AppointmentStatus"), hstemp, rs.getString("Illness"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return temp;
	}
	
	public ArrayList<Appointment> AppointmentListForDoctor(int hospitalID,int doctorID) throws ClassNotFoundException, SQLException {
		System.out.println("Hello " + hospitalID+ " " + doctorID );
		PatientService ps = new PatientService();
		ArrayList<Appointment> appointmentls = new ArrayList<Appointment>();
		try {
			System.out.println(hospitalID);
			// String sql = "SELECT * FROm tblappointment";
			String sql = "SELECT * FROM tblappointment a, tbldoctorhospital dh WHERE a.DoctorHospitalID = dh.DoctorHospitalID AND dh.HospitalID = "
					+ hospitalID + " AND DoctorID = " + doctorID + " AND a.AppointmentDateTime = CURDATE() AND Status = 1";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Patient ptemp = ps.getPatientbyID(rs.getInt("PatientID"));
				DoctorHospital dhtemp = dhs.getByID(rs.getInt("HospitalID"), rs.getInt("DoctorID"));
				HospitalAdmin hstemp = has.getSingleData(rs.getInt("ApprovedBy"));
				Appointment temp = new Appointment(rs.getInt("AppointmentID"), ptemp, dhtemp,
						rs.getDate("AppointmentDateTime"), rs.getInt("AppointmentStatus"), hstemp,
						rs.getString("Illness"));

				appointmentls.add(temp);

				System.out.println(ptemp.getPatientName());

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return appointmentls;

	}
	
	
}
