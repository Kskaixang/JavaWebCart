package cart.service;

import java.util.List;

import cart.model.dto.ProductDTO;
import cart.model.entity.Product;

public interface ProductService {
	List<ProductDTO> findAllProducts();
	//和ProductDAO最大差別 在這
	void add(String productName,String price,String qty,String productImageBase64); 
	
	void delete(Integer productId);
}
