package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.*;

import model.Food681;

public class foodDAO681 extends DAO {
	public foodDAO681() {
		// TODO Auto-generated constructor stub
	}

	public static boolean saveNewFood681(Food681 food) {
		boolean kq = false;
		String sqlSaveFood = "INSERT INTO tblfood681(name, price, description, photo) VALUES(?,?,?,?)";
		try {
			if (con == null || con.isClosed()) {
				System.out.println("Connection is closed or null. Reconnecting...");
				new DAO(); // Kết nối lại
			}
			CallableStatement cs = con.prepareCall(sqlSaveFood);
			cs.setString(1, food.getName());
			cs.setFloat(2, food.getPrice());
			cs.setString(3, food.getDescription());
			cs.setString(4, food.getPhoto());
			cs.execute();
			kq = true;
		} catch (Exception e) {
			// lưu thất bại vì trùng nameFood
			e.printStackTrace();
			kq = false;
		}
		return kq;
	}
}
