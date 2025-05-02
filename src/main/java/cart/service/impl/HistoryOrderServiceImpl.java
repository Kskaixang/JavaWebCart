package cart.service.impl;

import java.util.List;

import cart.dao.HistoryListDAO;
import cart.dao.UserListDAO;
import cart.dao.impl.HistoryDAOImpl;
import cart.dao.impl.UserListDAOImpl;
import cart.model.dto.HistoryOederDTO;
import cart.model.dto.UserDTO;
import cart.model.entity.User;
import cart.service.HistoryOrderService;

public class HistoryOrderServiceImpl implements HistoryOrderService{
		private HistoryListDAO dao = new HistoryDAOImpl(); 

		@Override
		public List<HistoryOederDTO> findHistoruOderByUserName(String Username) {
			List<HistoryOederDTO> list = dao.findAllUsers().stream().filter(e -> e.getUser().equals(Username)).toList();
			System.out.println("看看Service" + list);
			return list;
		}
		
		

}
