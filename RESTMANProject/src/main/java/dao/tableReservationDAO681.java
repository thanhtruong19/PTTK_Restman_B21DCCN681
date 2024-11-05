package dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement; 

import model.Food681;
import model.tableReservation681;


public class tableReservationDAO681 extends DAO{
	
	
	public tableReservationDAO681() {
	}

	public static int saveTableReservation681(tableReservation681 tableReservation) throws SQLException {
				int tableReservationID = -1;
				String sql1 = "SELECT * from tbltablereservation681 where timeSlot = ? and reservationDate = ?";
				PreparedStatement checkStmt = con.prepareStatement(sql1);
	            checkStmt.setString(1, tableReservation.getTimeSlot());
	            checkStmt.setDate(2, tableReservation.getReservationDate());
	            ResultSet rs = checkStmt.executeQuery();
	            if(!rs.next()) { //nếu không có dữ liệu trả về
	            	String sql2 = "INSERT INTO tblTableReservation681 (timeSlot, reservationDate, isCheckedIn, bookingType, tblCustomer681id, tblFoodOrder681id, tblComboOrder681id, tblSalesStaff681id, tblInvoice681id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            	PreparedStatement insertStmt = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
	            	insertStmt.setString(1, tableReservation.getTimeSlot());
	            	insertStmt.setDate(2, tableReservation.getReservationDate());
	            	insertStmt.setString(3, tableReservation.getIsCheckedIn());
	            	insertStmt.setString(4, tableReservation.getBookingType());
	            	insertStmt.setInt(5, tableReservation.getCustomerID());
	            	insertStmt.setNull(6, java.sql.Types.INTEGER);
	            	insertStmt.setNull(7, java.sql.Types.INTEGER);
	            	insertStmt.setNull(8, java.sql.Types.INTEGER);
	            	insertStmt.setNull(9, java.sql.Types.INTEGER);
	            	insertStmt.executeUpdate();
	            	ResultSet tableReservationKey = insertStmt.getGeneratedKeys();
	            	if (tableReservationKey.next()) {
	                    tableReservationID = tableReservationKey.getInt(1); // Lấy ID
	                }
	            	System.out.println(tableReservationID);
	            }
	            return tableReservationID;
				
	}
	
	public static boolean saveTableReservationDetail681(int table, int tableReservationID) throws SQLException {
		boolean kq = false;
		try {
        String sql = "INSERT INTO tbltablereservationdetail681 (tblTable681id, tblTableReservation681id) VALUES (?, ?)";
        PreparedStatement insertStmt = con.prepareStatement(sql);
        insertStmt.setInt(1, table);
        insertStmt.setInt(2, tableReservationID);

        insertStmt.executeUpdate();
        kq = true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kq= false;
		}
        return kq;
		
}
}
	
