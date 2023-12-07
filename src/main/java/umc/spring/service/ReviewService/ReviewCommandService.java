package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;

import javax.transaction.Transactional;

public interface ReviewCommandService {
    @Transactional
    Review writeReview(ReviewRequestDTO.writeDTO request);

}
