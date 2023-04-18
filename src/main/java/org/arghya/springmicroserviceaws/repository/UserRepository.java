package org.arghya.springmicroserviceaws.repository;

import java.util.Optional;

import org.arghya.springmicroserviceaws.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "userRepository")
public interface UserRepository extends JpaRepository<User, String> {

	public Optional<User> findByName(String name);

}
