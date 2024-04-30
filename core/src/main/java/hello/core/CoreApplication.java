package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
//		SpringApplication.run(CoreApplication.class, args);
//
//		AppConfig appConfig = new AppConfig();

//		MemberService memberService = appConfig.memberService();
//		OrderService orderService = appConfig.orderService();
//
		AnnotationConfigApplicationContext applicationContext= new AnnotationConfigApplicationContext(AppConfig.class);

		MemberService memberService = applicationContext.getBean("memberService",MemberService.class);

		OrderService orderService=applicationContext.getBean("orderService",OrderService.class);

//		MemberService memberService = new MemberServiceImpl();

		Member member = new Member(1L, "memberA", Grade.VIP);

		memberService.join(member);

		Member memberA = memberService.findById(1L);

		System.out.println("memberA:"+ memberA.getName());
		System.out.println("member:"+ member.getName());

		Order order = orderService.createOrder(1L,"testItem",10000);

		System.out.println("order:"+order);

	}
}
