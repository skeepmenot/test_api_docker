package com.backend.todo.dto;

import com.backend.todo.validator.UUID;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TaskPatchRequest extends TaskRequest {

    @NotNull(message = "id is required")
    @UUID
    private String id;
}
