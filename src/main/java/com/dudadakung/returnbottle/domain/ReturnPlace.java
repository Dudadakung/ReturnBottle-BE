package com.dudadakung.returnbottle.domain;

import com.dudadakung.returnbottle.dto.returnPlace.request.ReturnPlaceSaveRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class ReturnPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "return_place_id")
    private Long id;

    private String name;

    private String address;

    private String hours;

    @Column(precision = 9, scale = 6)
    private BigDecimal latitude;

    @Column(precision = 9, scale = 6)
    private BigDecimal longitude;

    private String possibility;

    public static ReturnPlace createReturnPlace(ReturnPlaceSaveRequestDto returnPlaceSaveRequestDto) {
        return ReturnPlace.builder()
                .name(returnPlaceSaveRequestDto.name())
                .address(returnPlaceSaveRequestDto.address())
                .hours(returnPlaceSaveRequestDto.hours())
                .latitude(returnPlaceSaveRequestDto.latitude())
                .longitude(returnPlaceSaveRequestDto.longitude())
                .build();
    }
}
