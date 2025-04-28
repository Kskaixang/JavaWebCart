package cart.service.impl;

import java.util.List;

import cart.dao.UserListDAO;
import cart.dao.impl.UserListDAOimpl;
import cart.model.dto.UserDTO;
import cart.model.entity.User;
import cart.service.UserListService;

public class UserListServiceImpl implements UserListService{
	private UserListDAO dao = new UserListDAOimpl();

	@Override
	public List<UserDTO> findAllUser() {
		
		System.out.println("Service有收到資訊?" + dao.findAllUsers());
		// TODO Auto-generated method stub
		return dao.findAllUsers().stream().map(this::transferToDTO).toList();
	}
	
	private UserDTO transferToDTO(User user) {		
		return new UserDTO(user.getId(),user.getUsername(),user.getEmail(),user.getCompleted());
	}

}
