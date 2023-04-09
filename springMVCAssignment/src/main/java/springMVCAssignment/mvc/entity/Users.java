package springMVCAssignment.mvc.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Users {

	@Id
	private String email;
	private String name;
	private String mobileNumber;
	private String password;
	
}
