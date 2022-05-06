package com.backend.todo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TaskRequest {

    @NotBlank(message = "topic is required")
    private String topic;

    @NotNull(message = "description is required but can empty")
    private String description;

    private boolean check;
}
