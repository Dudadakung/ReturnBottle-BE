package com.dudadakung.returnbottle.controller;

import com.dudadakung.returnbottle.dto.User.request.UserLoginRequestDto;
import com.dudadakung.returnbottle.dto.User.request.UserSignUpRequestDto;
import com.dudadakung.returnbottle.global.BaseApiResponse;
import com.dudadakung.returnbottle.global.SuccessCode;
import com.dudadakung.returnbottle.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<BaseApiResponse<?>> signUp(@RequestBody UserSignUpRequestDto userSignUpRequestDto) {
        userService.saveUser(userSignUpRequestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseApiResponse.of(SuccessCode.CREATED));
    }

    @PostMapping("/login")
    public ResponseEntity<BaseApiResponse<?>> login(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseApiResponse.of(SuccessCode.OK, userService.loginUser(userLoginRequestDto)));
    }

    @GetMapping("/my")
    public ResponseEntity<BaseApiResponse<?>> getMyPage(@RequestParam String uniqueId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseApiResponse.of(SuccessCode.OK, userService.getMyPage(uniqueId)));
    }
}
