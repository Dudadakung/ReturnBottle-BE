package com.dudadakung.returnbottle.controller;

import com.dudadakung.returnbottle.service.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reward")
@RequiredArgsConstructor
public class RewardController {
    private final RewardService rewardService;


}
