package br.com.core.capy.config.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

    private String message;

    private int code;

    private String status;

    private LocalDateTime timestamp;

    private String description;

    private List<String> errors;

}
