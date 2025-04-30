package cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import cart.model.dto.ProductDTO;
import cart.service.ProductService;
import cart.service.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//將所訂購的商品 暫時存放在session中 (未下單)
@WebServlet("/product/order/add/cart")
public class OrderAddCartServlet extends HttpServlet{
	private ProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		List<ProductDTO> cart = null; //我的購物車 防底下的判斷式崩潰
		//確認session中 有無購物車資料  要問人**************
		if(session.getAttribute("cart") == null) {
			cart = new ArrayList<>();
			
		} else {
			//目前在使用中的購物車
			//但因為經過session 會是Object 需要強轉
			cart = (List<ProductDTO>) session.getAttribute("cart"); 
		}
		//------------------
		//得到要購買的商品Id
		Integer productId = Integer.parseInt(req.getParameter("productId"));
		//根據 product 取得 productDTO
		Optional<ProductDTO> optProductDTO = productService.findAllProducts()
				.stream()
				.filter(dto -> dto.getProductId().equals(productId))
				.findFirst();
		
		if(optProductDTO.isPresent()) {
			//於購物車中加入商品
			cart.add(optProductDTO.get());
			session.setAttribute("cart", cart);
		}
		//回到訂單主頁
		resp.sendRedirect("/JavaWebCart/product/order");
		System.out.println(session.getAttribute("cart"));
	}
	
}
