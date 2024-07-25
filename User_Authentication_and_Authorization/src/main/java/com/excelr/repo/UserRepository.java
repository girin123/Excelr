package com.excelr.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.excelr.Entity.User;
@Repository
@EnableJpaRepositories

public interface UserRepository<email> extends JpaRepository<email, String> {
	Optional<User> findByEmail(String email);

}
