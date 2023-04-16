package com.example.springBootAssesment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class UserBooks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name="userId", referencedColumnName = "email")
	private Users userId;
	
	@OneToOne
	@JoinColumn(name="bookId", referencedColumnName = "bId")
	private Books bookId;
	
	private boolean readLater;
	
	private boolean liked;
	
}
