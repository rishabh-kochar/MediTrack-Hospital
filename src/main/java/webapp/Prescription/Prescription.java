package webapp.Prescription;

import java.util.Date;

import webapp.Doctor.Doctor;
import webapp.Medicine.Medicine;
import webapp.appointments.Appointment;

public class Prescription {

	int PrescriptionId;
	Appointment appointmentId;
	Medicine medicineId;
	String morning;
	String afternoon;
	String evening;
	Date startDate;
	Date endDate;
	int frequency;
	Doctor AddedId;
	float quantity;

	public Prescription(Appointment appointmentId, Medicine medicineId, String morning, String afternoon,
			String evening, Date startDate, Date endDate, int frequency, Doctor addedId, float quantity) {
		super();
		this.appointmentId = appointmentId;
		this.medicineId = medicineId;
		this.morning = morning;
		this.afternoon = afternoon;
		this.evening = evening;
		this.startDate = startDate;
		this.endDate = endDate;
		this.frequency = frequency;
		AddedId = addedId;
		this.quantity = quantity;
	}

	public int getPrescriptionId() {
		return PrescriptionId;
	}

	public void setPrescriptionId(int prescriptionId) {
		PrescriptionId = prescriptionId;
	}

	public Appointment getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Appointment appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Medicine getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Medicine medicineId) {
		this.medicineId = medicineId;
	}

	public String getMorning() {
		return morning;
	}

	public void setMorning(String morning) {
		this.morning = morning;
	}

	public String getAfternoon() {
		return afternoon;
	}

	public void setAfternoon(String afternoon) {
		this.afternoon = afternoon;
	}

	public String getEvening() {
		return evening;
	}

	public void setEvening(String evening) {
		this.evening = evening;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public Doctor getAddedId() {
		return AddedId;
	}

	public void setAddedId(Doctor addedId) {
		AddedId = addedId;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
}
