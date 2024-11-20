package com.hotelservices.application.service.impl;

import com.hotelservices.application.service.HotelService;
import com.hotelservices.domain.request.HotelCreatedRequest;
import com.hotelservices.infrastructure.entity.HotelEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Override
    public Mono<Long> createHotel(HotelCreatedRequest request) {
        return null;
    }

    @Override
    public Mono<List<HotelEntity>> getAllHotels() {
        return null;
    }
}
