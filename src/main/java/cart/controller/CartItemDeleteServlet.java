package cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import cart.model.dto.OrderDTO;
import cart.model.dto.ProductDTO;
import cart.service.ProductService;
import cart.service.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//刪除暫時存放在session中 的集合
@WebServlet("/product/cart/item/delete")
public class CartItemDeleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int index =Integer.parseInt(req.getParameter("delete_index"));
		HttpSession session = req.getSession();
		if(session.getAttribute("cart") != null) {
			List<OrderDTO> cart = (List<OrderDTO>)session.getAttribute("cart");
			cart.remove(index);		
			//再次回傳 作為保險
			session.setAttribute("cart", cart);
		}
		
		//回到訂單主頁
		resp.sendRedirect("/JavaWebCart/product/cart");
		
	}
	
}
