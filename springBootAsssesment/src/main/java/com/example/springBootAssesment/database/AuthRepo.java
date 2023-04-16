package com.example.springBootAssesment.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.springBootAssesment.entity.Users;

public interface AuthRepo extends JpaRepository<Users, String> {

}