package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    @Operation(summary = "미션 추가 API",description = "새로운 미션을 추가하는 API입니다.")
    public ApiResponse<MissionResponseDTO.addResultDTO> add(@RequestBody @Valid MissionRequestDTO.addDTO request){
        Mission mission = missionCommandService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddResultDTO(mission));
    }

    @PatchMapping("/challenge")
    @Operation(summary = "미션 도전 API",description = "내가 도전 가능한 미션을 도전으로 변경하는 API입니다.")
    public ApiResponse<MissionResponseDTO.challengeResultDTO> challenge(@RequestBody @Valid MissionRequestDTO.challengeDTO request){
        Mission mission = missionCommandService.challengeMission(request);
        return ApiResponse.onSuccess(MissionConverter.toChallengeResultDTO(mission));
    }

    @PatchMapping("/complete")
    @Operation(summary = "미션 진행 완료 API",description = "내가 진행중인 미션을 진행 완료로 변경하는 API입니다.")
    public ApiResponse<MissionResponseDTO.completeResultDTO> complete(@RequestBody @Valid MissionRequestDTO.completeDTO request){
        Mission mission = missionCommandService.completeMission(request);
        return ApiResponse.onSuccess(MissionConverter.toCompleteResultDTO(mission));
    }
}
