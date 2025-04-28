package cart.controller;

import java.io.IOException;
import java.util.List;

import cart.model.dto.UserDTO;
import cart.service.UserListService;
import cart.service.impl.UserListServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user/list")
public class UserListServlet extends HttpServlet{
	UserListService userListService = new UserListServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UserDTO> userDTOs = userListService.findAllUser();
		System.out.println("let有收到資訊?" + userDTOs);
		req.setAttribute("userDTOs", userDTOs);
		
		req.getRequestDispatcher("/WEB-INF/view/cart/user_list.jsp").forward(req, resp);
		
	
		
		
	
	}
	

}
