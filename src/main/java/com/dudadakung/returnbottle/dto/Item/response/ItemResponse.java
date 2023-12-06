package com.dudadakung.returnbottle.dto.Item.response;

public record ItemResponse(
        Long id,
        String name,
        int price,
        String img,
        String description
) {
}
