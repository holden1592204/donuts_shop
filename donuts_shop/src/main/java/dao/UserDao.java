package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import donuts.SqlConnection;
import donuts.TryLogin;
import donuts.User;

public class UserDao extends SqlConnection {
	public User loginCheck(TryLogin login) {
		try (Connection con = this.getConnection()){
			String sql = "SELECT user_id, "
					+ 			"mail_address "
					+ 			"user_name"
					+ 			"address"
					+ 			"zip"
					+           "password"
					+			"register_dateTime"
					+			"is_admin"
					+ 	 "FROM users "
					+ 	 "WHERE mail_address = ? AND password = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, login.getMailAddress());
			pstmt.setString(2, login.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				User user = new User(
													rs.getInt("user_id"),
													rs.getString("mail_address"),
													rs.getString("user_name"),
													rs.getString("address"),
													rs.getString("zip"),
													rs.getBytes("password"),
													rs.getString("register_dateTime"),
													rs.getBoolean("is_admin")
												);
				return user;
			}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return null;
	}
	
	public boolean createUser(User u) {
		try (Connection con = this.getConnection()) {
			String sql = "INSERT INTO users VALUES(?, ?, ?, ?, ?, ?, ?)";
			
			Date dateTime = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u.getMailAddress());
			pstmt.setString(2, u.getUserName());
			pstmt.setString(3, u.getAddress());
			pstmt.setString(4, u.getZip());
			pstmt.setBytes(5, u.getPassword());
			pstmt.setString(6, sdf.format(dateTime));
			pstmt.setBoolean(7, u.getIsAdmin());
			
			
		} catch (SQLException e) {
			
		}
		return true;
	}
}
