package com.dudadakung.returnbottle.dto.User.request;

public record UserLoginRequestDto(
        String email,
        String password
) {
}