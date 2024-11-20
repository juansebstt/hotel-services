package com.hotelservices.application.service;

import com.hotelservices.domain.request.HotelCreatedRequest;
import com.hotelservices.infrastructure.entity.HotelEntity;
import reactor.core.publisher.Mono;

import java.util.List;

public interface HotelService {

    Mono<Long> createHotel(HotelCreatedRequest request);

    Mono<List<HotelEntity>> getAllHotels();

}
