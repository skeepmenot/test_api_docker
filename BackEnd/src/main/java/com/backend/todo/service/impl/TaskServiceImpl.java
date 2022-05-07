package com.backend.todo.service.impl;

import com.backend.todo.constant.ErrorMessages;
import com.backend.todo.dto.TaskRequest;
import com.backend.todo.exception.InvalidUUIDException;
import com.backend.todo.exception.NotFoundException;
import com.backend.todo.model.TaskModel;
import com.backend.todo.repository.TaskRepository;
import com.backend.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskModel> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<TaskModel> getTaskById(String id) {
        try {
            return taskRepository.findById(UUID.fromString(id));
        }catch (IllegalArgumentException e) {
            throw new InvalidUUIDException(ErrorMessages.INVALID_KEY);
        }
    }

    @Override
    public TaskModel createTask(TaskRequest request) {
        TaskModel task = new TaskModel();
        task.setTopic(request.getTopic());
        task.setDescription(request.getDescription());
        task.setCheck(request.isCheck());
        task.setCreateTimestamp(ZonedDateTime.now());
        task.setModifiedTimestamp(ZonedDateTime.now());
        taskRepository.save(task);
        return task;
    }

    @Override
    public TaskModel updateTask(String id, TaskRequest request) {
        try {
            Optional<TaskModel> opt = taskRepository.findById(UUID.fromString(id));
            if (opt.isPresent()) {
                TaskModel task = opt.get();
                task.setTopic(request.getTopic());
                task.setDescription(request.getDescription());
                task.setCheck(request.isCheck());
                task.setModifiedTimestamp(ZonedDateTime.now());
                taskRepository.save(task);
                return task;
            } else {
                throw new NotFoundException(ErrorMessages.NOT_FOUND);
            }
        } catch (IllegalArgumentException e) {
            throw new InvalidUUIDException(ErrorMessages.INVALID_KEY);
        }
    }

    @Override
    public void deleteTaskById(String id) {
        try {
            taskRepository.deleteById(UUID.fromString(id));
        } catch (IllegalArgumentException e) {
            throw new InvalidUUIDException(ErrorMessages.INVALID_KEY);
        }
    }
}
