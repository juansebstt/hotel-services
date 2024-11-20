package com.hotelservices.infrastructure.controller;

import com.hotelservices.domain.request.HotelCreatedRequest;
import com.hotelservices.infrastructure.entity.HotelEntity;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import java.util.List;

@RequestMapping("/hotel/api")
public interface HotelApi {

    @PostMapping
    Mono<ResponseEntity<Long>> createHotel(@RequestBody @Valid HotelCreatedRequest request);

    @GetMapping
    Mono<ResponseEntity<List<HotelEntity>>> getHotels();

}
