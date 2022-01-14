package io.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findOneByUsername(String username);
}
