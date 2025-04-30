package cart.model.dto;

import lombok.Data;

@Data
public class OrderItemDTO {
	private Integer itemId;
	private Integer orderId;
	private Integer productId;
	private Integer quantity;
	//邏輯上 應該要加 當時的訂單價格 但懶就沒弄

}
