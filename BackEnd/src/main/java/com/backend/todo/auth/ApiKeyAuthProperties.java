package com.backend.todo.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "auth.http")
public class ApiKeyAuthProperties {

    private String headerName;
    private String authToken;
}
