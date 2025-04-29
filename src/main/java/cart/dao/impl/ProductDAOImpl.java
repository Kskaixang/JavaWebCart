package cart.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cart.dao.ProductDAO;
import cart.model.entity.Product;
import cart.model.entity.User;

public class ProductDAOImpl extends BaseDao implements ProductDAO{

	@Override
	public List<Product> findAllProducts() {
		List<Product> products = new ArrayList<>();
		String sql = "select product_id, product_name, price, qty, image_base64 from product";
		
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Product product = new Product();
				System.out.println(rs.getInt("product_id") + "看看有沒有東西");
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setPrice(rs.getInt("price"));
				product.setQty(rs.getInt("qty"));
				product.setImageBase64(rs.getString("image_base64"));
				// 注入到 users 集合中保存
				products.add(product);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ProductDAOimpl BUG");
		}
		
		
		return products;
	}

	@Override
	public void add(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer productId) {
		// TODO Auto-generated method stub
		
	}

}
