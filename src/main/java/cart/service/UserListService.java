package cart.service;

import java.util.List;

import cart.model.dto.UserDTO;
import cart.model.entity.User;

public interface UserListService {
	List<UserDTO> findAllUser();

}
