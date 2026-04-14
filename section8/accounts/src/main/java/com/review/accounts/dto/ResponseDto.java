package com.review.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(
        name = "Schema for Response",
        description = "Schema for Response Data"
)
@AllArgsConstructor
public class ResponseDto {

    @Schema(
            description = "Status Code Response*9-"
    )
    private String statusCode;

    @Schema(
            description = "Response Message"
    )
    private String statusMsg;
}
