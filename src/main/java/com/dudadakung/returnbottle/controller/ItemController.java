package com.dudadakung.returnbottle.controller;

import com.dudadakung.returnbottle.dto.Item.request.ItemBuyRequestDto;
import com.dudadakung.returnbottle.dto.reward.request.RewardCreateRequestDto;
import com.dudadakung.returnbottle.global.BaseApiResponse;
import com.dudadakung.returnbottle.global.SuccessCode;
import com.dudadakung.returnbottle.service.ItemService;
import com.dudadakung.returnbottle.service.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("")
    public ResponseEntity<BaseApiResponse<?>> getItemList(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseApiResponse.of(SuccessCode.OK, itemService.getItemList()));
    }

    @PostMapping("/buy")
    public ResponseEntity<BaseApiResponse<?>> buyItem(@RequestBody ItemBuyRequestDto itemBuyRequestDto){
        itemService.buyItem(itemBuyRequestDto.itemId(), itemBuyRequestDto.uniqueId());
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseApiResponse.of(SuccessCode.OK));
    }

}
