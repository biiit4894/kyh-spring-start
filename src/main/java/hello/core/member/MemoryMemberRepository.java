package hello.core.member;

import java.util.HashMap;
import java.util.Map;

// 원래 인터페이스와 구현체는 서로 다른 패키지에 넣는 것 권장
public class MemoryMemberRepository implements MemberRepository {
    // 실무에서는 동시성 이슈로 ConcurrentHashMap 사용
    private static Map<Long, Member> store = new HashMap<>(); // 저장소
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

}
