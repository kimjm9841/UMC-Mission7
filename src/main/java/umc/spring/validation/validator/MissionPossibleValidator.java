package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.validation.annotation.ExistCategories;
import umc.spring.validation.annotation.PossibleMission;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class MissionPossibleValidator implements ConstraintValidator<PossibleMission, Long> {

    private final MissionCommandService missionCommandService;

    @Override
    public void initialize(PossibleMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = missionCommandService.isPossible(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_POSSIBLE.toString()).addConstraintViolation();
        }

        return isValid;

    }
}
