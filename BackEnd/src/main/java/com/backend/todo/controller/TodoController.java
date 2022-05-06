package com.backend.todo.controller;

import com.backend.todo.service.impl.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todolist")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class TodoController {

    @Autowired
    private TodoServiceImpl todoService;

}
