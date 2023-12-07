package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.RestaurantRepository;
import umc.spring.web.dto.MissionRequestDTO;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;

    private final RestaurantRepository restaurantRepository;

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Mission addMission(MissionRequestDTO.addDTO request) {
        Mission newMission = MissionConverter.toMission(request);

        newMission.setRestaurant(restaurantRepository.getById(request.getRestaurant()));
        newMission.setMember(memberRepository.findById(request.getMember()).orElseThrow(() -> new MissionHandler(ErrorStatus.MEMBER_NOT_FOUND)));

        return missionRepository.save(newMission);
    }

    @Override
    @Transactional
    public Mission challengeMission(MissionRequestDTO.challengeDTO request) {
        Mission mission = missionRepository.findById(request.getId()).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        mission.setStatus(MissionStatus.CHALLENGING);

        return missionRepository.save(mission);
    }

    @Override
    @Transactional
    public Mission completeMission(MissionRequestDTO.completeDTO request) {
        Mission mission = missionRepository.findById(request.getId()).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        if (mission.getStatus() != MissionStatus.CHALLENGING)
            throw new MissionHandler(ErrorStatus.MISSION_NOT_CHALLENGING);

        mission.setStatus(MissionStatus.COMPLETE);

        return missionRepository.save(mission);
    }

    @Override
    public boolean isPossible(Long value) {
        Mission mission = missionRepository.findById(value).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        return mission.getStatus() == MissionStatus.POSSIBLE;
    }
}
