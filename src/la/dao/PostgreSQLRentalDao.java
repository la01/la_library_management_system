package la.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import la.bean.rental.Rental;
import java.util.Date;
import java.util.List;

import la.bean.rental.RentalHistory;
import la.exception.DataAccessException;

public class PostgreSQLRentalDao extends DBManager {

	public Rental select(int memberId) throws DataAccessException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		Rental rental;
		try {
			String sql = "select bookstate_id from rental where user_id = ? and rental_return is null;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, memberId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getInt(1));
			}
			rental = new Rental(memberId, list);
		} catch (Exception e) {
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

		return rental;
	}
	public List<RentalHistory> selectByCondition(RentalHistory history) throws DataAccessException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<RentalHistory> list = new ArrayList<RentalHistory>();

		try {
			String sql = "SELECT rental_id,r.bookstate_id,r.user_id,bookinfo_name,\n" + 
					"r.rental_rent,r.rental_limit,r.rental_return FROM rental r \n" + 
					"JOIN bookstate bs ON r.bookstate_id = bs.bookstate_id \n" + 
					"JOIN bookinfo bi ON bs.bookinfo_isbn = bi.bookinfo_isbn";
			List<String> queryList = new ArrayList<String>();
			queryList.add("where");
			if(history.getMemberId() != 0) {
				queryList.add("r.user_id = ?");
				queryList.add("and");
			}
			if(history.getBookId() != 0) {
				queryList.add("r.bookstate_id = ?");
				queryList.add("and");
			}
			if(history.getIsbn() != null && history.getIsbn().length() != 0) {
				queryList.add("bi.bookinfo_isbn like ?");
				queryList.add("and");
			}
			if(history.getName() != null && history.getName().length() != 0) {
				queryList.add("bi.bookinfo_name like ?");
				queryList.add("and");
			}
			if(history.getFromDay() != null) {
				queryList.add("r.rental_rent >= ?");
				queryList.add("and");
			}
			if(history.getToDay() != null) {
				queryList.add("r.rental_rent <= ?");
				queryList.add("and");
			}
			if(history.isLater()) {
				queryList.add("(CURRENT_DATE > rental_limit AND rental_return IS NULL)");
				queryList.add("and");
			}
			if(history.isNoReturn()) {
				queryList.add("rental_return IS NULL");
				queryList.add("and");
			}
			queryList.remove(queryList.size() - 1);
			sql += " " + String.join(" ", queryList);
			System.out.println("sql:"+sql);

			// create statement
			stmt = conn.prepareStatement(sql);
			int count = 1;
			if(history.getMemberId() != 0) {
				stmt.setInt(count, history.getMemberId());
				count++;
			}
			if(history.getBookId() != 0) {
				stmt.setInt(count, history.getBookId());
				count++;
			}
			if(history.getIsbn() != null && history.getIsbn().length() != 0) {
				stmt.setString(count, "%" + history.getIsbn() + "%");
				count++;
			}
			if(history.getName() != null && history.getName().length() != 0) {
				stmt.setString(count, "%" + history.getName() + "%");
				count++;
			}
			if(history.getFromDay() != null) {
				stmt.setDate(count, new java.sql.Date(history.getFromDay().getTime()));
				count++;
			}
			if(history.getToDay() != null) {
				stmt.setDate(count, new java.sql.Date(history.getToDay().getTime()));
				count++;
			}

			rs = stmt.executeQuery();
			while(rs.next()) {
				RentalHistory rh = new RentalHistory();
				rh.setRentalId(rs.getInt("rental_id"));
				rh.setBookId(rs.getInt("bookstate_id"));
				rh.setMemberId(rs.getInt("user_id"));
				rh.setName(rs.getString("bookinfo_name"));
				rh.setRentalDate(rs.getDate("rental_rent"));
				rh.setLimitDate(rs.getDate("rental_limit"));
				rh.setReturnDate(rs.getDate("rental_return"));
				rh.setLater(new Date().getTime() > rh.getLimitDate().getTime() ? true : false);
				rh.setNoReturn(rh.getReturnDate() == null ? true : false);
				list.add(rh);
			}

		} catch (Exception e) {
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

	public int countRentalBookNum(int memberId) throws DataAccessException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int rentalBookNum;
		try {
			String sql = "select count(*) from rental where user_id = ? and rental_return is null;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, memberId);
			rs = stmt.executeQuery();
			rs.next();
			rentalBookNum = rs.getInt(1);
		} catch (Exception e) {
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
		return rentalBookNum;
	}

	public int countDelayedRentalBookNum(int memberId) throws DataAccessException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int delayedRentalBookNum;
		try {
			String sql = "select count(*) from rental where user_id = ? and rental_limit < current_date and rental_return is null;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, memberId);
			rs = stmt.executeQuery();
			rs.next();
			delayedRentalBookNum = rs.getInt(1);
		} catch (Exception e) {
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
		return delayedRentalBookNum;
	}

	public void insert(int memberId, int bookId) throws DataAccessException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "insert into rental(bookstate_id, user_id, rental_rent, rental_limit) select ?, ?, current_date, current_date + checknewbook(b.bookinfo_date) from (select bi.bookinfo_date from bookstate bs join bookinfo bi on bs.bookinfo_isbn = bi.bookinfo_isbn where bs.bookstate_id = ?) b;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, bookId);
			stmt.setInt(2, memberId);
			stmt.setInt(3, bookId);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("SQLの実行中にエラーが発生しました");
		} finally {
			try {
				close(stmt, conn);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataAccessException("SQLの終了中にエラーが発生しました");
			}
		}
	}

	public void delete(int memberId, int bookId) throws DataAccessException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "update rental set rental_return = current_date where user_id = ? and bookstate_id = ? and rental_return is null ;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, memberId);
			stmt.setInt(2, bookId);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("SQLの実行中にエラーが発生しました");
		} finally {
			try {
				close(stmt, conn);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataAccessException("SQLの終了中にエラーが発生しました");
			}
		}
	}
}
