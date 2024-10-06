package trangtintuc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {

	// Định nghĩa hàm kết nối tới CSDL
	public static Connection getConnection() {
		Connection connection = null;

		try {
			// Khai báo driver sử dụng cho JDBC
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Dùng driver mở kết nối tới CSDL
			connection = DriverManager.getConnection("jdbc:mysql://localhost:1508/NewsDB", "root", "admin");

		} catch (Exception e) {

			System.out.println("Lỗi kết nối CSDL");
		}
		return connection;
	}
}



