package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionRequestDTO;

import javax.transaction.Transactional;

public interface MissionCommandService {
    @Transactional
    Mission addMission(MissionRequestDTO.addDTO request);

    @Transactional
    Mission challengeMission(MissionRequestDTO.challengeDTO request);

    boolean isPossible(Long value);
}
