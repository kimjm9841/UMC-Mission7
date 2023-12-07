package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static ReviewResponseDTO.writeResultDTO toWriteResultDTO(Review review){
        return ReviewResponseDTO.writeResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.writeDTO request){
        return Review.builder()
                .rating(request.getRating())
                .body(request.getBody())
                .image(request.getImage())
                .createdAt(LocalDate.now())
                .build();
    }

}
