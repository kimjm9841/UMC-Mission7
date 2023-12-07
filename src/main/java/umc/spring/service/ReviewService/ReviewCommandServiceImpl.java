package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.RestaurantRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.web.dto.ReviewRequestDTO;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;

    private final RestaurantRepository restaurantRepository;

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Review writeReview(ReviewRequestDTO.writeDTO request) {

        Review newReview = ReviewConverter.toReview(request);

        newReview.setRestaurant(restaurantRepository.getById(request.getRestaurant()));
        newReview.setMember(memberRepository.findById(request.getMember()).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND)));

        return reviewRepository.save(newReview);
    }

}
