package com.shortthirdman.superfolio.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.shortthirdman.superfolio.common.SwaggerConstants.*;

@Operation(summary = "Create a new user profile fragment details", tags = {"UserProfile"})
@ApiResponses(value = {
        @ApiResponse(responseCode = RESPONSE_CODE_201, description = NEW_USER_FRAGMENT_ADDED, useReturnTypeSchema = true),
        @ApiResponse(responseCode = RESPONSE_CODE_500, description = INTERNAL_SERVER_ERROR, useReturnTypeSchema = true),
        @ApiResponse(responseCode = RESPONSE_CODE_400, description = BAD_REQUEST_ERROR, useReturnTypeSchema = true)
})
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SaveUserFragment {
}
