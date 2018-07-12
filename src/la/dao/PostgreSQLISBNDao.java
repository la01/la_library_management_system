package la.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.book.BookInfo;
import la.bean.book.Category;
import la.exception.DataAccessException;

public class PostgreSQLISBNDao extends DBManager {
	
	public BookInfo select(String isbn) throws DataAccessException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		BookInfo bookInfo = new BookInfo();
		try {
			String sql = "SELECT * FROM bookinfo b JOIN publisher p ON b.publisher_code = p.publisher_code \n" + 
					"JOIN category c ON b.category_code = c.category_code WHERE bookinfo_isbn = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, isbn);
			rs = stmt.executeQuery();

			while(rs.next()) {
				bookInfo.setISBN(rs.getString("bookinfo_isbn"));
				bookInfo.setName(rs.getString("bookinfo_name"));
				bookInfo.setCategoryName(rs.getString("category_name"));
				bookInfo.setAuthor(rs.getString("bookinfo_author"));
				bookInfo.setPublisher(rs.getString("publisher_name"));
				bookInfo.setPublishedDay(rs.getDate("bookinfo_date"));
			}

		} catch(Exception e) {
			e.printStackTrace();
			throw new DataAccessException("SQLの実行中にエラーが発生しました");
		} finally {
			try {
				close(rs, stmt, conn);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataAccessException("SQLの終了中にエラーが発生しました");
			}
		}

		return bookInfo;
	}
}
