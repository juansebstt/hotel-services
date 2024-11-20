package com.hotelservices.infrastructure.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("hotel")
public class HotelEntity {

    @Id
    private String id;

    @NotNull(message = "Hotel name is required")
    @NotBlank(message = "Hotel name cannot be blank")
    @Schema(description = "Add a hotel using an specific name")
    private String hotelName;

}
