package cart.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cart.dao.UserLoginDAO;
import cart.model.entity.User;

public class UserLoginDAOimpl extends BaseDao  implements UserLoginDAO{

	@Override
	public User findUserByName(String username) {
		String sql = "select id, username , hash_password, hash_salt, completed from user where username=?";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1,username);
			
			try (ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setHashPassword(rs.getString("hashPassword"));
					user.setHashSalt(rs.getString("hashSalt"));
					user.setEmail(rs.getString("email"));
					user.setCompleted(rs.getBoolean("completed"));
					
					return user;
				}
			} 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
