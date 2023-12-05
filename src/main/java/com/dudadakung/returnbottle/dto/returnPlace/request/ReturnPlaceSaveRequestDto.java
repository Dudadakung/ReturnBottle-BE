package com.dudadakung.returnbottle.dto.returnPlace.request;

import java.math.BigDecimal;

public record ReturnPlaceSaveRequestDto(
        String name,
        String address,
        String hours,
        BigDecimal latitude,
        BigDecimal longitude) {
}
