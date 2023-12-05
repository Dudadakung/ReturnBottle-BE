package com.dudadakung.returnbottle.global;

import lombok.AccessLevel;
import lombok.Builder;


@Builder(access = AccessLevel.PRIVATE)
public class BaseApiResponse<T> {
    private int statusCode;
    private String message;
    private T data;
}
