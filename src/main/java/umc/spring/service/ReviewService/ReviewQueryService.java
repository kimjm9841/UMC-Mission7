package umc.spring.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;

import java.util.Optional;

public interface ReviewQueryService {

    Optional<Restaurant> findStore(Long id);

    Page<Review> getReviewList(Long restaurantId, Integer page);
}
