package cart.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import cart.dao.UserListDAO;
import cart.model.entity.User;

public class UserListDAOimpl extends BaseDao implements UserListDAO{

	@Override
	public List<User> findAllUsers() {
		List<User> users = new ArrayList<>();
		
		
		String sql = "select id, username, hash_password, hash_salt, email, completed from user";
		try (Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql) ){
				if(rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setHashPassword(rs.getString("hashPassword"));
					user.setHashSalt(rs.getString("hashSalt"));
					user.setEmail(rs.getString("email"));
					user.setCompleted(rs.getBoolean("completed"));
					users.add(user);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("DAO有收到資訊?" + users);
		return users;
	}

	

}
