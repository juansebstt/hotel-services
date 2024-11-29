package com.hotelservices.infrastructure.config;

import com.hotelservices.infrastructure.entity.HotelEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;

@Configuration
public class RedisConfig {

    @Bean
    @Primary
    public ReactiveRedisConnectionFactory reactiveRedisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("cache", 6379);
        return new LettuceConnectionFactory(config);

    }

    @Bean
    public ReactiveRedisOperations<String, HotelEntity> redisOperations(ReactiveRedisConnectionFactory factory) {


        return new ReactiveRedisOperations<>(factory, new HotelEntityRedisSerializer());
        }

}


