package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


	@Before("com.luv2code.aopdemo.aspect.LuvAOPExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {	
		
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("\n=====>>> Executing @Before advice on method " + getClass() + " ORDER = 2");		
		
		System.out.println("\n Method: " + methodSig);
		
		for(Object arg: theJoinPoint.getArgs()) {
		
			System.out.println("\n Method arguments: " + arg);
		
			if(arg instanceof Account) {
				
				Account theAccount = (Account) arg;
				
				System.out.println("\n Account name: " + theAccount.getName());
				System.out.println("\n Account level: " + theAccount.getLevel());
				
			}
		}
	}
	
}
