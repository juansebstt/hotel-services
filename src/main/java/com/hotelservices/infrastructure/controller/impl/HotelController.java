package com.hotelservices.infrastructure.controller.impl;

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

    @Override
    public Mono<ResponseEntity<Long>> createHotel(HotelCreatedRequest request) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<List<HotelEntity>>> getHotels() {
        return null;
    }
}
