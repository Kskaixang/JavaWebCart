package cart.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
	//對應entity 多自訂欄位
	private Integer productId;
	private String productName;
	private Integer price;
	private Integer qty;
	private String imageBase64;
	
	//自訂欄位total (困存成本 = price * qty)
	private Integer total;
}


/*
	product_id int auto_increment primary key comment '商品ID',
    product_name varchar(50) not null unique comment '商品名稱',
    price int not null comment '商品價格',
    qty int default 0 comment '商品庫存',
    image_base64 longtext comment '商品照片'
*/
