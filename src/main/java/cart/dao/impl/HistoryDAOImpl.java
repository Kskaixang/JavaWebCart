package cart.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cart.dao.HistoryListDAO;
import cart.dao.UserListDAO;
import cart.model.dto.HistoryOederDTO;
import cart.model.entity.User;

public class HistoryDAOImpl extends BaseDao implements HistoryListDAO {
	
	// 查詢所有使用者
	@Override
	public List<HistoryOederDTO> findAllUsers() {
		List<HistoryOederDTO> orders = new ArrayList<>(); // 用來存放所有使用者的容器
		
		String sql = "SELECT "
			    + "u.username user, "
			    + "p.product_name product, "
			    + "o.order_date otime "
			    + "FROM `user` u "
			    + "JOIN `order` o ON u.id = o.user_id "
			    + "JOIN order_item oi ON o.order_id = oi.order_id "
			    + "JOIN product p ON oi.product_id = p.product_id;";

		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)) {
			// rs 裡面存放的是資料表的內容
			// 利用 rs.next() 逐筆取出資料
			while (rs.next()) {
				// 建立 User 物件來存放資料列每一個欄位的內容
				HistoryOederDTO oeder = new HistoryOederDTO();
				oeder.setUser(rs.getString("user"));
				oeder.setProduct(rs.getString("product"));
				oeder.setOtime(rs.getTimestamp("otime")); // 會包含日期 + 時間

				// 注入到 users 集合中保存
				orders.add(oeder);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("HistoryDAOImpl BUG");
		}
		System.out.println("看看有沒有收到" + orders);
		return orders;
	}

}