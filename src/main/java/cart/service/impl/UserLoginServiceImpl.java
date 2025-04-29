package cart.service.impl;

import cart.dao.UserLoginDAO;
import cart.dao.impl.UserLoginDAOImpl;
import cart.model.dto.UserDTO;
import cart.model.entity.User;
import cart.service.UserLoginService;
import cart.util.HashUtil;

public class UserLoginServiceImpl implements UserLoginService{
	private UserLoginDAO userLoginDAO = new UserLoginDAOImpl();
	@Override
	public UserDTO login(String username, String password, String authCode, String sessionAuthCode) {
		if(!authCode.equals(sessionAuthCode)) { 
			throw new RuntimeException("驗證碼不符");
		}
		User user = userLoginDAO.findUserByName(username);
		if(user == null) {
			throw new RuntimeException("查無使用者");
		}
		boolean completed = user.getCompleted();
		if(!completed) {
			throw new RuntimeException("信箱未驗證");
		}
		try {
			
			String hashPassword = HashUtil.hashPassword(password, user.getHashSalt());
			//資料庫比對
			boolean checkPassword = user.getHashPassword().equals(hashPassword);
			if(!checkPassword) {
				throw new RuntimeException("密碼錯誤");
			}
			//驗證成功
			//User 轉 UserDTO
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			userDTO.setEmail(user.getEmail());
			userDTO.setCompleted(user.getCompleted());
			// 6. 將 userDTO 回傳
			return userDTO;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		

	}

}
