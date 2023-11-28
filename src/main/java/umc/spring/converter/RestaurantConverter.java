package umc.spring.converter;

import umc.spring.domain.Restaurant;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantResponseDTO;

import java.time.LocalDateTime;

public class RestaurantConverter {

    public static RestaurantResponseDTO.addResultDTO toAddResultDTO(Restaurant restaurant){
        return RestaurantResponseDTO.addResultDTO.builder()
                .restaurantId(restaurant.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantRequestDTO.addDTO request){
        return Restaurant.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }
}
