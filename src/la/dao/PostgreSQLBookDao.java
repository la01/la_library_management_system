package la.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import la.bean.book.Book;
import la.exception.DataAccessException;
public class PostgreSQLBookDao extends DBManager{

	public List<Book> select() throws DataAccessException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		try {
			String sql =
					"select bs.bookstate_id, bi.bookinfo_isbn, bi.bookinfo_name, c.category_code, c.category_name, " +
					"bi.bookinfo_author, p.publisher_name, bi.bookinfo_date, bs.bookstate_add from bookinfo bi JOIN " +
					"bookstate bs on bi.bookinfo_isbn = bs.bookinfo_isbn JOIN category c ON bi.category_code = " +
					"c.category_code JOIN publisher p ON  bi.publisher_code = p.publisher_code ";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while(rs.next()) {
				list.add(createBookFromResultSet(rs));
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

	public List<Book> selectByCondition(Book book) throws DataAccessException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		try {
			// create query
			String sql =
					"select bs.bookstate_id, bi.bookinfo_isbn, bi.bookinfo_name, c.category_code, c.category_name, " +
					"bi.bookinfo_author, p.publisher_name, bi.bookinfo_date, bs.bookstate_add from bookinfo bi JOIN " +
					"bookstate bs on bi.bookinfo_isbn = bs.bookinfo_isbn JOIN category c ON bi.category_code = " +
					"c.category_code JOIN publisher p ON  bi.publisher_code = p.publisher_code ";
			List<String> queryList = new ArrayList<String>();
			queryList.add("where");
			if(book.getId() != 0) {
				queryList.add("bookstate_id=?");
				queryList.add("and");
			}
			if(book.getISBNCode() != null) {
				queryList.add("bi.bookinfo_isbn like ?");
				queryList.add("and");
			}
			if(book.getName() != null) {
				queryList.add("bi.bookinfo_name like ?");
				queryList.add("and");
			}
			if(book.getCategoryCode() != -1) {
				queryList.add("c.category_code=?");
				queryList.add("and");
			}
			if(book.getAuthor() != null) {
				queryList.add("bi.bookinfo_author like ?");
				queryList.add("and");
			}
			if(book.getPublisher() != null) {
				queryList.add("p.publisher_name like ?");
				queryList.add("and");
			}
			if(book.getPublishedDay() != null) {
				queryList.add("bi.bookinfo_date = ?");
				queryList.add("and");
			}
			queryList.remove(queryList.size()-1);
			sql += " " + String.join(" ", queryList);

			//create statement
			stmt = conn.prepareStatement(sql);
			int count = 1;
			if(book.getId() != 0) {
				stmt.setInt(count, book.getId());
				count++;
			}
			if(book.getISBNCode() != null) {
				stmt.setString(count, "%"+book.getISBNCode()+"%");
				count++;
			}
			if(book.getName() != null) {
				stmt.setString(count, "%"+book.getName()+"%");
				count++;
			}
			if(book.getCategoryCode() != -1) {
				stmt.setInt(count, book.getCategoryCode());
				count++;
			}
			if(book.getAuthor() != null) {
				stmt.setString(count, "%"+book.getAuthor()+"%");
				count++;
			}
			if(book.getPublisher() != null) {
				stmt.setString(count, "%"+book.getPublisher()+"%");
				count++;
			}
			if(book.getPublishedDay() != null) {
				stmt.setDate(count, new java.sql.Date(book.getPublishedDay().getTime()));
				count++;
			}

			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(createBookFromResultSet(rs));
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

	public int insert(Book book) throws DataAccessException {
		return 0;
	}

	public boolean update(Book book) throws DataAccessException {
		return false;
	}

	public boolean delete(int id) throws DataAccessException {
		return false;
	}

	private Book createBookFromResultSet(ResultSet rs) throws DataAccessException {
		try {
			int id = rs.getInt("bookstate_id");
			String ISBNCode = rs.getString("bookinfo_isbn");
			String name = rs.getString("bookinfo_name");
			int categoryCode = rs.getInt("category_code");
			String categoryName = rs.getString("category_name");
			String author = rs.getString("bookinfo_author");
			String publisher = rs.getString("publisher_name");
			Date publishedDay = rs.getDate("bookinfo_date");
			Date addedDay = rs.getDate("bookstate_add");
			Date removedDay = rs.getDate("bookstate_remove");

			Book book = new Book();
			book.setId(id);
			book.setISBNCode(ISBNCode);
			book.setName(name);
			book.setCategoryCode(categoryCode);
			book.setCategoryName(categoryName);
			book.setAuthor(author);
			book.setPublisher(publisher);
			book.setPublishedDay(publishedDay);
			book.setAddedDay(addedDay);
			book.setRemovedDay(removedDay);
			return book;

		} catch(Exception e) {
			e.printStackTrace();
			throw new DataAccessException("資料情報の読み込み中にエラーが発生しました");
		}
	}
}
