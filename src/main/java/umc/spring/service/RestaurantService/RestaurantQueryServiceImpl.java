package umc.spring.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.RestaurantRepository;
import umc.spring.repository.ReviewRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantQueryServiceImpl implements RestaurantQueryService {

    private final RestaurantRepository restaurantRepository;

    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Restaurant> findStore(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long restaurantId, Integer page) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Page<Review> reviewPage = reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
        return reviewPage;
    }
}
