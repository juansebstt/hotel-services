package com.hotelservices.application.processor;

import com.hotelservices.infrastructure.entity.HotelEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
@Slf4j
public class WriteCacheProcessor implements Function<Flux<HotelEntity>, Mono<Void>> {

    @Override
    public Mono<Void> apply(Flux<HotelEntity> hotelEntityFlux) {
        return hotelEntityFlux
                .doOnNext(hotelEntity -> log.info("Received hotel: {}", hotelEntity))

                .then();
    }
}
