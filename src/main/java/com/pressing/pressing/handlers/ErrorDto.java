package com.pressing.pressing.handlers;

import com.pressing.pressing.exception.ErrorCode;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto {
    private Integer httpcode;
    private ErrorCode code;
    private String message;
    private List<String> errors = new ArrayList<>();
}
