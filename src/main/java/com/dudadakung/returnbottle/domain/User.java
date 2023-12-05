package com.dudadakung.returnbottle.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "user_email", nullable = false)
    private String email;

    @Column(nullable = false)
    private int mileage;

    // private XXX accounts;
    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    List<Reward> rewards = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<UserItem> items = new ArrayList<>();
}
