package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.enums.MissionStatus;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    Page<Mission> findAllByRestaurant(Restaurant restaurant, PageRequest pageRequest);

    Page<Mission> findAllByMemberAndStatus(Member member, MissionStatus missionStatus, PageRequest pageRequest);
}
