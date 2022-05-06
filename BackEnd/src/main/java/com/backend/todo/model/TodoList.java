package com.backend.todo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "todolist")
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "topic")
    private String topic;

    @Column(name = "description")
    private String description;

    @Column(name = "is_check")
    private boolean isCheck;

    @Column(name = "created_timestamp")
    private ZonedDateTime createTimestamp;

    @Column(name = "modified_timestamp")
    private ZonedDateTime modifiedTimestamp;
}
