package com.example.todo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoItemService {
    @Autowired
    private IToDoItemRepository toDoItemRepository;
    public List<ToDoItem> findAll() {
        return toDoItemRepository.findAll();
    }
    public ToDoItem findById(Long id) {
        return toDoItemRepository.findById(id).orElse(null);
    }
    public ToDoItem create(ToDoItem toDoItem) {
        ToDoItem newToDoItem = new ToDoItem();
        newToDoItem.setTitle(toDoItem.getTitle());
        newToDoItem.setDone(toDoItem.isDone());

        return toDoItemRepository.save(newToDoItem);
    }
    public ToDoItem update(ToDoItem toDoItem) {
        Long id = toDoItem.getId();
        ToDoItem existingToDoItem = toDoItemRepository.findById(id).orElse(null);
        if (existingToDoItem == null) {
            return null;
        }
        existingToDoItem.setTitle(toDoItem.getTitle());
        existingToDoItem.setDone(toDoItem.isDone());

        return toDoItemRepository.save(existingToDoItem);
    }

    public String delete(Long id) {
        ToDoItem existingToDoItem = toDoItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("id not exist"));
        this.toDoItemRepository.delete(existingToDoItem);

        return "ToDoItem deleted successfully!" + id;
    }
}

