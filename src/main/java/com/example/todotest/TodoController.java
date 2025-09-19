package com.example.todotest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @PostMapping("/add")
    public String addTodo(@RequestParam String id,
                          @RequestParam String name,
                          @RequestParam boolean completed){
        Todo todo = new Todo();
        todo.setId(id);
        todo.setName(name);
        todo.setCompleted(completed);
        todoRepository.save(todo);
        return "saved";
    }

    @PostMapping("update")
    public String updateTodo(@RequestParam String id, @RequestParam String name, @RequestParam Boolean completed) {
        Todo oldTodo = todoRepository.findById(id).get();
        oldTodo.setName(name);
        oldTodo.setCompleted(completed);
        todoRepository.save(oldTodo);
        return "updated";
    }

    @GetMapping("delete")
    public String deleteTodo(@RequestParam String id) {
        todoRepository.deleteById(id);
        return "deleted";
    }

    @GetMapping("all")
    public Iterable<Todo> getAllTodos(){
        return todoRepository.findAll();
    }
}
