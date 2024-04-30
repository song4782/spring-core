package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    MemberService memberService;

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        memberService=appConfig.memberService();
    }

    @Test
    void discount() {

            Member memberA =new Member(1l,"memberA", Grade.VIP);
            memberService.join(memberA);

            Member memberB =new Member(2l,"memberB", Grade.BASIC);
            memberService.join(memberB);

            int discountA=discountPolicy.discount(memberA, 20000);
            int discountB=discountPolicy.discount(memberB, 10000);


            Assertions.assertThat(discountA).isEqualTo(2000);
            Assertions.assertThat(discountB).isEqualTo(0);
        }

    }

