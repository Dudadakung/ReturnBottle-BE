package com.dudadakung.returnbottle.dto.reward.response;

public record RewardHistoryResponse(
        Long id,
        String date,
        String time,
        String company,
        int mileageValues,
        String totalMileage
) {
}
