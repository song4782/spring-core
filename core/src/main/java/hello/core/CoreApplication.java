package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);

		MemberService memberService = new MemberServiceImpl();

		Member memberA = new Member(1L, "memberA", Grade.VIP);

		memberService.join(memberA);

		Member findMember = memberService.findById(1L);

		System.out.println(findMember.getName());
		System.out.println(memberA.getName());

	}
}

