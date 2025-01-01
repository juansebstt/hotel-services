package com.hotelservices.infrastructure.repository;

import com.hotelservices.infrastructure.entity.HotelEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class HotelRedisRepository {

    private final ReactiveRedisOperations<String, HotelEntity> redisReactiveOperations;

    public Flux<HotelEntity> findAll() {
        return redisReactiveOperations.opsForList()
                .range("hotel", 0, 1);
    }

    public Mono<Long> save(HotelEntity hotelEntity) {

        hotelEntity.setId(UUID.randomUUID().toString());

        return redisReactiveOperations.opsForList()
                .rightPush("hotel", hotelEntity);
    }
}
