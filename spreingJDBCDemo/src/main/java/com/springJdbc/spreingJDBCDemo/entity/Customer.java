package com.springJdbc.spreingJDBCDemo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Customer {

	private String email;
	private String custName;
	private String city;
	private String phone;
	private String password;


}
