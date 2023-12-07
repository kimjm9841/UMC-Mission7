package umc.spring.service.RestaurantService;

import umc.spring.domain.Restaurant;
import umc.spring.web.dto.RestaurantRequestDTO;

import javax.transaction.Transactional;

public interface RestaurantCommandService {

    @Transactional
    Restaurant addRestaurant(RestaurantRequestDTO.registerDTO request);

    boolean existsById(Long value);
}
