package cart.service;

import java.util.List;

import cart.model.dto.HistoryOederDTO;
import cart.model.dto.UserDTO;

public interface HistoryOrderService {
	List<HistoryOederDTO> findHistoruOderByUserName(String Username);

}
