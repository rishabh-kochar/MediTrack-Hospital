package webapp.Doctor;

public class Doctor {

	int doctorID;
	String doctorName;
	String doctorUsername;
	String doctorPassword;
	String doctorDesignation;
	String doctorSpecialization;
	String doctorContact;
	String doctorAddress;
	int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getdoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	

	public String getDoctorUsername() {
		return doctorUsername;
	}

	public void setDoctorUsername(String doctorUsername) {
		this.doctorUsername = doctorUsername;
	}

	public String getDoctorPassword() {
		return doctorPassword;
	}

	public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}

	public String getDoctorDesignation() {
		return doctorDesignation;
	}

	public void setDoctorDesignation(String doctorDesignation) {
		this.doctorDesignation = doctorDesignation;
	}

	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}

	public void setdoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}

	public String getDoctorContact() {
		return doctorContact;
	}

	public void setDoctorContact(String doctorContact) {
		this.doctorContact = doctorContact;
	}

	public String getDoctorAddress() {
		return doctorAddress;
	}

	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}

	public Doctor(String doctorName, String username, String password, String doctorDesignation,
			String doctorSpecialization, String doctorContact, String doctorAddress, int status) {
		super();
		this.doctorName = doctorName;
		this.doctorUsername = username;
		this.doctorPassword = password;
		this.doctorDesignation = doctorDesignation;
		this.doctorSpecialization = doctorSpecialization;
		this.doctorContact = doctorContact;
		this.doctorAddress = doctorAddress;
		this.status = status;
	}

	public Doctor(int doctorID, String doctorName, String username, String password, String doctorDesignation,
			String doctorSpecialization, String doctorContact, String doctorAddress, int status) {
		super();
		this.doctorID = doctorID;
		this.doctorName = doctorName;
		this.doctorUsername = username;
		this.doctorPassword = password;
		this.doctorDesignation = doctorDesignation;
		this.doctorSpecialization = doctorSpecialization;
		this.doctorContact = doctorContact;
		this.doctorAddress = doctorAddress;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Doctor [doctorID=" + doctorID + ", doctorName=" + doctorName + ", username=" + doctorUsername + ", password="
				+ doctorPassword + ", doctorDesignation=" + doctorDesignation + ", doctorSpecialization="
				+ doctorSpecialization + ", doctorContact=" + doctorContact + ", doctorAddress=" + doctorAddress + "]";
	}
	
	

}
