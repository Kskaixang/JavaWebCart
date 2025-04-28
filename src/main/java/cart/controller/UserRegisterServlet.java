package cart.controller;

import java.io.IOException;

import cart.service.EmailService;
import cart.service.UserRegisterService;
import cart.service.impl.UserRegisterServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user/register")
public class UserRegisterServlet extends HttpServlet{
	private UserRegisterService userRegisterService = new UserRegisterServiceImpl();
	private EmailService emailService = new EmailService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/cart/user_register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//將yser_register.jsp表單的東西拉下 新增User
		String username = req.getParameter("username");		
		String password = req.getParameter("username");
		String email = req.getParameter("username");
		userRegisterService.addUser(username, password, email);
		
		//發送送Email 
		String emailCpmformLink = "http://local:8080/JavaWebCart/email/confirm?username=" + username;
		emailService.sendEmail(email, emailCpmformLink);
		
		String resultTitle = "註冊結果";
		String resultMessage = "用戶 " + username + " 註冊成功 !";
		resultMessage += "<p />";
		resultMessage += "系統已送出驗證信件到 " + email + " 信箱, 請收信並點選[確認]連結";
		//準備 要給result.jsp 的資訊
		req.setAttribute("resultMessage", resultMessage);
		
		//創建完後 就直接回登入
		req.getRequestDispatcher("/WEB-INF/view/cart/user_login.jsp").forward(req, resp);;
		
	}
	
	
	

}
