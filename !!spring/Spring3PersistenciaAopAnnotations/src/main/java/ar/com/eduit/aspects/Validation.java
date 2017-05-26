package ar.com.eduit.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component()
public class Validation {
	
	

	
	@Around("execution( public * ar.com.eduit.dao.*.save(..))")
	public Object isNotNull(ProceedingJoinPoint joinpoint){
	   Object firstArg = joinpoint.getArgs()[0];
	   if(firstArg != null){
		   try {
			 System.out.println("ok continuar");   
			return joinpoint.proceed(joinpoint.getArgs());
		} catch (Throwable e) {
		   e.printStackTrace();
		}
	   }else{
		   System.out.println( " parametro no puede ser nulo");
	   }
	   return null;
	}

}
