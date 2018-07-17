package la.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.book.Category;
import la.exception.DataAccessException;

public class PostgreSQLCategoryDao extends DBManager{

	public List<Category> select() throws DataAccessException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Category> list = new ArrayList<Category>();
		try {
			String sql = "select * from category";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()) {
				list.add(createCategoryFromResultSet(rs));
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

		return list;
	}

	private Category createCategoryFromResultSet(ResultSet rs) throws DataAccessException {
		try {
			int categoryCode = rs.getInt("category_code");
			String categoryName = rs.getString("category_name");

			Category category = new Category();
			category.setCategoryCode(categoryCode);
			category.setCategoryName(categoryName);
			return category;

		} catch(Exception e) {
			e.printStackTrace();
			throw new DataAccessException("カテゴリー情報の読み込み中にエラーが発生しました");
		}
	}
}
