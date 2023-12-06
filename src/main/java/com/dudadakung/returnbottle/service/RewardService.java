package com.dudadakung.returnbottle.service;

import com.dudadakung.returnbottle.domain.Reward;
import com.dudadakung.returnbottle.domain.User;
import com.dudadakung.returnbottle.dto.reward.request.RewardCreateRequestDto;
import com.dudadakung.returnbottle.dto.reward.response.RewardHistoryResponse;
import com.dudadakung.returnbottle.error.exception.EntityNotFoundException;
import com.dudadakung.returnbottle.error.exception.ErrorCode;
import com.dudadakung.returnbottle.repository.RewardRepository;
import com.dudadakung.returnbottle.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RewardService {
    private final RewardRepository rewardRepository;
    private final UserRepository userRepository;


    public List<RewardHistoryResponse> getRewardHistory(String uniqueId){
        User user = userRepository.findByUniqueId(uniqueId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND));

        List<Reward> rewardList = user.getRewards();
        Collections.reverse(rewardList);
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return rewardList.stream()
                .map(reward -> new RewardHistoryResponse(
                        reward.getId(),
                        formatDate(reward.getCreateAt()),
                        formatTime(reward.getCreateAt()),
                        reward.getCompany(),
                        reward.getMileageValues(),
                        decimalFormat.format(reward.getTotalMileage())
                ))
                .collect(Collectors.toList());

    }

    public void saveReward(RewardCreateRequestDto rewardCreateRequestDto){
        User user = userRepository.findByUniqueId(rewardCreateRequestDto.uniqueId())
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND));

        Reward reward = Reward.createReward(user, rewardCreateRequestDto.company(), user.getMileage() + rewardCreateRequestDto.mileage());
        user.modifyMileage(rewardCreateRequestDto.mileage());
        rewardRepository.save(reward);
    }

    private String formatDate(LocalDateTime dateTime) {
        return DateTimeFormatter.ofPattern("MM월 dd일").format(dateTime);
    }

    private String formatTime(LocalDateTime dateTime) {
        return DateTimeFormatter.ofPattern("HH:mm").format(dateTime);
    }
}
