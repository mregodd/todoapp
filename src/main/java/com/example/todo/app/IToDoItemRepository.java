package com.example.todo.app;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IToDoItemRepository extends JpaRepository<ToDoItem, Long> {
}
