package com.backend.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoListPatchRequest extends TodoListRequest {

    private String id;
}
