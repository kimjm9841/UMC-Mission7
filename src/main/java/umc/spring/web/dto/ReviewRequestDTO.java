package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistRestaurant;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ReviewRequestDTO {

    @Getter
    public static class writeDTO {
        @ExistRestaurant
        Long restaurant;
        @NotNull
        Long member;
        @Max(5)
        @NotNull
        Float rating;
        @Size(max = 500)
        String body;
        @Size(max = 200)
        String image;
    }
}
