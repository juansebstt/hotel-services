package com.hotelservices.application.service.impl;

import com.hotelservices.application.service.HotelService;
import com.hotelservices.domain.request.HotelCreatedRequest;
import com.hotelservices.infrastructure.entity.HotelEntity;
import com.hotelservices.infrastructure.repository.HotelRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final StreamBridge streamBridge;
    private final HotelRedisRepository hotelRedisRepository;

    @Override
    public Mono<Long> createHotel(HotelCreatedRequest request) {
        return Mono.just(request)
                .map(this::mapToEntity)
                .flatMap(this::publishHotel);
    }

    @Override
    public Mono<List<HotelEntity>> getAllHotels() {
        return hotelRedisRepository.findAll()
                .collectList();
    }

    private HotelEntity mapToEntity(HotelCreatedRequest request) {
        return HotelEntity.builder()
                .hotelName(request.getHotelName())
                .build();
    }

    private Mono<Long> publishHotel(HotelEntity hotelEntity) {
        return Mono.just(hotelEntity)
                .doOnNext(hotel -> streamBridge.send("writeCache-out-0", hotel))
                .flatMap(hotel -> Mono.just(1L))
                .switchIfEmpty(Mono.just(0L));
    }


}
