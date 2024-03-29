package com.example.todo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class ToDoItemController {

    @Autowired
    private ToDoItemService toDoItemService;


    @GetMapping("/getall")
    public List<ToDoItem> findAll() {
        return toDoItemService.findAll();
    }

    @PostMapping("/create")
    public ToDoItem create(@RequestBody ToDoItem todoItem){
        return toDoItemService.create(todoItem);
    }

    @PutMapping("/update")
    public ToDoItem update(@RequestBody ToDoItem toDoItem) {
        return toDoItemService.update(toDoItem);
    }

    @DeleteMapping("/delete")
    public void delete(Long id) {
        toDoItemService.delete(id);
    }
}
