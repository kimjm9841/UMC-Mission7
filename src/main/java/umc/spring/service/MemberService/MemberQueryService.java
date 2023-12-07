package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;

public interface MemberQueryService {

    Page<Review> getReviewList(Long memberId, Integer page);

    Page<Mission> getChallengingMissionList(Long memberId, Integer page);
}
