package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import donuts.SqlConnection;
import donuts.TryLogin;
import donuts.User;

public class UserDao extends SqlConnection {
	public User loginCheck(TryLogin login) {
		try (Connection con = this.getConnection()){
			String sql = "SELECT mail_address, "
					+ 			"password "
					+ 			" "
					+ 			" "
					+ 			" "
					+ 	 "FROM users "
					+ 	 "WHERE mail_address = ? AND password = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, login.getMailAddress());
			pstmt.setString(2, login.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				User user = new User(
													rs.getInt("userId"),
													rs.getString("mailAddress"),
													rs.getString("address"),
													rs.getString("userName"),
													rs.getString("zip"),
													rs.getDate("registerDateTime")
												);
				return user;
			}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return null;
	}
}
