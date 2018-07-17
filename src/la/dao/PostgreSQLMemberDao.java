package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import la.bean.member.Member;
import la.exception.DataAccessException;

public class PostgreSQLMemberDao extends DBManager {

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
			if (member.getFamilyName() != null && member.getFamilyName().length() != 0) {
				queryList.add("user_family_name like ?");
				queryList.add("and");
			}
			if (member.getName() != null && member.getName().length() != 0) {
				queryList.add("user_name like ?");
				queryList.add("and");
			}
			if (member.getPostal() != null && member.getPostal().length() != 0) {
				queryList.add("user_postal like ?");
				queryList.add("and");
			}
			if (member.getAddress() != null && member.getAddress().length() != 0) {
				queryList.add("user_address like ?");
				queryList.add("and");
			}
			if (member.getTel() != null && member.getTel().length() != 0) {
				queryList.add("user_tel like ?");
				queryList.add("and");
			}
			if (member.getEmail() != null && member.getEmail().length() != 0) {
				queryList.add("user_email like ?");
				queryList.add("and");
			}
			if (member.getStateCode() != null && member.getStateCode().length() != 0) {
				if(member.getStateCode().equals("1")) {
					queryList.add("delete_flag IS TRUE");
					queryList.add("and");
				} else if(member.getStateCode().equals("2")) {
					queryList.add("delete_flag IS FALSE");
					queryList.add("and");
				}
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
			if (member.getFamilyName() != null && member.getFamilyName().length() != 0) {
				stmt.setString(count, "%" + member.getFamilyName() + "%");
				count++;
			}
			if (member.getName() != null && member.getName().length() != 0) {
				stmt.setString(count, "%" + member.getName() + "%");
				count++;
			}
			if (member.getPostal() != null && member.getPostal().length() != 0) {
				stmt.setString(count, "%" + member.getPostal() + "%");
				count++;
			}
			if (member.getAddress() != null && member.getAddress().length() != 0) {
				stmt.setString(count, "%" + member.getAddress() + "%");
				count++;
			}
			if (member.getTel() != null && member.getTel().length() != 0) {
				stmt.setString(count, "%" + member.getTel() + "%");
				count++;
			}
			if (member.getEmail() != null && member.getEmail().length() != 0) {
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
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			String sql = "INSERT INTO member(user_family_name, user_name, user_postal, user_address, user_tel, user_email, user_birthday, user_password, user_role, user_join, delete_flag) VALUES(?, ?, ?, ?, ?, ?, ?, ?, '1', current_date, false);";

			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, member.getFamilyName());
			stmt.setString(2, member.getName());
			stmt.setString(3, member.getPostal());
			stmt.setString(4, member.getAddress());
			stmt.setString(5, member.getTel());
			stmt.setString(6, member.getEmail());
			stmt.setDate(7, new java.sql.Date(member.getBirthday().getTime()));
			stmt.setString(8, member.getPassword());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				result = Integer.valueOf(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("会員情報の登録中にエラーが発生しました");
		} finally {
			try {
				close(stmt, conn);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataAccessException("SQLの終了中にエラーが発生しました");
			}
		}
		return result;
	}

	public boolean update(Member member) throws DataAccessException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		boolean result = false;
		try {
			String sql = "UPDATE member SET user_family_name = ?,  user_name = ?, user_postal = ?, user_address = ?, user_tel = ?,  user_email = ?, user_birthday = ? WHERE user_id =  ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getFamilyName());
			stmt.setString(2, member.getName());
			stmt.setString(3, member.getPostal());
			stmt.setString(4, member.getAddress());
			stmt.setString(5, member.getTel());
			stmt.setString(6, member.getEmail());
			stmt.setDate(7, new java.sql.Date(member.getBirthday().getTime()));
			stmt.setInt(8, member.getId());
			stmt.executeUpdate();
			result = true;
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
		return result;
	}

	public boolean delete(int id) throws DataAccessException {
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		boolean result = false;
		try {
			// 削除処理
			String sql = "UPDATE member SET delete_flag = true, user_leave = current_date WHERE user_id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			result = true;
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
		return result;
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
			boolean deleteFlag = rs.getBoolean("delete_flag");

			Member member = new Member();
			member.setId(id);
			member.setFamilyName(familyName);
			member.setName(name);
			member.setPostal(postal);
			member.setAddress(address);
			member.setTel(tel);
			member.setEmail(email);
			member.setBirthday(date);
			member.setDeleteFlag(deleteFlag);

			return member;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("会員情報の読み込み中にエラーが発生しました");
		}
	}

}
