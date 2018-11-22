package webapp.Symptoms;

import webapp.Doctor.Doctor;
import webapp.appointments.Appointment;

public class Symptoms {

	Appointment appoitmentID;
	String symptoms;
	String notes;
	String abstainFrom;
	String recommended;
	Doctor addedBy;

	public Symptoms(Appointment appoitmentID, String symptoms, String notes, String abstainFrom, String recommended,
			Doctor addedBy) {
		super();
		this.appoitmentID = appoitmentID;
		this.symptoms = symptoms;
		this.notes = notes;
		this.abstainFrom = abstainFrom;
		this.recommended = recommended;
		this.addedBy = addedBy;
	}

	public Appointment getAppoitmentID() {
		return appoitmentID;
	}

	public void setAppoitmentID(Appointment appoitmentID) {
		this.appoitmentID = appoitmentID;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getAbstainFrom() {
		return abstainFrom;
	}

	public void setAbstainFrom(String abstainFrom) {
		this.abstainFrom = abstainFrom;
	}

	public String getRecommended() {
		return recommended;
	}

	public void setRecommended(String recommended) {
		this.recommended = recommended;
	}

	public Doctor getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(Doctor addedBy) {
		this.addedBy = addedBy;
	}

}
