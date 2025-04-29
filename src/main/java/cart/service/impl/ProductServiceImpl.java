package cart.service.impl;

import java.util.List;

import cart.dao.ProductDAO;
import cart.dao.impl.ProductDAOImpl;
import cart.model.dto.ProductDTO;
import cart.model.entity.Product;
import cart.service.ProductService;

public class ProductServiceImpl implements ProductService{
	private ProductDAO dao = new ProductDAOImpl(); 
	@Override
	public List<ProductDTO> findAllProducts() {
		// TODO Auto-generated method stub
		return dao.findAllProducts().stream().map(this::transferToDTO).toList();
	}

	@Override
	public void add(String productName, String price, String qty, String productImageBase64) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer productId) {
		// TODO Auto-generated method stub
		
	}
	
	private ProductDTO transferToDTO(Product product) {
		int total = product.getPrice() * product.getQty();
		return new ProductDTO(
				product.getProductId(), 
				product.getProductName(), 
				product.getPrice(), 
				product.getQty(), 
				product.getImageBase64(), 
				total);
		
		
	}

}
