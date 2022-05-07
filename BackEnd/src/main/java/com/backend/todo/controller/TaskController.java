package com.backend.todo.controller;

import com.backend.todo.constant.ErrorMessages;
import com.backend.todo.dto.TaskRequest;
import com.backend.todo.exception.NotFoundException;
import com.backend.todo.service.impl.TaskServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/task")
@Tag(name = "Task Controller")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class TaskController {

    @Autowired
    private TaskServiceImpl todoService;

    @Operation(summary = "Get all Task")
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Object getAllTask() {
        return todoService.getAllTask();
    }

    @Operation(summary = "Get Task by id")
    @Parameters(value = {
            @Parameter(name = "id", description = "Task UUID", in = ParameterIn.PATH)
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object getTaskById(@PathVariable String id) {
        var res = todoService.getTaskById(id);
        if (res.isPresent()) {
            return res.get();
        } else {
            throw new NotFoundException(ErrorMessages.NOT_FOUND);
        }
    }

    @Operation(summary = "Create Task")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Object createTodoList(@Validated @RequestBody TaskRequest request) {
        return todoService.createTask(request);
    }

    @Operation(summary = "Update Task by id")
    @Parameters(value = {
            @Parameter(name = "id", description = "Task UUID", in = ParameterIn.PATH)
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object updateTodoListById(@PathVariable String id,@Validated @RequestBody TaskRequest request) {
        return todoService.updateTask(id,request);
    }

    @Operation(summary = "Delete Task by id")
    @Parameters(value = {
            @Parameter(name = "id", description = "Task UUID", in = ParameterIn.PATH)
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTodoListById(@PathVariable String id) {
        todoService.deleteTaskById(id);
    }

}
