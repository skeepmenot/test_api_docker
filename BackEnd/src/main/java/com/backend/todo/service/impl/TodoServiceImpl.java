package com.backend.todo.service.impl;

import com.backend.todo.repository.TodoRepository;
import com.backend.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;
}
