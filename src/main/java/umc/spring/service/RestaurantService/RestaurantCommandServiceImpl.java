package umc.spring.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.apiPayload.exception.handler.LocationHandler;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Restaurant;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.LocationRepository;
import umc.spring.repository.RestaurantRepository;
import umc.spring.web.dto.RestaurantRequestDTO;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

    private final RestaurantRepository restaurantRepository;

    private final LocationRepository locationRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Restaurant addRestaurant(RestaurantRequestDTO.registerDTO request) {

        Restaurant newRestaurant = RestaurantConverter.toRestaurant(request);

        newRestaurant.setLocation(locationRepository.findById(request.getLocation()).orElseThrow(()  -> new LocationHandler(ErrorStatus.LOCATION_NOT_FOUND)));
        newRestaurant.setFoodCategory(foodCategoryRepository.findById(request.getFoodCategory()).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)));

        return restaurantRepository.save(newRestaurant);
    }
}
