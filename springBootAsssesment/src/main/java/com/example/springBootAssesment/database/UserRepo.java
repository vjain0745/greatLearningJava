package com.example.springBootAssesment.database;

import org.springframework.data.repository.CrudRepository;

import com.example.springBootAssesment.entity.Users;

public interface UserRepo extends CrudRepository<Users, String>{

}
