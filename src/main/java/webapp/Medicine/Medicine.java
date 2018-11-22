package webapp.Medicine;

public class Medicine {

	int medicineId;
	String medicineName;
	String manufacture;
	float weight;
	String infoURL;

	public Medicine(int medicineId, String medicineName, String manufacture, float weight, String infoURL) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.manufacture = manufacture;
		this.weight = weight;
		this.infoURL = infoURL;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getInfoURL() {
		return infoURL;
	}

	public void setInfoURL(String infoURL) {
		this.infoURL = infoURL;
	}

}
