package com.dudadakung.returnbottle.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Table(name = "reward")
public class Reward extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reward_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String company;

    @Column(name = "mileage_values", nullable = false)
    private int mileageValues;

    @Column(nullable = false)
    private int totalMileage;

    public static Reward createReward(User user, String company, int mileageValues, int totalMileage) {
        return Reward.builder()
                .user(user)
                .company(company)
                .mileageValues(mileageValues)
                .totalMileage(totalMileage)
                .build();
    }
}
