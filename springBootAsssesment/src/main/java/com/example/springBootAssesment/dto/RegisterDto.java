package com.example.springBootAssesment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class RegisterDto {
	private String name;
	private String mobileNumber;
	private String email;
	private String password;

}
