package com.dudadakung.returnbottle.service;

import com.dudadakung.returnbottle.domain.Item;
import com.dudadakung.returnbottle.domain.User;
import com.dudadakung.returnbottle.domain.UserItem;
import com.dudadakung.returnbottle.dto.Item.response.ItemResponse;
import com.dudadakung.returnbottle.dto.reward.request.RewardCreateRequestDto;
import com.dudadakung.returnbottle.error.exception.EntityNotFoundException;
import com.dudadakung.returnbottle.error.exception.ErrorCode;
import com.dudadakung.returnbottle.repository.ItemRepository;
import com.dudadakung.returnbottle.repository.UserItemRepository;
import com.dudadakung.returnbottle.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {
    final private ItemRepository itemRepository;
    final private UserRepository userRepository;
    final private UserItemRepository userItemRepository;
    final private RewardService rewardService;

    @Transactional(readOnly = true)
    public List<ItemResponse> getItemList(){
        List<Item> itemList = itemRepository.findAll();

        return itemList.stream()
                .map(item -> new ItemResponse(
                        item.getId(),
                        item.getName(),
                        item.getPrice(),
                        item.getImage_url()
                ))
                .collect(Collectors.toList());
    }

    public void buyItem(Long id, String uniqueId){
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND));

        User user = userRepository.findByUniqueId(uniqueId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND));

        if (user.getMileage() < item.getPrice()){
            throw new EntityNotFoundException(ErrorCode.MILEAGE_NOT_ENOUGH);
        } else {
            RewardCreateRequestDto rewardCreateRequestDto = new RewardCreateRequestDto(uniqueId, "기프티콘 구매", -item.getPrice());
            rewardService.saveReward(rewardCreateRequestDto);
        }

        UserItem userItem = UserItem.createUserItem(user, item);
        userItemRepository.save(userItem);
    }

}
