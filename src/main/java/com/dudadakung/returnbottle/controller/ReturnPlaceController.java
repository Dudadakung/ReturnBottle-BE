package com.dudadakung.returnbottle.controller;

import com.dudadakung.returnbottle.dto.returnPlace.request.ReturnPlaceSaveRequestDto;
import com.dudadakung.returnbottle.global.BaseApiResponse;
import com.dudadakung.returnbottle.global.SuccessCode;
import com.dudadakung.returnbottle.service.ReturnPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/place")
@RequiredArgsConstructor
public class ReturnPlaceController {

    private final ReturnPlaceService returnPlaceService;

    @PostMapping("/save")
    public ResponseEntity<BaseApiResponse<?>> saveReturnPlace(@RequestBody ReturnPlaceSaveRequestDto returnPlaceSaveRequestDto) {
        returnPlaceService.saveReturnPlace(returnPlaceSaveRequestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseApiResponse.of(SuccessCode.CREATED));
    }

    @GetMapping("/list")
    public ResponseEntity<BaseApiResponse<?>> getReturnPlaceList(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseApiResponse.of(SuccessCode.OK, returnPlaceService.getReturnPlaceList()));
    }
}
