package springMVCAssignment.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class LoginDto {

	private String name;
	private String mobileNumber;
	private String email;
	private String password;
}
