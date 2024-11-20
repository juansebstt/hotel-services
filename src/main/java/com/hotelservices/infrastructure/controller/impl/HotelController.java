package com.hotelservices.infrastructure.controller.impl;

import com.hotelservices.application.service.HotelService;
import com.hotelservices.domain.request.HotelCreatedRequest;
import com.hotelservices.infrastructure.controller.HotelApi;
import com.hotelservices.infrastructure.entity.HotelEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HotelController implements HotelApi {

    private final HotelService hotelService;

    @Override
    public Mono<ResponseEntity<Long>> createHotel(HotelCreatedRequest request) {
        return hotelService.createHotel(request)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @Override
    public Mono<ResponseEntity<List<HotelEntity>>> getHotels() {
        return hotelService.getAllHotels()
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }
    
}
