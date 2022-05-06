package com.backend.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoListRequest {

    private String id;

    private String topic;

    private String description;

    private boolean isCheck;
}
