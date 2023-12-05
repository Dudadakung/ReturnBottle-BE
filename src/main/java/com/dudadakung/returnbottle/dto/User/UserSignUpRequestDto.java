package com.dudadakung.returnbottle.dto.User;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserSignUpRequestDto {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}
