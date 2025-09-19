package com.example.todotest;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo,String> {
}
