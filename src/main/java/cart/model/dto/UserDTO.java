package cart.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
	private Integer id;
	private String username;
	private String email;
	private Boolean completed;
}
