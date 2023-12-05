package com.dudadakung.returnbottle.service;

import com.dudadakung.returnbottle.domain.User;
import com.dudadakung.returnbottle.dto.User.UserSignUpRequestDto;
import com.dudadakung.returnbottle.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    final private UserRepository userRepository;


    public User saveUser(UserSignUpRequestDto userSignUpRequestDto) {
        String uniqueId = createUniqueId();
        User user = User.createUser(uniqueId, userSignUpRequestDto);
        return userRepository.save(user);
    }

    private String createUniqueId() {
        final String ALLOWED_CHARACTERS = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        Random random = new Random();
        StringBuilder sb = new StringBuilder(10);

        sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(9) + 1));

        for (int i = 1; i < 10; i++) {
            int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());
            sb.append(ALLOWED_CHARACTERS.charAt(randomIndex));
        }

        return sb.toString();
    }

}
