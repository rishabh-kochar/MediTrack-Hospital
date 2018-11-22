package webapp.Medicine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import webapp.DBConnection.DBConnection;

public class MedicineService {
	
	private Connection con;

	public MedicineService() {
		try {
			con = DBConnection.getInstance().getConnection();
		} catch (Exception e) {
			con = null;
			System.out.println(e);
		}

	}
	
	public ArrayList<Medicine> medicineList(){
		
		ArrayList<Medicine> mList = new ArrayList<Medicine>();
		try {
			
			String sql = "SELECT * FROM tblmedicine";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Medicine temp = new Medicine(rs.getInt("MedicineID"), rs.getString("MedicineName"),rs.getString("Manufacturer"), rs.getFloat("Weight"), rs.getString("InfoURL"));
				mList.add(temp);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return mList;
	}
	
	public Medicine getMedicineByID(int id) {
		Medicine temp = null;
		try {
			
			String sql = "SELECT * FROM tblmedicine WHERE MedicineID = " + id;
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				temp = new Medicine(rs.getInt("MedicineID"), rs.getString("MedicineName"),rs.getString("Manufacturer"), rs.getFloat("Weight"), rs.getString("InfoURL"));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return temp;
	}

}
