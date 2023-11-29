package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionRequestDTO;

import javax.transaction.Transactional;

public interface MissionCommandService {
    @Transactional
    Mission addMission(MissionRequestDTO.addDTO request);
}
