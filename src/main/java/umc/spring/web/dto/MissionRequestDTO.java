package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistRestaurant;
import umc.spring.validation.annotation.PossibleMission;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class addDTO {
        @ExistRestaurant
        Long restaurant;
        @NotNull
        Long member;
        @PositiveOrZero
        Integer amount;
        @PositiveOrZero
        Integer point;
        @Future
        LocalDate deadline;
    }

    @Getter
    public static class challengeDTO {
        @PossibleMission
        Long id;
    }
}
