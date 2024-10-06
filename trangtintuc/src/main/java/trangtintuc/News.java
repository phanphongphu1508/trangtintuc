package trangtintuc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NewsServlet", urlPatterns = { "/news" })
public class News extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Viết câu truy vấn lấy toàn bộ bảng news
		String query = "SELECT * FROM news";

		// Mở kết nối tới CSDL
		Connection connection = JDBCConnection.getConnection();

		try {
			// Chuẩn bị câu truy vấn cho JDBC
			PreparedStatement statement = connection.prepareStatement(query);

			// Thực hiện câu truy vấn
			ResultSet result = statement.executeQuery();

			// Tạo List đối tượng rỗng để lưu trữ dữ liệu lấy được từ câu truy vấn
			List<NewsEntity> listNews = new ArrayList<NewsEntity>();

			// Duyệt qua từng dòng dữ liệu truy vấn được và gán được vào trong list
			while (result.next()) {
				NewsEntity newsEntity = new NewsEntity();
				newsEntity.setId(result.getInt("id"));
				newsEntity.setTitle(result.getString("title"));
				newsEntity.setContent(result.getString("content"));
				newsEntity.setImage_url(result.getString("image_url"));
				newsEntity.setPublish_date(result.getString("publish_date"));

				listNews.add(newsEntity);
			}
			System.out.println("Kiểm tra " + listNews.size());
			
		} catch (Exception e) {
			System.out.println("Lỗi CSDL");
		}
	}
}