package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemortMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //생성자 주입
//    public MemberService memberService() {
//        return new MemberServiceImpl(new MemortMemberRepository());
//    }
//    //생성자 주입
//    public OrderService orderService() {
//        return new OrderServiceImpl(new MemortMemberRepository(), new FixDiscountPolicy()) ;
//    }
        @Bean
        public MemberRepository memberRepository() {
            return new MemortMemberRepository();
            };
        @Bean
        public DiscountPolicy discountPolicy() {
            return new FixDiscountPolicy();
        }
        @Bean
        public MemberService memberService () {
            return new MemberServiceImpl(memberRepository());
        }
        @Bean
        public OrderService orderService () {
            return new OrderServiceImpl(memberRepository(),discountPolicy());
        }
    }