package cart.model.dto;

import java.util.Date;

import lombok.Data;
@Data

public class HistoryOederDTO {
	/*
	 SELECT 
    u.username user,
    p.product_name product,
	o.order_date otime
		FROM `user` u
		JOIN `order` o ON u.id = o.user_id
		JOIN order_item oi ON o.order_id = oi.order_id
		JOIN product p ON oi.product_id = p.product_id;
	 */
	
	private String user;
	private String product;
	private Date otime;
}
