package com.dudadakung.returnbottle.service;

import com.dudadakung.returnbottle.domain.ReturnPlace;
import com.dudadakung.returnbottle.dto.returnPlace.request.ReturnPlaceSaveRequestDto;
import com.dudadakung.returnbottle.repository.ReturnPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReturnPlaceService {

    private final ReturnPlaceRepository returnPlaceRepository;

    public void saveReturnPlace(ReturnPlaceSaveRequestDto returnPlaceSaveRequestDto){
        ReturnPlace returnPlace = ReturnPlace.createReturnPlace(returnPlaceSaveRequestDto);
        returnPlaceRepository.save(returnPlace);
    }

    public List<ReturnPlace> getReturnPlaceList(){
        return returnPlaceRepository.findAll();
    }
}
