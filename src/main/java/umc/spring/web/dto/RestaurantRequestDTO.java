package umc.spring.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RestaurantRequestDTO {

    @Getter
    public static class addDTO {
        @NotNull
        Long location;
        @NotNull
        Long foodCategory;
        @NotBlank
        String name;
        @Size(min = 10, max = 30)
        String address;
    }
}
