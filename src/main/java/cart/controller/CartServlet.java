package cart.controller;
//購物車

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cart.model.dto.ProductDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/product/cart")
public class CartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("cart") == null) {
			//代表無資料 導到result頁面
			req.setAttribute("resultTitle", "購物車");
			req.setAttribute("resultMessage", "購物車無商品");
			req.getRequestDispatcher("/WEB-INF/view/cart/result.jsp").forward(req, resp);
			
		}
		req.getRequestDispatcher("/WEB-INF/view/cart/cart.jsp").forward(req, resp);
	}

}
