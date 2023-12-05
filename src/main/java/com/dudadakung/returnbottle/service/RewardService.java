package com.dudadakung.returnbottle.service;

import com.dudadakung.returnbottle.repository.RewardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RewardService {
    private final RewardRepository rewardRepository;


}
