package com.shortthirdman.superfolio.swagger;

import com.shortthirdman.superfolio.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.shortthirdman.superfolio.common.SwaggerConstants.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Operation(summary = "Retrieves user profile fragments", tags = {"UserProfile"})
@ApiResponses(value = {
        @ApiResponse(responseCode = RESPONSE_CODE_200, description = USER_FRAGMENTS_RETRIEVAL, content = {
                @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = User.class))
        }),
        @ApiResponse(responseCode = RESPONSE_CODE_500, description = INTERNAL_SERVER_ERROR, content = {
                @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = User.class))
        }),
        @ApiResponse(responseCode = RESPONSE_CODE_400, description = RESOURCE_NOT_FOUND_ERROR, content = {
                @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = User.class))
        })
})
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GetUserProfile {
}
