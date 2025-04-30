package cart.service.impl;

import java.util.ArrayList;
import java.util.List;

import cart.dao.OrderDAO;
import cart.dao.impl.OrderDAOImpl;
import cart.model.dto.OrderDTO;
import cart.model.dto.OrderItemDTO;
import cart.model.dto.ProductDTO;
import cart.model.entity.Order;
import cart.model.entity.OrderItem;
import cart.service.OrderService;

public class OrderServiceImpl implements OrderService{
	private OrderDAO orderDAO = new OrderDAOImpl();
	@Override
	public void addOrder(Integer userId, List<ProductDTO> cart) {
		Integer quantity = 1; 
		//回家作業~ 如何讓數量可以調整  有時間可以在加 歷史查詢
		/*
		 商品統計 (Homework)
			-- 商品統計 每一件商品賣出數量
				String sql = "SELECT product_id, sum(quantity) as sum
				FROM cart.order_item
				group by product_id"

		 */
		
		
		
		//新增訂單主檔 後 可以得到orderId
		Integer orderId = orderDAO.addOrder(userId);
		//逐一新增訂單明細   簡言之一起新增
		for(ProductDTO productDTO :  cart) {
			orderDAO.addOrderItem(orderId, productDTO.getProductId(), quantity );
		}
		
	}

	@Override
	public List<OrderDTO> findAllOrdersByUserId(Integer userId) {
		List<OrderDTO> orderDTOs =new ArrayList<>();
		//取的該使用者的訂單主檔 資訊
		List<Order> orders = orderDAO.findAllOrdersByUserId(userId);
		for(Order order :  orders) {
			//mapping
			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setOrderId(order.getOrderId());
			orderDTO.setUserId(order.getUserId());
			orderDTO.setOrderDate(order.getOrderDate());
			
			//明細
			for(OrderItem item : orderDAO.findAllOrderItemsByOrderId(order.getOrderId())) {
				//item 轉 DTO
				OrderItemDTO itemDTO =new OrderItemDTO();
				item.setItemId(item.getItemId());
				item.setOrderId(item.getOrderId());
				item.setProductId(item.getProductId());
				item.setQuantity(item.getQuantity());
				//注入
				//private List<OrderItemDTO> items = new ArrayList<>();
				orderDTO.getItems().add(itemDTO);
			}
			
		}
		
		
		return orderDTOs;
	}

}
