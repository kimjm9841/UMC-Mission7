package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
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
        newMission.setMember(memberRepository.findById(request.getMember()).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND)));

        return missionRepository.save(newMission);
    }
}
