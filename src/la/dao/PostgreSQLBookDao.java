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
					"SELECT \n" + 
					"  bs.bookstate_id, \n" + 
					"  bi.bookinfo_isbn, \n" + 
					"  bi.bookinfo_name, \n" + 
					"  c.category_code, \n" + 
					"  c.category_name, \n" + 
					"  bi.bookinfo_author, \n" + 
					"  p.publisher_name, \n" + 
					"  bi.bookinfo_date, \n" + 
					"  bs.bookstate_add,\n" + 
					"  bs.bookstate_remove,\n" + 
					"  CASE WHEN r.rental IS FALSE THEN '2' ELSE '1' END AS rental_code,\n" + 
					"  CASE WHEN (r.rental IS NULL OR r.rental IS TRUE) AND delete_flag IS FALSE THEN '1' ELSE '2' END AS status_code\n" + 
					"FROM \n" + 
					"  bookinfo bi \n" + 
					"  JOIN bookstate bs ON bi.bookinfo_isbn = bs.bookinfo_isbn \n" + 
					"  JOIN category c ON bi.category_code = c.category_code \n" + 
					"  JOIN publisher p ON bi.publisher_code = p.publisher_code \n" + 
					"  LEFT JOIN (\n" + 
					"    SELECT \n" + 
					"      a.bookstate_id, \n" + 
					"      a.rental_rent, \n" + 
					"      a.rental_return, \n" + 
					"      CASE WHEN a.rental_rent IS NOT NULL \n" + 
					"      AND a.rental_return IS NULL THEN FALSE ELSE TRUE END AS rental \n" + 
					"    FROM \n" + 
					"      rental a \n" + 
					"      INNER JOIN (\n" + 
					"        SELECT \n" + 
					"          bookstate_id, \n" + 
					"          max(rental_rent) AS rental_rent \n" + 
					"        FROM \n" + 
					"          rental \n" + 
					"        GROUP BY \n" + 
					"          bookstate_id\n" + 
					"      ) b ON a.bookstate_id = b.bookstate_id \n" + 
					"      AND a.rental_rent = b.rental_rent\n" + 
					"  ) r ON bs.bookstate_id = r.bookstate_id";
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
					"SELECT \n" + 
					"  bs.bookstate_id, \n" + 
					"  bi.bookinfo_isbn, \n" + 
					"  bi.bookinfo_name, \n" + 
					"  c.category_code, \n" + 
					"  c.category_name, \n" + 
					"  bi.bookinfo_author, \n" + 
					"  p.publisher_name, \n" + 
					"  bi.bookinfo_date, \n" + 
					"  bs.bookstate_add,\n" + 
					"  bs.bookstate_remove,\n" + 
					"  CASE WHEN r.rental IS FALSE THEN '2' ELSE '1' END AS rental_code,\n" + 
					"  CASE WHEN (r.rental IS NULL OR r.rental IS TRUE) AND delete_flag IS FALSE THEN '1' ELSE '2' END AS status_code\n" + 
					"FROM \n" + 
					"  bookinfo bi \n" + 
					"  JOIN bookstate bs ON bi.bookinfo_isbn = bs.bookinfo_isbn \n" + 
					"  JOIN category c ON bi.category_code = c.category_code \n" + 
					"  JOIN publisher p ON bi.publisher_code = p.publisher_code \n" + 
					"  LEFT JOIN (\n" + 
					"    SELECT \n" + 
					"      a.bookstate_id, \n" + 
					"      a.rental_rent, \n" + 
					"      a.rental_return, \n" + 
					"      CASE WHEN a.rental_rent IS NOT NULL \n" + 
					"      AND a.rental_return IS NULL THEN FALSE ELSE TRUE END AS rental \n" + 
					"    FROM \n" + 
					"      rental a \n" + 
					"      INNER JOIN (\n" + 
					"        SELECT \n" + 
					"          bookstate_id, \n" + 
					"          max(rental_rent) AS rental_rent \n" + 
					"        FROM \n" + 
					"          rental \n" + 
					"        GROUP BY \n" + 
					"          bookstate_id\n" + 
					"      ) b ON a.bookstate_id = b.bookstate_id \n" + 
					"      AND a.rental_rent = b.rental_rent\n" + 
					"  ) r ON bs.bookstate_id = r.bookstate_id";
			List<String> queryList = new ArrayList<String>();
			queryList.add("where");
			if(book.getId() != 0) {
				queryList.add("bs.bookstate_id=?");
				queryList.add("and");
			}
			if(book.getISBNCode() != null && book.getISBNCode().length() != 0) {
				queryList.add("bi.bookinfo_isbn like ?");
				queryList.add("and");
			}
			if(book.getName() != null && book.getName().length() != 0) {
				queryList.add("bi.bookinfo_name like ?");
				queryList.add("and");
			}
			if(book.getCategoryCode() != -1) {
				queryList.add("c.category_code=?");
				queryList.add("and");
			}
			if(book.getAuthor() != null && book.getAuthor().length() != 0) {
				queryList.add("bi.bookinfo_author like ?");
				queryList.add("and");
			}
			if(book.getPublisher() != null && book.getPublisher().length() != 0) {
				queryList.add("p.publisher_name like ?");
				queryList.add("and");
			}
			if(book.getFromPublishDate() != null) {
				queryList.add("bi.bookinfo_date >= ?");
				queryList.add("and");
			}
			if(book.getToPublishDate() != null) {
				queryList.add("bi.bookinfo_date <= ?");
				queryList.add("and");
			}
			if(book.getFromAddedDate() != null) {
				queryList.add("bs.bookstate_add >= ?");
				queryList.add("and");
			}
			if(book.getToAddedDate() != null) {
				queryList.add("bs.bookstate_add <= ?");
				queryList.add("and");
			}
			if(book.getFromRemovedDate() != null) {
				queryList.add("bs.bookstate_remove >= ?");
				queryList.add("and");
			}
			if(book.getToRemovedDate() != null) {
				queryList.add("bs.bookstate_remove<= ?");
				queryList.add("and");
			}
			if(book.getRentalCode() != null) {
				if(book.getRentalCode().equals("1")) {
					queryList.add("(r.rental IS NULL OR r.rental IS TRUE) AND delete_flag IS FALSE");
					queryList.add("and");
				}
				if(book.getRentalCode().equals("2")) {
					queryList.add("r.rental IS FALSE OR delete_flag IS TRUE");
					queryList.add("and");
				}
			}
			if(book.getStatusCode() != null) {
				if(book.getStatusCode().equals("1")) {
					queryList.add("delete_flag IS FALSE");
					queryList.add("and");
				}
				if(book.getStatusCode().equals("2")) {
					queryList.add("delete_flag IS TRUE");
					queryList.add("and");
				}
			}
			
			queryList.remove(queryList.size()-1);
			sql += " " + String.join(" ", queryList);
			System.out.println(sql);

			//create statement
			stmt = conn.prepareStatement(sql);
			int count = 1;
			if(book.getId() != 0) {
				stmt.setInt(count, book.getId());
				count++;
			}
			if(book.getISBNCode() != null && book.getISBNCode().length() != 0) {
				stmt.setString(count, "%"+book.getISBNCode()+"%");
				count++;
			}
			if(book.getName() != null && book.getName().length() != 0) {
				stmt.setString(count, "%"+book.getName()+"%");
				count++;
			}
			if(book.getCategoryCode() != -1) {
				stmt.setInt(count, book.getCategoryCode());
				count++;
			}
			if(book.getAuthor() != null && book.getAuthor().length() != 0) {
				stmt.setString(count, "%"+book.getAuthor()+"%");
				count++;
			}
			if(book.getPublisher() != null && book.getPublisher().length() != 0) {
				stmt.setString(count, "%"+book.getPublisher()+"%");
				count++;
			}
			if(book.getFromPublishDate() != null) {
				stmt.setDate(count, new java.sql.Date(book.getFromPublishDate().getTime()));
				count++;
			}
			if(book.getToPublishDate() != null) {
				stmt.setDate(count, new java.sql.Date(book.getToPublishDate().getTime()));
				count++;
			}
			if(book.getFromAddedDate() != null) {
				stmt.setDate(count, new java.sql.Date(book.getFromAddedDate().getTime()));
				count++;
			}
			if(book.getToAddedDate() != null) {
				stmt.setDate(count, new java.sql.Date(book.getToAddedDate().getTime()));
				count++;
			}
			if(book.getFromRemovedDate() != null) {
				stmt.setDate(count, new java.sql.Date(book.getFromRemovedDate().getTime()));
				count++;
			}
			if(book.getToRemovedDate() != null) {
				stmt.setDate(count, new java.sql.Date(book.getToRemovedDate().getTime()));
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
			String rentalCode = rs.getString("rental_code");
			String statusCode = rs.getString("status_code");

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
			book.setRentalCode(rentalCode);
			book.setStatusCode(statusCode);
			return book;

		} catch(Exception e) {
			e.printStackTrace();
			throw new DataAccessException("資料情報の読み込み中にエラーが発生しました");
		}
	}
}
