package com.dudadakung.returnbottle.dto.User.request;

public record UserSignUpRequestDto(
        String email,
        String password,
        String name,
        String phoneNumber
) {
}