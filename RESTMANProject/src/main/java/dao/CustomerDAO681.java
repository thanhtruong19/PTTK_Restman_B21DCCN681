package dao;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Customer681;

public class CustomerDAO681 extends DAO {
	public static int saveCustomer681(Customer681 customer) {
		int customerID = -1;
		boolean isUpdated = false;
		try {
			String sql1 = "SELECT id from tblcustomer681 where phoneNumber = ?";
			PreparedStatement checkStmt = con.prepareStatement(sql1);
            checkStmt.setString(1, customer.getPhoneNumber());
            ResultSet rs = checkStmt.executeQuery();
            
            if(rs.next()) {
            	//nếu đã tồn tại, update dữ liệu
            	customerID = rs.getInt("id");
            	String sql2 = "UPDATE tblCustomer681 SET name = ?, address = ?, email = ?, phoneNumber = ? WHERE id = ?";
            	PreparedStatement updateStmt = con.prepareStatement(sql2);
            	updateStmt.setString(1, customer.getName());
            	updateStmt.setString(2, customer.getAddress());
            	updateStmt.setString(3, customer.getEmail());
            	updateStmt.setString(4, customer.getPhoneNumber());
            	updateStmt.setInt(5, customerID);
            	updateStmt.executeUpdate();
            	updateStmt.close();
            }else {
            	String sql3 = "INSERT INTO tblCustomer681(name, address, email, phoneNumber) VALUES(?, ?, ?, ?)";
            	PreparedStatement insertStmt = con.prepareStatement(sql3);
            	insertStmt.setString(1, customer.getName());
            	insertStmt.setString(2, customer.getAddress());
            	insertStmt.setString(3, customer.getEmail());
            	insertStmt.setString(4, customer.getPhoneNumber());
            	insertStmt.executeUpdate();
            	
            	 // Lấy ID của bản ghi vừa được tạo
            	 ResultSet tableID = insertStmt.getGeneratedKeys();

            	 if (tableID.next()) {
                     customerID = tableID.getInt(1);  // Lấy ID tự động tạo của bản ghi vừa chèn
                 }
            	 tableID.close();
                 insertStmt.close();
            }
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return customerID;
	}
}
