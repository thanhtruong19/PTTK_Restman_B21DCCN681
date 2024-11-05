package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	public static Connection con;

	public DAO() {
        if (con == null) {
            String dbUrl = "jdbc:mysql://localhost:3306/restman?autoReconnect=true&useSSL=false&serverTimezone=UTC";
            String dbClass = "com.mysql.cj.jdbc.Driver";  // Sử dụng driver mới
            try {
                // Tải driver
                Class.forName(dbClass);
                // Thiết lập kết nối
                con = DriverManager.getConnection(dbUrl, "root", "123456");
                System.out.println("Kết nối thành công!");
            } catch (ClassNotFoundException e) {
                // Nếu driver không được tìm thấy
                e.printStackTrace();
                System.out.println("Không tìm thấy driver MySQL.");
            } catch (SQLException e) {
                // Nếu không thể kết nối đến MySQL
                e.printStackTrace();
                System.out.println("Kết nối thất bại!");
            }
        }
    }

    // Phương thức kiểm tra kết nối
    public boolean isConnected() {
        try {
            if (con != null && !con.isClosed()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


	public static void main(String[] args) {
		DAO dao = new DAO();
        if (dao.isConnected()) {
            System.out.println("Kết nối thành công!");
        } else {
            System.out.println("Kết nối thất bại!");
        }
	}
}
