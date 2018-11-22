package webapp.DoctorHospital;

import java.util.Date;

import webapp.Doctor.Doctor;
import webapp.hospital.Hospital;

public class DoctorHospital {

	int doctorHospitalID;
	Doctor doctorID;
	Hospital hospitalID;
	
	public DoctorHospital() {
		
	}

	public DoctorHospital(int doctorHospitalID, Doctor doctorID, Hospital hospitalID, Date joiningDate) {
		super();
		this.doctorHospitalID = doctorHospitalID;
		this.doctorID = doctorID;
		this.hospitalID = hospitalID;
		this.joiningDate = joiningDate;
	}

	public int getDoctorHospitalID() {
		return doctorHospitalID;
	}

	public void setDoctorHospitalID(int doctorHospitalID) {
		this.doctorHospitalID = doctorHospitalID;
	}

	public Doctor getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(Doctor doctorID) {
		this.doctorID = doctorID;
	}

	public Hospital getHospitalID() {
		return hospitalID;
	}

	public void setHospitalID(Hospital hospitalID) {
		this.hospitalID = hospitalID;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	Date joiningDate;
}
