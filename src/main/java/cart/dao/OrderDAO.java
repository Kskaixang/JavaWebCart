package cart.dao;

import java.util.List;

import cart.model.entity.Order;
import cart.model.entity.OrderItem;

public interface OrderDAO {
	//建立訂單 主檔案 master 回傳訂單編號
	//有一些技巧
	Integer addOrder(Integer userId);
	//建立訂單項目(訂單明細檔)
	void addOrderItem(Integer orderId,Integer productId, Integer quantity);
	//查詢使用者的訂單
	List<Order> findAllOrdersByUserId(Integer userId);
	//查詢訂單的明細
	List<OrderItem> findAllOrderItemsByOrderId(Integer userId);
	
}
