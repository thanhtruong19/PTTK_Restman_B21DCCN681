package dao;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import model.Food681;

public class tableDAO681 extends DAO{
	public static ArrayList<Integer> getEmptyTable681(Date newDate, String timeSlot) {
		ArrayList<Integer> tableNumbers = new ArrayList<Integer>(); 
		String sql = "{call getEmptyTables(?, ?)}";
		try {
			if (con == null || con.isClosed()) {
				System.out.println("Connection is closed or null. Reconnecting...");
				new DAO(); // Kết nối lại
			}
			CallableStatement cs = con.prepareCall(sql);
			cs.setDate(1, newDate);
			cs.setString(2, timeSlot);
			ResultSet rs = cs.executeQuery();
			
			while(rs.next()) {
				int tableNumber = rs.getInt("numberTable");
				tableNumbers.add(tableNumber);
			}
		} catch (Exception e) {
			// tìm bàn thất bại
			e.printStackTrace();
		}
		return tableNumbers;
	}
	
}
