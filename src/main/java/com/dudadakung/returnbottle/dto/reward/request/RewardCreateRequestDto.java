package com.dudadakung.returnbottle.dto.reward.request;

public record RewardCreateRequestDto(
        String uniqueId,
        String company,
        int mileage
) {
}
