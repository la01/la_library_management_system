package la.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import la.exception.DataAccessException;

public class PostgreSQLRentalDao extends DBManager{

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

	public int insert(int memberId, int bookId) throws DataAccessException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int rentalId;
		try {
			String sql = "insert into rental(bookstate_id, user_id, rental_rent, rental_limit) select ?, ?, current_date, current_date + checknewbook(b.bookinfo_date) from (select bi.bookinfo_date from bookstate bs join bookinfo bi on bs.bookinfo_isbn = bi.bookinfo_isbn where bs.bookstate_id = ?) b;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, bookId);
			stmt.setInt(2, memberId);
			stmt.setInt(3, bookId);
			stmt.executeUpdate();
			stmt.close();
			sql = "select max(rental_id) from rental;";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			rentalId = rs.getInt(1);
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
		return rentalId;
	}
}
