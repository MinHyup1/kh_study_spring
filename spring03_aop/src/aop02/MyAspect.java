package aop02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;


@Component
public class MyAspect  {
	
	//자바 Reflection : 객체 또는 클래스명을 통해 타입에 대한 정보를 조사할 수 있는 기법
	public void before() {
		System.out.println("출근 카드를 찍는다.");
	}
	
	public void after() {
		System.out.println("집에 간다.");
	}
	
	public void afterReturning() {
		System.out.println("퇴근 카드를 찍는다.");
	}
	
	public void afterThrowing() {
		System.out.println("쉬는 날이었다.");
	}


}
