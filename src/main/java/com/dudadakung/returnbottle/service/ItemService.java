package com.dudadakung.returnbottle.service;

import com.dudadakung.returnbottle.domain.Item;
import com.dudadakung.returnbottle.dto.Item.response.ItemResponse;
import com.dudadakung.returnbottle.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {
    final private ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public List<ItemResponse> getItemList(){
        List<Item> itemList = itemRepository.findAll();

        return itemList.stream()
                .map(item -> new ItemResponse(
                        item.getName(),
                        item.getPrice(),
                        item.getImage_url()
                ))
                .collect(Collectors.toList());
    }

}
