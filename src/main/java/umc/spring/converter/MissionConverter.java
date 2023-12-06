package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.addResultDTO toAddResultDTO(Mission mission){
        return MissionResponseDTO.addResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MissionResponseDTO.challengeResultDTO toChallengeResultDTO(Mission mission){
        return MissionResponseDTO.challengeResultDTO.builder()
                .missionId(mission.getId())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.addDTO request){
        return Mission.builder()
                .amount(request.getAmount())
                .point(request.getPoint())
                .deadline(request.getDeadline())
                .build();
    }
}
