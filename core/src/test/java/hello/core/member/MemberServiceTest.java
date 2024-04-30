package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MemberServiceTest {

    //    MemberService memberService = new MemberServiceImpl();
    MemberService memberService;


    //테스트 실행전에 실행됨
    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        memberService=appConfig.memberService();
    }

    @Test
    void join() {

        Member memberA = new Member(1L, "memberA", Grade.VIP);

        memberService.join(memberA);

        Member findMemberA = memberService.findById(1L);

        Assertions.assertThat(memberA).isEqualTo(findMemberA);
    }

    @Test
    void findById() {
    }
}