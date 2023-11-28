package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistCategories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        LocalDate birthDate;
        @Size(min = 10, max = 30)
        String address;
        @NotNull
        Boolean locationAgree;
        @NotNull
        Boolean marketingAgree;
        @ExistCategories
        List<Long> preferCategory;
    }
}
