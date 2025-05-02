package cart.controller;

import java.io.IOException;
import java.util.List;

import cart.model.dto.HistoryOederDTO;
import cart.model.dto.UserDTO;
import cart.service.HistoryOrderService;
import cart.service.impl.HistoryOrderServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/product/order/history")
public class HistoryServlet extends HttpServlet{
	HistoryOrderService service = new HistoryOrderServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserDTO userDTO = (UserDTO)session.getAttribute("userDTO");
		List<HistoryOederDTO> HistoryOederDTOs = service.findHistoruOderByUserName(userDTO.getUsername());
		System.out.println("看看Servlet" + HistoryOederDTOs);
		req.setAttribute("HistoryOederDTOs", HistoryOederDTOs);
		req.getRequestDispatcher("/WEB-INF/view/cart/history.jsp").forward(req, resp);
	}
	

}
