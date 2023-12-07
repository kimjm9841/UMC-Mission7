package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    @Operation(summary = "리뷰 작성 API",description = "새로운 리뷰를 작성하는 API입니다.")
    public ApiResponse<ReviewResponseDTO.writeResultDTO> write(@RequestBody @Valid ReviewRequestDTO.writeDTO request){
        Review review = reviewCommandService.writeReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toWriteResultDTO(review));
    }

}
