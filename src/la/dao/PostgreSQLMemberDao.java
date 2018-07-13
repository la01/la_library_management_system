package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.member.Member;
import la.exception.DataAccessException;

public class PostgreSQLMemberDao extends DBManager {

	public List<Member> select() throws DataAccessException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		try {
			String sql = "select * from member";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				list.add(createMemberFromResultSet(rs));
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

	public List<Member> selectByCondition(Member member) throws DataAccessException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		try {
			// create query
			String sql = "select * from member";
			List<String> queryList = new ArrayList<String>();
			queryList.add("where");
			if (member.getId() != 0) {
				queryList.add("user_id=?");
				queryList.add("and");
			}
			if (member.getFamilyName() != null) {
				queryList.add("user_family_name like ?");
				queryList.add("and");
			}
			if (member.getName() != null) {
				queryList.add("user_name like ?");
				queryList.add("and");
			}
			if (member.getPostal() != null) {
				queryList.add("user_postal like ?");
				queryList.add("and");
			}
			if (member.getAddress() != null) {
				queryList.add("user_address like ?");
				queryList.add("and");
			}
			if (member.getTel() != null) {
				queryList.add("user_tel like ?");
				queryList.add("and");
			}
			if (member.getEmail() != null) {
				queryList.add("user_email like ?");
				queryList.add("and");
			}
			queryList.remove(queryList.size() - 1);
			sql += " " + String.join(" ", queryList);

			// create statement
			stmt = conn.prepareStatement(sql);
			int count = 1;
			if (member.getId() != 0) {
				stmt.setInt(count, member.getId());
				count++;
			}
			if (member.getFamilyName() != null) {
				stmt.setString(count, "%" + member.getFamilyName() + "%");
				count++;
			}
			if (member.getName() != null) {
				stmt.setString(count, "%" + member.getName() + "%");
				count++;
			}
			if (member.getPostal() != null) {
				stmt.setString(count, "%" + member.getPostal() + "%");
				count++;
			}
			if (member.getAddress() != null) {
				stmt.setString(count, "%" + member.getAddress() + "%");
				count++;
			}
			if (member.getTel() != null) {
				stmt.setString(count, "%" + member.getTel() + "%");
				count++;
			}
			if (member.getEmail() != null) {
				stmt.setString(count, "%" + member.getEmail() + "%");
				count++;
			}

			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(createMemberFromResultSet(rs));
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

	public int insert(Member member) throws DataAccessException {
		return 0;
	}

	public boolean update(Member member) throws DataAccessException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "UPDATE  member SET user_family_name = ?,  user_name = ?, user_postal = ?, user_address = ?, user_tel = ?,  user_email = ?, user_birthday = ? WHERE user_id =  ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getFamilyName());
			stmt.setString(2, member.getName());
			stmt.setString(3, member.getPostal());
			stmt.setString(4, member.getAddress());
			stmt.setString(5, member.getTel());
			stmt.setString(6, member.getEmail());
			stmt.setDate(7, member.getBirthday());
			stmt.setInt(8, member.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("会員情報の変更中にエラーが発生しました");
		} finally {
			try {
				close(stmt, conn);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataAccessException("SQLの終了中にエラーが発生しました");
			}
		}
		return false;
	}

	public boolean delete(int id) throws DataAccessException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		try {
			// 削除処理
			String sql = "UPDATE member SET delete_flag = true WHERE user_id = ?";
			System.out.println(sql);
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("会員情報の削除中にエラーが発生しました");
		} finally {
			try {
				close(stmt, conn);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataAccessException("SQLの終了中にエラーが発生しました");
			}
		}
		return false;
	}

	private Member createMemberFromResultSet(ResultSet rs) throws DataAccessException {
		try {
			int id = rs.getInt("user_id");
			String familyName = rs.getString("user_family_name");
			String name = rs.getString("user_name");
			String postal = rs.getString("user_postal");
			String address = rs.getString("user_address");
			String tel = rs.getString("user_tel");
			String email = rs.getString("user_email");
			Date date = rs.getDate("user_birthday");

			Member member = new Member(id, familyName, name, postal, address, tel, email, date);
			return member;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("会員情報の読み込み中にエラーが発生しました");
		}
	}

}
