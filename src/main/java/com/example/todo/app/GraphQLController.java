package com.example.todo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLController {

    @Autowired
    private ToDoItemService toDoItemService;

    @QueryMapping
    List<ToDoItem> findAll() {
        return toDoItemService.findAll();
    }

    @MutationMapping
    ToDoItem create(@Argument String title,@Argument boolean done) {
        return toDoItemService.create(new ToDoItem(title,done));
    }

    @MutationMapping
    ToDoItem update(@Argument Long id, @Argument String title, @Argument boolean done) {
        return toDoItemService.update(new ToDoItem(id, title, done));
    }

    @MutationMapping
    String delete (@Argument Long id) {
        return toDoItemService.delete(id);
    }

}