package com.dudadakung.returnbottle.dto.User.response;

public record MyPageResponseDto(
        String name,
        String email,
        int numOfBottles,
        int mileage,
        int itemNum

) {
}
