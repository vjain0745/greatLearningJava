package com.example.springBootAssesment.dto;

import java.util.HashMap;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ResponseData {

	private String message;
	private HashMap<String, String> data;
	private HashMap<String, List<Object>> values;
}
