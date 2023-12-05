package com.dudadakung.returnbottle.service;

import com.dudadakung.returnbottle.domain.User;
import com.dudadakung.returnbottle.dto.User.request.UserLoginRequestDto;
import com.dudadakung.returnbottle.dto.User.request.UserSignUpRequestDto;
import com.dudadakung.returnbottle.dto.User.response.MyPageResponseDto;
import com.dudadakung.returnbottle.dto.User.response.UserLoginResponseDto;
import com.dudadakung.returnbottle.error.exception.EntityNotFoundException;
import com.dudadakung.returnbottle.error.exception.ErrorCode;
import com.dudadakung.returnbottle.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    final private UserRepository userRepository;


    public void saveUser(UserSignUpRequestDto userSignUpRequestDto) {
        String uniqueId = createUniqueId();
        User user = User.createUser(uniqueId, userSignUpRequestDto);
        userRepository.save(user);
    }

    public UserLoginResponseDto loginUser(UserLoginRequestDto userLoginRequestDto) {
        String email = userLoginRequestDto.email();
        String password = userLoginRequestDto.password();

        User user = userRepository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND));

        return new UserLoginResponseDto(user.getName(), user.getUniqueId(), user.getMileage());
    }

    private String createUniqueId() {
        final String ALLOWED_CHARACTERS = "1234567890";

        Random random = new Random();
        StringBuilder sb = new StringBuilder(10);

        sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(9) + 1));

        for (int i = 1; i < 10; i++) {
            int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());
            sb.append(ALLOWED_CHARACTERS.charAt(randomIndex));
        }

        return sb.toString();
    }

    public MyPageResponseDto getMyPage(String uniqueId){
        User user = userRepository.findByUnique_Id(uniqueId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND));
        return new MyPageResponseDto(
                user.getName(),
                user.getEmail(),
                user.getNumOfBottles(),
                user.getMileage(),
                user.getItems().size()
        );
    }

}
