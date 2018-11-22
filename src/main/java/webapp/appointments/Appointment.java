package webapp.appointments;

import java.util.Date;

import webapp.DoctorHospital.DoctorHospital;
import webapp.HospitalAdmin.HospitalAdmin;
import webapp.Patients.Patient;

public class Appointment {

	int appointmentId;
	Patient patientId;
	DoctorHospital doctorHospitalId;
	Date appointmentDateTime;
	int appointmentStatus;
	HospitalAdmin appprovedBy;
	String illness;
	
	

	public Appointment(int appointmentId, Patient patientId, DoctorHospital doctorHospitalId, Date appointmentDateTime,
			int appointmentStatus, HospitalAdmin appprovedBy, String illness) {
		super();
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.doctorHospitalId = doctorHospitalId;
		this.appointmentDateTime = appointmentDateTime;
		this.appointmentStatus = appointmentStatus;
		this.appprovedBy = appprovedBy;
		this.illness = illness;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Patient getPatientId() {
		return patientId;
	}

	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}

	public DoctorHospital getDoctorHospitalId() {
		return doctorHospitalId;
	}

	public void setDoctorHospitalId(DoctorHospital doctorHospitalId) {
		this.doctorHospitalId = doctorHospitalId;
	}

	public Date getAppointmentDateTime() {
		return appointmentDateTime;
	}

	public void setAppointmentDateTime(Date appointmentDateTime) {
		this.appointmentDateTime = appointmentDateTime;
	}

	public int getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(int appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}


	public HospitalAdmin getAppprovedBy() {
		return appprovedBy;
	}

	public void setAppprovedBy(HospitalAdmin appprovedBy) {
		this.appprovedBy = appprovedBy;
	}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

}
