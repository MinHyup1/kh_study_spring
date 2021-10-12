package aop03;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyAspect  {
	
	//자바 Reflection : 객체 또는 클래스명을 통해 타입에 대한 정보를 조사할 수 있는 기법
	@Before(value = "execution(* *(..))")
	public void before() {
		System.out.println("출근 카드를 찍는다.");
	}
	@After(value = "execution(* *(..))")
	public void after() {
		System.out.println("집에 간다.");
	}
	@AfterReturning(value = "execution(* *(..))")
	public void afterReturning() {
		System.out.println("퇴근 카드를 찍는다.");
	}
	@AfterThrowing(value = "execution(* *(..))" , throwing = "exception") //예외객체를 받을 메서드 매개변수명
	public void afterThrowing(Exception exception) {
		System.out.println(exception.getMessage());
		System.out.println("쉬는 날이었다.");
	}

	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		
		try {
			invocation.proceed();
		}catch (Exception e) {
			
		}finally {
		}
		
		return null;
	}

}
