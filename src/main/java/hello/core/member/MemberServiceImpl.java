package hello.core.member;

public class MemberServiceImpl implements MemberService {
    // 인터페이스만 가지고 있다면 npe 발생할 것 -> 구현 객체 선택 필요
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);
        // 다형성에 의해 인터페이스가 아니라 MemoryMemberRepository에 있는 오버라이딩된 save가 호출됨
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
