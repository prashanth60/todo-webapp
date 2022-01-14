package io.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    public Optional<List<Todo>> findAllByUserId(Long userId);
}
