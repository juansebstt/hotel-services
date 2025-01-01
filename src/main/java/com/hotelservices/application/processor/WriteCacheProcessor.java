package com.hotelservices.application.processor;

import com.hotelservices.infrastructure.entity.HotelEntity;
import com.hotelservices.infrastructure.repository.HotelRedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
@Slf4j
@RequiredArgsConstructor
public class WriteCacheProcessor implements Function<Flux<HotelEntity>, Mono<Void>> {

    private final HotelRedisRepository hotelRedisRepository;

    @Override
    public Mono<Void> apply(Flux<HotelEntity> hotelEntityFlux) {
        return hotelEntityFlux
                .doOnNext(hotelEntity -> log.info("Received hotel: {}", hotelEntity))
                .flatMap(hotelRedisRepository::save)
                .onErrorContinue(this::handleError)
                .then();
    }

    private void handleError(Throwable throwable, Object o) {
        log.error("Error occurred while processing hotel: {}", o, throwable);
    }
}
