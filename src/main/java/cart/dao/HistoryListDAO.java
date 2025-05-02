package cart.dao;

import java.util.List;

import cart.model.dto.HistoryOederDTO;


public interface HistoryListDAO {
	//查詢所有使用者
	List<HistoryOederDTO> findAllUsers();
}
