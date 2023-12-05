package com.dudadakung.returnbottle.global;

import lombok.AccessLevel;
import lombok.Builder;


@Builder(access = AccessLevel.PRIVATE)
public class BaseApiResponse<T> {
    private int statusCode;
    private String message;
    private T data;

    public static <T> BaseApiResponse<?> of(SuccessCode successCode, T data) {
        return BaseApiResponse.builder()
                .statusCode(successCode.getHttpStatus().value())
                .message(successCode.getMessage())
                .data(data)
                .build();
    }
}
