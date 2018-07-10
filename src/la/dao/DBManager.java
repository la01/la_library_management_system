package la.dao;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import la.exception.DataAccessException;

public class DBManager {

	public Connection getConnection() throws DataAccessException {
		Connection conn = null;
		try {
			InputStream in = getClass().getResourceAsStream("/db.properties");
			Properties prop = new Properties();
			prop.load(in);

			Class.forName(prop.getProperty("DRIVER"));
			conn = DriverManager.getConnection(
					prop.getProperty("URL"), prop.getProperty("USER"), prop.getProperty("PASSWORD"));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new DataAccessException("DB設定ファイルの読み込みに失敗しました");
		} catch(Exception e) {
			e.printStackTrace();
			throw new DataAccessException("DBへの接続に失敗しました");
		}
		return conn;
	}

	public void close(Connection conn) throws SQLException {
		if(conn != null) {
			conn.close();
			conn = null;
		}
	}

	public void close(Statement stmt) throws SQLException {
		if(stmt != null) {
			stmt.close();
			stmt = null;
		}
	}

	public void close(ResultSet rs) throws SQLException {
		if(rs != null) {
			rs.close();
			rs = null;
		}
	}

	public void close(Statement stmt, Connection conn) throws SQLException {
		if(stmt != null) {
			stmt.close();
			stmt = null;
		}
		if(conn != null) {
			conn.close();
			conn = null;
		}
	}

	public void close(ResultSet rs, Statement stmt, Connection conn) throws SQLException {
		if(rs != null) {
			rs.close();
			rs = null;
		}
		if(stmt != null) {
			stmt.close();
			stmt = null;
		}
		if(conn != null) {
			conn.close();
			conn = null;
		}
	}
}
