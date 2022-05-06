package com.backend.todo.service;

import com.backend.todo.dto.TaskRequest;
import com.backend.todo.model.TaskModel;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<TaskModel> getAllTask();

    Optional<TaskModel> getTaskById(String id);

    TaskModel createTask(TaskRequest request);

    TaskModel updateTask(String id, TaskRequest request);

    void deleteTaskById(String id);
}
