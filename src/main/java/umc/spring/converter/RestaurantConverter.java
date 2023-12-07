package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantResponseDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantConverter {

    public static RestaurantResponseDTO.registerResultDTO toAddResultDTO(Restaurant restaurant){
        return RestaurantResponseDTO.registerResultDTO.builder()
                .restaurantId(restaurant.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantRequestDTO.registerDTO request){
        return Restaurant.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }

    public static RestaurantResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return RestaurantResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt())
                .body(review.getBody())
                .build();
    }
    public static RestaurantResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        List<RestaurantResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(RestaurantConverter::reviewPreViewDTO).collect(Collectors.toList());

        return RestaurantResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static RestaurantResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return RestaurantResponseDTO.MissionPreViewDTO.builder()
                .ownerNickname(mission.getMember().getName())
                .status(mission.getStatus())
                .amount(mission.getAmount())
                .point(mission.getPoint())
                .deadline(mission.getDeadline())
                .build();
    }
    public static RestaurantResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList){
        List<RestaurantResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(RestaurantConverter::missionPreViewDTO).collect(Collectors.toList());

        return RestaurantResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
