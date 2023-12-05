package com.dudadakung.returnbottle.dto.User.response;

public record UserLoginResponseDto(
        String name,
        String uniqueId,
        int mileage
) {
}