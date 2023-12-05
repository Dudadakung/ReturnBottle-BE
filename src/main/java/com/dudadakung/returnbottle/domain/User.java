package com.dudadakung.returnbottle.domain;

import com.dudadakung.returnbottle.dto.User.request.UserSignUpRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "unique_id", nullable = false)
    private String uniqueId;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "user_email", nullable = false)
    private String email;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "num_of_bottles", nullable = false)
    private int numOfBottles;

    @Column(nullable = false)
    private int mileage;

    // private XXX accounts;
    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    List<Reward> rewards = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<UserItem> items = new ArrayList<>();

    public static User createUser(String uniqueId, UserSignUpRequestDto userSignUpRequestDto) {
        User user = User.builder()
                .uniqueId(uniqueId)
                .name(userSignUpRequestDto.name())
                .email(userSignUpRequestDto.email())
                .password(userSignUpRequestDto.password())
                .phoneNumber(userSignUpRequestDto.phoneNumber())
                .build();
        return user;
    }
}
