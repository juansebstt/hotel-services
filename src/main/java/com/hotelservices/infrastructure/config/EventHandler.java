package com.hotelservices.infrastructure.config;

import com.hotelservices.infrastructure.entity.HotelEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Configuration
public class EventHandler {

    @Bean
    public Function<Flux<HotelEntity>, Mono<Void>> redisCacheBinding(final WriteCacheProcessor writeCacheProcessor) {
        return writeCacheProcessor;
    }

}
