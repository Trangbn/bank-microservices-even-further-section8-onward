package com.review.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(
        name = "Schema for Error response dto.",
        description = "Schema for error response dto"

)
public class ErrorResponseDto {

    @Schema(
            description = "Path of the API"
    )
    private String apiPath;

    @Schema(
            description = "Error Code"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Error Message"
    )
    private String errorMessage;

    @Schema(
            description = "Time that error happens"
    )
    private LocalDateTime errorTime;
}
