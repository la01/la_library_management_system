package la.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.later.LaterBook;
import la.bean.later.LaterRental;
import la.exception.DataAccessException;

public class PostgreSQLLaterDao extends DBManager{

	public List<LaterRental> select10_30dayUserList() throws DataAccessException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<LaterRental> list = new ArrayList<LaterRental>();
		try {
			String sql = "select bs.bookstate_id,bi.bookinfo_name,r.rental_rent,r.rental_limit, " +
					"rental_id,r.user_id,m.user_family_name,m.user_name,m.user_postal,m.user_address," +
					"m.user_tel,m.user_email from bookinfo bi join bookstate bs on bi.bookinfo_isbn =" +
					" bs.bookinfo_isbn join rental r on r.bookstate_id = bs.bookstate_id join member" +
					" m on r.user_id = m.user_id where rental_rent + 10 < CURRENT_DATE AND " +
					" rental_rent + 30 > CURRENT_DATE AND rental_return IS NULL";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			list = createLaterRentalListFromResultSet(rs);

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

	public List<LaterRental> select30dayUserList() throws DataAccessException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<LaterRental> list = new ArrayList<LaterRental>();
		try {
			String sql = "select bs.bookstate_id,bi.bookinfo_name,r.rental_rent,r.rental_limit, " +
					"rental_id,r.user_id,m.user_family_name,m.user_name,m.user_postal,m.user_address," +
					"m.user_tel,m.user_email from bookinfo bi join bookstate bs on bi.bookinfo_isbn =" +
					" bs.bookinfo_isbn join rental r on r.bookstate_id = bs.bookstate_id join member" +
					" m on r.user_id = m.user_id where rental_rent + 30 < CURRENT_DATE AND " +
					"rental_return IS NULL AND remind IS FALSE";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			list = createLaterRentalListFromResultSet(rs);

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

	public void delete(int rentalId) throws DataAccessException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "update rental set remind = true where rental_id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, rentalId);
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

	private List<LaterRental> createLaterRentalListFromResultSet(ResultSet rs) throws DataAccessException {
		try {
			List<LaterRental> list = new ArrayList<LaterRental>();
			while(rs.next()) {
				LaterBook lb = new LaterBook();
				lb.setBookId(rs.getInt("bookstate_id"));
				lb.setName(rs.getString("bookinfo_name"));
				lb.setRentalDate(rs.getDate("rental_rent"));
				lb.setReturnDate(rs.getDate("rental_limit"));

				int userId = rs.getInt("user_id");
				LaterRental lr = list.stream()
						.filter(rental -> rental.getId() == userId).findFirst()
						.orElse(null);
				if(lr == null) {
					lr = new LaterRental();
					lr.setRentalId(rs.getInt("rental_id"));
					lr.setId(userId);
					lr.setFamilyName(rs.getString("user_family_name"));
					lr.setName(rs.getString("user_name"));
					lr.setPostal(rs.getString("user_postal"));
					lr.setAddress(rs.getString("user_address"));
					lr.setTel(rs.getString("user_tel"));
					lr.setEmail(rs.getString("user_email"));
					lr.addBook(lb);
					list.add(lr);
				} else {
					lr.addBook(lb);
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("資料情報の読み込み中にエラーが発生しました");
		}
	}
}
