package com.hotelservices.application.service.impl;

import com.hotelservices.application.service.HotelService;
import com.hotelservices.domain.request.HotelCreatedRequest;
import com.hotelservices.infrastructure.entity.HotelEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final StreamBridge streamBridge;

    @Override
    public Mono<Long> createHotel(HotelCreatedRequest request) {
        return Mono.just(request)
                .map(this::mapToEntity)
                .flatMap(this::publishHotel);
    }

    @Override
    public Mono<List<HotelEntity>> getAllHotels() {
        return null;
    }

    private HotelEntity mapToEntity(HotelCreatedRequest request) {
        return HotelEntity.builder()
                .hotelName(request.getHotelName())
                .build();
    }

    private Mono<Long> publishHotel(HotelEntity hotelEntity) {
        return Mono.just(hotelEntity)
                .doOnNext(hotel -> streamBridge.send("hotel-out-0", hotel))
    }


}
