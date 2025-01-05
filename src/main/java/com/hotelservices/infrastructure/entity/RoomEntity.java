package com.hotelservices.infrastructure.entity;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("room")
public class RoomEntity {
}
