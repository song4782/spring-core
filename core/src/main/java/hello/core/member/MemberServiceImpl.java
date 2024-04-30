package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //회원 저장소
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {

        memberRepository.save(member);

    }

    @Override
    public Member findById(Long memberId) {

        Member member = memberRepository.findById(memberId);


        return member;
    }
}
