package com.todoapp.app.repositories;

import java.util.List;
import java.util.Optional;

import com.todoapp.app.entity.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    public Optional<List<Todo>> findAllByUserId(Long userId);
}
