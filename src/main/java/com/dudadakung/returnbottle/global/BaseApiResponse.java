package com.dudadakung.returnbottle.global;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;


@Builder(access = AccessLevel.PRIVATE)
public class BaseApiResponse<T> {
    private int statusCode;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public static <T> BaseApiResponse<?> of(SuccessCode successCode, T data) {
        return BaseApiResponse.builder()
                .statusCode(successCode.getHttpStatus().value())
                .message(successCode.getMessage())
                .data(data)
                .build();
    }

    public static <T> BaseApiResponse<?> of(SuccessCode successCode) {
        return BaseApiResponse.builder()
                .statusCode(successCode.getHttpStatus().value())
                .message(successCode.getMessage())
                .build();
    }
}
