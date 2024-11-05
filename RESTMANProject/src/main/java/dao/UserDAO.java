package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import model.User;

public class UserDAO extends DAO {
	public UserDAO() {

	}
	public boolean loginCheck(User user) {
		boolean kq = false;
		if (user.getUserName().contains("true") || user.getUserName().contains("=")
				|| user.getPassword().contains("true") || user.getPassword().contains("="))
			return false;
		String sql = "{call loginCheck(?, ?)}";

		try {
			
			
			CallableStatement cs =  con.prepareCall(sql);
			cs.setString(1, user.getUserName());
			cs.setString(2, user.getPassword());
			ResultSet rs = cs.executeQuery();
			if (rs.next()) {
				//nếu có dữ liệu thì sẽ set dữ liệu từ server cho user
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				user.setDateOfBirth(rs.getDate("dateOfBirth"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				user.setPhoneNumber("phoneNumber");
				user.setRole(rs.getString("role"));
				user.setNote(rs.getString("note"));
				kq = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			kq = false;
		}
		return true;
	}
	public static void main(String[] args) {
		
	}
	
	
	
	
	

}