package com.hotelservices.domain.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelCreatedRequest {

    @NotBlank(message = "The new Hotel name cannot be blank")
    @NotNull(message = "The new Hotel name is required")
    @Schema(description = "Gets the name of a new hotel")
    private String hotelName;
}
