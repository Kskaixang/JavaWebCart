package cart.service.impl;

import cart.dao.UserRegisterDAO;
import cart.dao.impl.UserRegisterDAOImpl;
import cart.model.entity.User;
import cart.service.UserRegisterService;
import cart.util.HashUtil;

public class UserRegisterServiceImpl implements UserRegisterService{

	//取得UserRegisterDAO物件實體
	private UserRegisterDAO userRegisterDAO = new UserRegisterDAOImpl();
	
	//取得鹽
	@Override
	public void addUser(String username, String password, String email) {
		try {
			String hashSalt = HashUtil.generateSalt();
			String hashPassword = HashUtil.hashPassword(password, hashSalt);
			
			//建立物件
			User user = new User();
			user.setUsername(username);
			//注意User物件中部可以存放明碼 購過哈希 與加鹽 (資安)
			user.setHashPassword(hashPassword);
			user.setHashSalt(hashSalt);
			user.setEmail(email);
			
			int rowcount = userRegisterDAO.addUser(user);
			if(rowcount < 1) {
				System.out.println("User新增失敗");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	@Override
	public void emailConfirmOk(String username) {
		if(username == null) {
			return;
		}
		userRegisterDAO.emailConfirmOk(username);
		
	}

}
